package com.evraz.grasp.service;

import com.evraz.grasp.entity.PaymentDetails;
import com.evraz.grasp.entity.PaymentResult;
import com.evraz.grasp.entity.PaymentType;
import com.evraz.grasp.service.impl.AmExPaymentService;
import com.evraz.grasp.service.impl.MasterCardPaymentService;
import com.evraz.grasp.service.impl.MirPaymentService;
import com.evraz.grasp.service.impl.VisaPaymentService;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class PaymentProcessor {
    private final Map<PaymentType, PaymentService> paymentServices;

    public PaymentProcessor() {
        paymentServices = new EnumMap<>(PaymentType.class);
        paymentServices.put(PaymentType.VISA, new VisaPaymentService());
        paymentServices.put(PaymentType.MASTERCARD, new MasterCardPaymentService());
        paymentServices.put(PaymentType.MIR, new MirPaymentService());
        paymentServices.put(PaymentType.AMEX, new AmExPaymentService());
    }

    public PaymentResult process(PaymentDetails paymentDetails) {
        PaymentType paymentType = paymentDetails.getPaymentType();
        PaymentService service = paymentServices.get(paymentType);
        if (service == null) {
            throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
        return service.processPayment(paymentDetails);
    }
}
