package com.application.hirehub.student.entity;

import com.application.hirehub.student.enums.Education;
import com.application.hirehub.student.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private Long mobile_no;

    private String password;

    @Enumerated(EnumType.STRING)
    private Education education;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Long experience;

    private Long passout_year;
}
