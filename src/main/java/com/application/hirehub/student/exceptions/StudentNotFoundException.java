package com.application.hirehub.student.exceptions;

public class StudentNotFoundException extends RuntimeException{
    
    public StudentNotFoundException(String msg){
        super(msg);
    }
}
