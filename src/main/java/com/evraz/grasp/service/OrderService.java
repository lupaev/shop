package com.evraz.grasp.service;

import com.evraz.grasp.entity.Invoice;
import com.evraz.grasp.entity.Order;
import com.evraz.grasp.entity.PaymentResult;

public interface OrderService {

    Invoice getInvoice(Order order, PaymentResult paymentResult);

}
