package com.simplepicpay.simplepicpay.domain.user;

import com.simplepicpay.simplepicpay.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO userDTO) {
        this.firstName  = userDTO.firstName();
        this.lastName   = userDTO.lastName();
        this.document   = userDTO.document();
        this.email      = userDTO.email();
        this.password   = userDTO.password();
        this.balance    = userDTO.balance();
        this.userType   = userDTO.userType();
    }
}