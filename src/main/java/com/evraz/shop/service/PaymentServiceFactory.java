package com.evraz.shop.service;

import com.evraz.shop.entity.PaymentType;

public abstract class PaymentServiceFactory {
    public abstract PaymentService createPaymentService(PaymentType paymentType);
}
