package com.simplepicpay.simplepicpay.domain.trasactions;

import com.simplepicpay.simplepicpay.domain.user.User;
import com.simplepicpay.simplepicpay.dtos.TransactionDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private LocalDateTime timestamp;

    public Transaction(BigDecimal value, User sender, User receiver) {
        this.amount     = value;
        this.sender     = sender;
        this.receiver   = receiver;
    }
}