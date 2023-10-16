package com.simplepicpay.simplepicpay.controllers;

import com.simplepicpay.simplepicpay.domain.trasactions.Transaction;
import com.simplepicpay.simplepicpay.domain.user.User;
import com.simplepicpay.simplepicpay.dtos.TransactionDTO;
import com.simplepicpay.simplepicpay.dtos.details.TransactionDetailsDTO;
import com.simplepicpay.simplepicpay.dtos.details.UserDetailsDTO;
import com.simplepicpay.simplepicpay.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionDetailsDTO> save(@RequestBody @Valid TransactionDTO trasactionDTO, UriComponentsBuilder uriBuilder) {
        Transaction trasaction = transactionService.createTransaction(trasactionDTO);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(trasaction.getId()).toUri();
        return ResponseEntity.created(uri).body(new TransactionDetailsDTO(trasaction));
    }

    @GetMapping
    public ResponseEntity<List<TransactionDetailsDTO>> getAll() {
        List<Transaction> users = this.transactionService.getAll();
        return ResponseEntity.ok(users.stream().map(TransactionDetailsDTO::new).toList());
    }


}
