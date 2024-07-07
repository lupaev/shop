package com.evraz.grasp.dto;

import lombok.Data;

@Data
public class PaymentDetailsDTO {
    private String creditCardNumber;
    private String cvv;
    private String expirationDate;
    private String cardholderName;
}
