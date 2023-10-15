package com.simplepicpay.simplepicpay.repositories;

import com.simplepicpay.simplepicpay.domain.trasactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
