package com.evraz.shop.service;

import com.evraz.shop.entity.PaymentDetails;
import com.evraz.shop.entity.PaymentResult;

public interface PaymentService {

    PaymentResult processPayment(PaymentDetails paymentDetails);
}
