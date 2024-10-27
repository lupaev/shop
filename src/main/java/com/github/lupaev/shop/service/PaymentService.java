package com.github.lupaev.shop.service;

import com.github.lupaev.shop.entity.PaymentDetails;
import com.github.lupaev.shop.entity.PaymentResult;

public interface PaymentService {

    PaymentResult processPayment(PaymentDetails paymentDetails);
}