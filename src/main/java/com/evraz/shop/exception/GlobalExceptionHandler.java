package com.evraz.shop.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotEnoughQuantityException.class)
    public ResponseEntity<ErrorDetails> handleNotEnoughQuantityException(NotEnoughQuantityException ex) {

        return buildErrorDetailsBody(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<ErrorDetails> handlePaymentException(PaymentException ex) {

        return buildErrorDetailsBody(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPaymentDetailsException.class)
    public ResponseEntity<ErrorDetails> handlePaymentDetailsException(InvalidPaymentDetailsException ex) {

        return buildErrorDetailsBody(ex, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorDetails> buildErrorDetailsBody(Exception ex, HttpStatus status) {
        ErrorDetails errorDetails = new ErrorDetails.ErrorDetailsBuilder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .details(getErrorDetails(ex))
                .build();
        return new ResponseEntity<>(errorDetails, status);
    }

    private String getErrorDetails(Exception ex) {
        if (ex.getCause() != null) {
            return ex.getCause().getMessage();
        }
        return "There are no additional exception details";

    }
}
