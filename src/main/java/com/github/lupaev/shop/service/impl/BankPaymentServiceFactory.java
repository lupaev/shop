package com.github.lupaev.shop.service.impl;

import com.github.lupaev.shop.entity.PaymentType;
import com.github.lupaev.shop.service.PaymentService;
import com.github.lupaev.shop.service.PaymentServiceFactory;

public class BankPaymentServiceFactory extends PaymentServiceFactory {
    @Override
    public PaymentService createPaymentService(PaymentType paymentType) {
        return switch (paymentType) {
            case VISA -> new VisaPaymentService();
            case MASTERCARD -> new MasterCardPaymentService();
            case AMEX -> new AmExPaymentService();
            case MIR -> new MirPaymentService();
            default -> throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        };
    }
}
