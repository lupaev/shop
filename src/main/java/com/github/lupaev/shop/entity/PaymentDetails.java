package com.github.lupaev.shop.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {
    private String creditCardNumber;
    private String cvv;
    private LocalDate expirationDate;
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
