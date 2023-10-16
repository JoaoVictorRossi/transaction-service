package com.simplepicpay.simplepicpay.infra.exceptions;

public class TransactionException extends RuntimeException{

    public TransactionException(String msg) {
        super(msg);
    }
}
