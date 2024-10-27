package com.github.lupaev.shop.dto;

public record PaymentResultDTO(
        boolean successful,
        String transactionNumber,
        String errorMessage)
{}
