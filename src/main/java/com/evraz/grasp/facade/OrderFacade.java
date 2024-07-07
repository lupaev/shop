package com.evraz.grasp.facade;

import com.evraz.grasp.repository.OrderRepository;
import com.evraz.grasp.service.OrderService;
import com.evraz.grasp.service.PaymentProcessor;
import com.evraz.grasp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderRepository orderRepository;
    private final PaymentProcessor paymentProcessor;
    private final OrderService orderService;

}
