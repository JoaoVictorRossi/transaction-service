package com.simplepicpay.simplepicpay.infra.handlers;

import com.simplepicpay.simplepicpay.dtos.ExceptionDTO;
import com.simplepicpay.simplepicpay.infra.exceptions.TransactionException;
import com.simplepicpay.simplepicpay.infra.exceptions.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TransactionControllerExceptionHandler {

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<ExceptionDTO> transactionException(TransactionException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

}
