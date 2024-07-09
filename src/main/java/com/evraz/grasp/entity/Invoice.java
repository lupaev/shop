package com.evraz.grasp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "INVOICE")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double paymentAmount;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDERS_ID")
    private Order order;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PAYMENT_RESULT_ID")
    private PaymentResult paymentResult;
}
