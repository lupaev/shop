package com.evraz.grasp.dto;

import lombok.Data;

public record PaymentResultDTO(
        boolean successful,
        String transactionNumber,
        String errorMessage)
{}
