package com.simplepicpay.simplepicpay.services;

import com.simplepicpay.simplepicpay.domain.user.User;
import com.simplepicpay.simplepicpay.domain.user.UserType;
import com.simplepicpay.simplepicpay.infra.exceptions.TransactionException;
import com.simplepicpay.simplepicpay.infra.exceptions.UserException;
import com.simplepicpay.simplepicpay.repositories.UserRepository;
import com.simplepicpay.simplepicpay.validators.transaction.ValidatorTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found."));
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public void updateUsersBalance(User sender, User receiver, BigDecimal amount) {
        sender.setBalance( sender.getBalance().subtract(amount) );
        receiver.setBalance( receiver.getBalance().add(amount) );
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

}
