package com.evraz.shop.service;

import com.evraz.shop.entity.PaymentDetails;
import com.evraz.shop.entity.PaymentResult;
import com.evraz.shop.entity.PaymentType;
import com.evraz.shop.exception.PaymentException;
import com.evraz.shop.service.impl.*;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {
    private final PaymentServiceFactory factory = new BankPaymentServiceFactory();

    public PaymentResult process(PaymentDetails paymentDetails) {
        PaymentType paymentType = paymentDetails.getPaymentType();
        PaymentService service = factory.createPaymentService(paymentType);
        if (service == null) {
            throw new PaymentException("Unsupported payment type: " + paymentType);
        }
        return service.processPayment(paymentDetails);
    }
}
