package com.evraz.grasp.facade;

import com.evraz.grasp.dto.InvoiceDTO;
import com.evraz.grasp.dto.ShoppingCartDTO;
import com.evraz.grasp.entity.*;
import com.evraz.grasp.exception.NotEnoughQuantityException;
import com.evraz.grasp.mapper.InvoiceMapper;
import com.evraz.grasp.mapper.ShoppingCartMapper;
import com.evraz.grasp.repository.InvoiceRepository;
import com.evraz.grasp.repository.OrderItemRepository;
import com.evraz.grasp.repository.OrderRepository;
import com.evraz.grasp.repository.PaymentResultRepository;
import com.evraz.grasp.service.OrderService;
import com.evraz.grasp.service.PaymentProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderRepository orderRepository;
    private final InvoiceRepository invoiceRepository;
    private final OrderItemRepository orderItemRepository;
    private final PaymentResultRepository paymentResultRepository;
    private final PaymentProcessor paymentProcessor;
    private final OrderService orderService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final InvoiceMapper invoiceMapper;


    public InvoiceDTO processOrder(ShoppingCartDTO shoppingCartDTO) {
        com.evraz.grasp.entity.ShoppingCart shoppingCart = shoppingCartMapper.convertToShoppingCart(shoppingCartDTO);
        Order order = shoppingCart.getOrder();

        validateOrderItems(order);

        PaymentResult paymentResult = processPayment(shoppingCart.getPaymentDetails());

        Invoice invoice = createAndSaveInvoice(order, paymentResult);

        updateOrderItems(order);
        orderRepository.save(order);
        paymentResultRepository.save(paymentResult);

        return invoiceMapper.toDTO(invoice);
    }


    private void validateOrderItems(Order order) {
        //Имитация проверки кол-ва товаров на складе
        int sumOfOrder = order.getItems().stream().mapToInt(OrderItem::getQuantity).sum();
        Integer sumOfQuantities = orderItemRepository.sumOfQuantities();
        if (sumOfQuantities == null || sumOfOrder > sumOfQuantities) {
            throw new NotEnoughQuantityException("Not enough quantities");
        }
    }

    private PaymentResult processPayment(PaymentDetails paymentDetails) {
        return paymentProcessor.process(paymentDetails);
    }

    private Invoice createAndSaveInvoice(Order order, PaymentResult paymentResult) {
        Invoice invoice = orderService.getInvoice(order, paymentResult);
        invoiceRepository.save(invoice);
        return invoice;
    }

    private void updateOrderItems(Order order) {
        List<OrderItem> items = order.getItems();
        items.forEach(orderItem -> orderItem.setOrder(order));
        orderItemRepository.saveAll(items);
    }

}
