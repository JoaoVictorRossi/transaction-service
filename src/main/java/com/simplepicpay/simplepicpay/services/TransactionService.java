package com.simplepicpay.simplepicpay.services;

import com.simplepicpay.simplepicpay.domain.trasactions.Transaction;
import com.simplepicpay.simplepicpay.domain.user.User;
import com.simplepicpay.simplepicpay.dtos.TransactionDTO;
import com.simplepicpay.simplepicpay.repositories.TransactionRepository;
import com.simplepicpay.simplepicpay.validators.transaction.ValidatorTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private List<ValidatorTransaction> validations;

    public Transaction createTransaction(TransactionDTO dataTransaction) {
        User sender = this.userService.findUserById(dataTransaction.senderId());
        User receiver = this.userService.findUserById(dataTransaction.receiverId());

        this.validations.forEach(v -> v.validate(sender, dataTransaction.value()));
        Transaction transaction = new Transaction(dataTransaction.value(), sender, receiver);

        this.userService.updateUsersBalance(sender, receiver, dataTransaction.value());
        return this.transactionRepository.save(transaction);
    }

}
