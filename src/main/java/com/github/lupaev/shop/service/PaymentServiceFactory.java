package com.github.lupaev.shop.service;

import com.github.lupaev.shop.entity.PaymentType;

public abstract class PaymentServiceFactory {
    public abstract PaymentService createPaymentService(PaymentType paymentType);
}
