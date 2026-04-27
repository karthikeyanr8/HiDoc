package com.hidoc.consultationtool.ExceptionHandling;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
