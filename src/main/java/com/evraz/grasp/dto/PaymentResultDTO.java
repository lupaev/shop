package com.evraz.grasp.dto;

import lombok.Data;

@Data
public class PaymentResultDTO {
    private boolean successful;
    private String transactionNumber;
    private String errorMessage;
}
