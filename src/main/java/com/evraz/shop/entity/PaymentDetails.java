package com.evraz.shop.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {
    private String creditCardNumber;
    private String cvv;
    private String expirationDate;
    private String cardholderName;
    private PaymentType paymentType;

    public PaymentType getPaymentType() {
        if (creditCardNumber == null || creditCardNumber.isEmpty()) {
            return PaymentType.UNKNOWN;
        }
        char firstDigit = creditCardNumber.charAt(0);
        return switch (firstDigit){
            case '4' -> PaymentType.VISA;
            case '5' -> PaymentType.MASTERCARD;
            case '3' -> PaymentType.AMEX;
            case '2' -> PaymentType.MIR;
            default -> PaymentType.UNKNOWN;
        };
    }
}
