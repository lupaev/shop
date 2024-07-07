package com.evraz.grasp.service;

import com.evraz.grasp.dto.PaymentDetailsDTO;
import com.evraz.grasp.entity.PaymentDetails;
import com.evraz.grasp.entity.PaymentResult;

public interface PaymentService {

    PaymentResult processPayment(PaymentDetails paymentDetails);
}
