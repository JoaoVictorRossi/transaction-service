package com.simplepicpay.simplepicpay.dtos.details;

import com.simplepicpay.simplepicpay.domain.user.User;
import com.simplepicpay.simplepicpay.domain.user.UserType;

public record UserDetailsDTO(
        Long id,
        String name,
        String email,
        String document,
        UserType userType) {

    public UserDetailsDTO(User user) {
        this(user.getId(), (user.getFirstName() + " " + user.getLastName()),
                user.getEmail(), user.getDocument(), user.getUserType());
    }

}
