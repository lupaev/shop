package com.evraz.shop.service.impl;

import com.evraz.shop.entity.PaymentDetails;
import com.evraz.shop.entity.PaymentResult;
import com.evraz.shop.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MirPaymentService implements PaymentService {

    @Override
    public PaymentResult processPayment(PaymentDetails paymentDetails) {
        // Имитация успешного платежа
        boolean paymentSuccessful = true;
        String transactionId = UUID.randomUUID().toString();

        return new PaymentResult(paymentSuccessful, transactionId);
    }
}
