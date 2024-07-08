package com.evraz.grasp.service.impl;

import com.evraz.grasp.entity.Invoice;
import com.evraz.grasp.entity.Order;
import com.evraz.grasp.entity.OrderItem;
import com.evraz.grasp.entity.PaymentResult;
import com.evraz.grasp.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Invoice getInvoice(Order order, PaymentResult paymentResult) {
        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setPaymentResult(paymentResult);
        invoice.setPaymentAmount(order.getItems().stream().mapToDouble(OrderItem::getPrice).sum());
        return invoice;
    }
}
