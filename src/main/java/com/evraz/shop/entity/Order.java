package com.evraz.shop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> items;


//    @Override
//    public Order clone() {
//        try {
//            Order cloned = (Order) super.clone();
//            cloned.items = new ArrayList<>();
//            for (OrderItem item : this.items) {
//                cloned.items.add(item.clone());
//            }
//            return cloned;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }
}
