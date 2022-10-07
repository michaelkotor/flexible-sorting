package com.kotor.backend.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value
            = { IllegalArgumentException.class, IllegalStateException.class, RuntimeException.class })
    protected ResponseEntity<Object> handleConflict() {
        String bodyOfResponse = "Unexpected exception. Please, contact administrator";
        return ResponseEntity.badRequest().body(bodyOfResponse);
    }

}
