package com.evraz.shop.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotEnoughQuantityException.class)
    public ResponseEntity<ErrorDetails> handleNotEnoughQuantityException(NotEnoughQuantityException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails.Builder()
                .withTimestamp(LocalDate.now())
                .withMessage(ex.getMessage())
                .withDetails(request.getDescription(false))
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<ErrorDetails> handlePaymentException(PaymentException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails.Builder()
                .withTimestamp(LocalDate.now())
                .withMessage(ex.getMessage())
                .withDetails(request.getDescription(false))
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPaymentDetailsException.class)
    public ResponseEntity<ErrorDetails> handlePaymentDetailsException(InvalidPaymentDetailsException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails.Builder()
                .withTimestamp(LocalDate.now())
                .withMessage(ex.getMessage())
                .withDetails(request.getDescription(false))
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
