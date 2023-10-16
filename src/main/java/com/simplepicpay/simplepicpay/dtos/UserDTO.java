package com.simplepicpay.simplepicpay.dtos;

import com.simplepicpay.simplepicpay.domain.user.UserType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record UserDTO(

        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")
        String document,

        @Min(value = 1)
        BigDecimal balance,

        @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
        String email,

        @NotBlank
        String password,

        UserType userType) {
}
