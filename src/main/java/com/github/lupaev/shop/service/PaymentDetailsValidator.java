package com.github.lupaev.shop.service;

import com.github.lupaev.shop.entity.PaymentDetails;

public interface PaymentDetailsValidator {

    void validate(PaymentDetails paymentDetails);
}
