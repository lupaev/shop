package com.evraz.grasp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ORDERS_ITEMS")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDERS_ID")
    private Order order;


}
