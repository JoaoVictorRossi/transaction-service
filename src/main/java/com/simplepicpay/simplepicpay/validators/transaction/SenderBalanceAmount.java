package com.simplepicpay.simplepicpay.validators.transaction;

import com.simplepicpay.simplepicpay.domain.user.User;
import com.simplepicpay.simplepicpay.infra.exceptions.TransactionException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SenderBalanceAmount implements ValidatorTransaction{

    @Override
    public void validate(User sender, BigDecimal amount) {
        if (sender.getBalance().compareTo(amount) < 0)
            throw new TransactionException("Sender ("+ sender.getId() +") with insufficient balance.");

    }

}
