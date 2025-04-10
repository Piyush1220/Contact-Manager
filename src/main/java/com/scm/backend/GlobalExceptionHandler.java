package com.scm.backend;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
@RestControllerAdvice
public class GlobalExceptionHandler {

    //this class is used for handle the error message just like user name required when we not put user name then show message

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String,String>> handleConstraintViolation(ConstraintViolationException exception) {


        Map<String, String> errors = new LinkedHashMap<>();

        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        constraintViolations.forEach( constraintViolation -> {
            String nameProperty = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            errors.put(nameProperty,message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
