package com.evraz.shop.service;

import com.evraz.shop.entity.Invoice;
import com.evraz.shop.entity.Order;
import com.evraz.shop.entity.PaymentResult;

public interface OrderService {

    Invoice getInvoice(Order order, PaymentResult paymentResult);

}
