package com.application.hirehub.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.hirehub.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
