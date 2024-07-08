package com.evraz.grasp.service;

import com.evraz.grasp.entity.Invoice;
import com.evraz.grasp.entity.Order;
import com.evraz.grasp.entity.OrderItem;
import com.evraz.grasp.entity.PaymentResult;

import java.util.List;

public interface OrderService {

    Invoice getInvoice(Order order, PaymentResult paymentResult);

}
