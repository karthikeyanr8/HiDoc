package com.hidoc.consultationtool.ExceptionHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<?> docNotFound(DoctorNotFoundException doctorNotFoundException)
    {
        return ResponseEntity.status(400)
                .body(doctorNotFoundException.getMessage());
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<?> patientNotFound(PatientNotFoundException patientNotFoundException)
    {
        return  ResponseEntity.status(400)
                .body(patientNotFoundException.getMessage());
    }
}
