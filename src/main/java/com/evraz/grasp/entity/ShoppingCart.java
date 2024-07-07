package com.evraz.grasp.entity;

import java.util.List;

public class ShoppingCart {

    private List<Order> orders;

    public Order createOrder() {
        Order order = new Order();
        orders.add(order);
        return order;
    }
}
