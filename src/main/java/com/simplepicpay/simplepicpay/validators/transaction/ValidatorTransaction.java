package com.simplepicpay.simplepicpay.validators.transaction;

import com.simplepicpay.simplepicpay.domain.user.User;

import java.math.BigDecimal;

public interface ValidatorTransaction {

    void validate(User user, BigDecimal amount);

}
