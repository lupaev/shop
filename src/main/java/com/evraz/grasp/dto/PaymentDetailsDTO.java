package com.evraz.grasp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentDetailsDTO {
    @NotNull
    private String creditCardNumber;
    @NotNull
    private String cvv;
    @NotNull
    private String expirationDate;
    @NotNull
    private String cardholderName;
}
