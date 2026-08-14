package com.arthur_souto.desafio_itau.adapter.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleBadRequest() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<?> handleInvalidJson() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
