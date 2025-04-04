package com.example.propertymanagement.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler (RuntimeException.class)
    public ResponseEntity<String> handleRuntime(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<List<String>> handleException(MethodArgumentNotValidException manv) {

        List<FieldError> fieldErrors = manv.getBindingResult().getFieldErrors();
        List<String> errors = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            logger.info("FieldError: {}", fieldError.getField());
            errors.add(fieldError.getDefaultMessage());
        }


        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
