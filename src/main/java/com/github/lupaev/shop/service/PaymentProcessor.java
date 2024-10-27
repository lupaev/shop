package com.github.lupaev.shop.service;

import com.github.lupaev.shop.entity.PaymentDetails;
import com.github.lupaev.shop.entity.PaymentResult;
import com.github.lupaev.shop.entity.PaymentType;
import com.github.lupaev.shop.exception.PaymentException;
import com.github.lupaev.shop.service.impl.BankPaymentServiceFactory;
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
