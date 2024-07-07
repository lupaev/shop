package com.evraz.grasp.entity;

import lombok.Data;

@Data
public class PaymentResult {
    private boolean isSuccessful;
    private String transactionId;
    private String errorMessage;


    public PaymentResult(boolean successful, String transactionId) {
        this.isSuccessful = successful;
        this.transactionId = transactionId;
    }
}
