package com.evraz.grasp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

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
