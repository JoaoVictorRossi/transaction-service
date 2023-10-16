package com.simplepicpay.simplepicpay.dtos.details;

import com.simplepicpay.simplepicpay.domain.trasactions.Transaction;
import com.simplepicpay.simplepicpay.domain.user.User;

import java.math.BigDecimal;

public record TransactionDetailsDTO(BigDecimal amount, Long senderId, Long receiverId) {

    public TransactionDetailsDTO(Transaction transaction) {
        this(transaction.getAmount(), transaction.getSender().getId(), transaction.getReceiver().getId());
    }

}
