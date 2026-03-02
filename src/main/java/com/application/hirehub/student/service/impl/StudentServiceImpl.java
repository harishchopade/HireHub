package com.application.hirehub.student.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.application.hirehub.student.dto.StudentDto;
import com.application.hirehub.student.entity.Student;
import com.application.hirehub.student.exceptions.StudentNotFoundException;
import com.application.hirehub.student.repository.StudentRepository;
import com.application.hirehub.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void createStudent(Student student) {
       studentRepository.save(student);
    }   

    @Override
    public void updateStudent(long id, StudentDto studentDto) {
        
        Student student = studentRepository.findById(id).orElseThrow(() -> 
            new StudentNotFoundException(
                "Student not found for id: " + id
            )
        );

        if (student != null) {
            if (studentDto.getName() != null) {
                student.setName(studentDto.getName());
            }

            if (studentDto.getMobile_no() != null) {
                student.setMobile_no(studentDto.getMobile_no());
            }

            if (studentDto.getEducation() != null) {
                student.setEducation(studentDto.getEducation());
            }

            if (studentDto.getGender() != null) {
                student.setGender(studentDto.getGender());
            }

            if(studentDto.getExperience() != null) {
                student.setExperience(studentDto.getExperience());
            }

            if (studentDto.getPassout_year() != null) {
                student.setPassout_year(studentDto.getPassout_year());
            }

            studentRepository.save(student);
        }                
    }

    @Override
    public boolean deleteStudent(long id) {           
        try {            
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
