package com.evraz.shop.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT_RESULT")
public class PaymentResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean successful;
    private String transactionNumber;
    private String errorMessage;

    public PaymentResult(boolean successful, String transactionNumber) {
        this.successful = successful;
        this.transactionNumber = transactionNumber;
    }
}
