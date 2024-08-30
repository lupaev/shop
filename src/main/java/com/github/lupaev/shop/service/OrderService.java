package com.github.lupaev.shop.service;

import com.github.lupaev.shop.entity.Invoice;
import com.github.lupaev.shop.entity.Order;
import com.github.lupaev.shop.entity.PaymentResult;

public interface OrderService {

    Invoice getInvoice(Order order, PaymentResult paymentResult);

}
