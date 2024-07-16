package com.evraz.shop.dto;

import jakarta.validation.constraints.NotNull;

public record PaymentDetailsDTO(
        @NotNull
        String creditCardNumber,
        @NotNull
        String cvv,
        @NotNull
        String expirationDate,
        @NotNull
        String cardholderName)
{}
