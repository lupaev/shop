package com.evraz.grasp.service.impl;

import com.evraz.grasp.entity.Order;
import com.evraz.grasp.entity.OrderItem;
import com.evraz.grasp.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(List<OrderItem> items) {
        Order order = new Order();
        order.setItems(items);
        return order;
    }
}
