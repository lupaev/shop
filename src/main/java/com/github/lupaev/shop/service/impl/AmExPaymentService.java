package com.github.lupaev.shop.service.impl;

import com.github.lupaev.shop.entity.PaymentDetails;
import com.github.lupaev.shop.entity.PaymentResult;
import com.github.lupaev.shop.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AmExPaymentService implements PaymentService {

    @Override
    public PaymentResult processPayment(PaymentDetails paymentDetails) {
        // Имитация успешного платежа
        boolean paymentSuccessful = true;
        String transactionId = UUID.randomUUID().toString();

        return new PaymentResult(paymentSuccessful, transactionId);
    }
}
