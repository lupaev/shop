package com.github.lupaev.shop.service.impl;

import com.github.lupaev.shop.entity.Invoice;
import com.github.lupaev.shop.entity.Order;
import com.github.lupaev.shop.entity.OrderItem;
import com.github.lupaev.shop.entity.PaymentResult;
import com.github.lupaev.shop.service.OrderService;
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
