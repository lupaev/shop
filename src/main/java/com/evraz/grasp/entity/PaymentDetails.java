package com.evraz.grasp.entity;

import lombok.Data;

@Data
public class PaymentDetails {
    private String creditCardNumber;
    private String cvv;
    private String expirationDate;
    private String cardholderName;
}
