package com.application.hirehub.student.dto;

import com.application.hirehub.student.enums.Education;
import com.application.hirehub.student.enums.Gender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String name;

    private Long mobile_no;

    @Enumerated(EnumType.STRING)
    private Education education;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Long experience;

    private Long passout_year;
}
