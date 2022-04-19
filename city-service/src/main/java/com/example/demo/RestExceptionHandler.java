package com.example.demo;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<?> handleNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleException() {
        return ResponseEntity.internalServerError().build();
    }
    
}
