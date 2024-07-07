package com.evraz.grasp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "INVOICE")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double paymentAmount;

    @OneToOne(mappedBy = "invoice", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Order order;

    @OneToOne
    private PaymentResult paymentResult;
}
