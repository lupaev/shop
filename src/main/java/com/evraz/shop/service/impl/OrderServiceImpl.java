package com.evraz.shop.service.impl;

import com.evraz.shop.entity.Invoice;
import com.evraz.shop.entity.Order;
import com.evraz.shop.entity.OrderItem;
import com.evraz.shop.entity.PaymentResult;
import com.evraz.shop.service.OrderService;
import org.springframework.stereotype.Service;

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
