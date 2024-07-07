package com.evraz.grasp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<OrderItem> items;

    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Invoice invoice;
}