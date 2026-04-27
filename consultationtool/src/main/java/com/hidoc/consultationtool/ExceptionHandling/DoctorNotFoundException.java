package com.hidoc.consultationtool.ExceptionHandling;

public class DoctorNotFoundException extends RuntimeException{

    public DoctorNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
