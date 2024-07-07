package com.evraz.grasp.dto;

import lombok.Data;

@Data
public class PaymentResultDTO {
    private boolean isSuccessful;
    private String transactionId;
    private String errorMessage;


    public PaymentResultDTO(boolean successful, String transactionId) {
        this.isSuccessful = successful;
        this.transactionId = transactionId;
    }
}
