package com.hidoc.consultationtool.ExceptionHandling;

public class InvalidTimeException extends RuntimeException {

    public InvalidTimeException(String errorMessage){
        super(errorMessage);
    }
}
