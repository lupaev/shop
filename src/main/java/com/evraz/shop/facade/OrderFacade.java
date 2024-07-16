package com.evraz.shop.facade;

import com.evraz.shop.dto.InvoiceDTO;
import com.evraz.shop.dto.ShoppingCartDTO;
import com.evraz.shop.entity.*;
import com.evraz.shop.exception.NotEnoughQuantityException;
import com.evraz.shop.mapper.InvoiceMapper;
import com.evraz.shop.mapper.ShoppingCartMapper;
import com.evraz.shop.repository.InvoiceRepository;
import com.evraz.shop.repository.OrderItemRepository;
import com.evraz.shop.repository.OrderRepository;
import com.evraz.shop.repository.PaymentResultRepository;
import com.evraz.shop.service.OrderService;
import com.evraz.shop.service.PaymentProcessor;
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
        com.evraz.shop.entity.ShoppingCart shoppingCart = shoppingCartMapper.convertToShoppingCart(shoppingCartDTO);
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
