package com.application.hirehub.student.service;

import java.util.List;

import com.application.hirehub.student.dto.StudentDto;
import com.application.hirehub.student.entity.Student;

public interface StudentService {

    List<Student> findAllStudents();
    
    void createStudent(Student student);

    void updateStudent(long id, StudentDto studentDto);

    boolean deleteStudent(long id);
}
