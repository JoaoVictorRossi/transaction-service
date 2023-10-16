package com.simplepicpay.simplepicpay.validators.transaction;

import com.simplepicpay.simplepicpay.domain.user.User;
import com.simplepicpay.simplepicpay.domain.user.UserType;
import com.simplepicpay.simplepicpay.infra.exceptions.TransactionException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransactionByUserType implements ValidatorTransaction{

    @Override
    public void validate(User user, BigDecimal amount) {
        if(user.getUserType() == UserType.MERCHANT )
            throw new TransactionException("Merchant users can't do trasactions.");
    }

}
