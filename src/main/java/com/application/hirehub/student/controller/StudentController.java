package com.application.hirehub.student.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.hirehub.student.dto.StudentDto;
import com.application.hirehub.student.entity.Student;
import com.application.hirehub.student.exceptions.StudentNotFoundException;
import com.application.hirehub.student.repository.StudentRepository;
import com.application.hirehub.student.service.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {
        
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository, StudentService studentService){        
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @PostMapping("/createStudent")
    public ResponseEntity<String> createStudent(@RequestBody Student student){

        try {
            studentService.createStudent(student);
            return new ResponseEntity<>("Student Created Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add student "+ e,HttpStatus.BAD_REQUEST);
        }        
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable long id, @RequestBody StudentDto studentDto){
        
        try {
            studentService.updateStudent(id, studentDto);
            return ResponseEntity.status(HttpStatus.OK).body("Student Updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update patient"+ e);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@PathVariable long id){

        Student student = studentRepository.findById(id).orElseThrow(
            () -> new StudentNotFoundException( "Student not found for id: " + id)
        );

        if(student != null){
            boolean deleted = studentService.deleteStudent(id);
            
            if (deleted) {
                return new ResponseEntity<>("Student Deleted Successfully", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Failed to delete, student not found", HttpStatus.NOT_FOUND);
        
    }
}
