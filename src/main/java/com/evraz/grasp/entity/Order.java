package com.evraz.grasp.entity;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private List<OrderItem> items;

    public double calculateTotalPrice() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
