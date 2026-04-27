package com.hidoc.consultationtool.ExceptionHandling;


public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String errorMessage)
    {
        super(errorMessage);
    }
}
