package com.github.szysza26.bikecatalog.bike.controller;

import com.github.szysza26.bikecatalog.bike.exception.BikeNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
public class ResponseBikeExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String DEFAULT_ERROR_MESSAGE = "Something went wrong.";

    @ExceptionHandler(value = BikeNotFoundException.class)
    protected ResponseEntity<Map<String, String>> handleException(BikeNotFoundException exception) {
        Map<String, String> message = new HashMap<>();
        message.put("message", exception.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Map<String, String>> handleException(Exception exception) {
        Map<String, String> message = new HashMap<>();
        message.put("message", DEFAULT_ERROR_MESSAGE);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> messages = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getDefaultMessage()).toList();
        return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
    }
}
