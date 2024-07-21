package com.evraz.shop.dto;

public record PaymentResultDTO(
        boolean successful,
        String transactionNumber,
        String errorMessage)
{}
