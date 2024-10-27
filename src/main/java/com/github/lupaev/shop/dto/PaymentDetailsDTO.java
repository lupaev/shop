package com.github.lupaev.shop.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PaymentDetailsDTO(
        @NotNull
        String creditCardNumber,
        @NotNull
        String cvv,
        @NotNull
        LocalDate expirationDate,
        @NotNull
        String cardholderName)
{}
