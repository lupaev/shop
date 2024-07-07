package com.evraz.grasp.service.impl;

import com.evraz.grasp.entity.PaymentDetails;
import com.evraz.grasp.entity.PaymentResult;
import com.evraz.grasp.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MasterCardPaymentService implements PaymentService {
    @Override
    public PaymentResult processPayment(PaymentDetails paymentDetails) {
        // Имитация успешного платежа
        boolean paymentSuccessful = true;
        String transactionId = UUID.randomUUID().toString();

        return new PaymentResult(paymentSuccessful, transactionId);
    }
}
