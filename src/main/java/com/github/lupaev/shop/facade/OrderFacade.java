package com.github.lupaev.shop.facade;

import com.github.lupaev.shop.dto.InvoiceDTO;
import com.github.lupaev.shop.dto.ShoppingCartDTO;
import com.github.lupaev.shop.entity.*;
import com.github.lupaev.shop.exception.NotEnoughQuantityException;
import com.github.lupaev.shop.mapper.InvoiceMapper;
import com.github.lupaev.shop.mapper.ShoppingCartMapper;
import com.github.lupaev.shop.repository.InvoiceRepository;
import com.github.lupaev.shop.repository.OrderItemRepository;
import com.github.lupaev.shop.repository.OrderRepository;
import com.github.lupaev.shop.repository.PaymentResultRepository;
import com.github.lupaev.shop.service.OrderService;
import com.github.lupaev.shop.service.PaymentDetailsValidator;
import com.github.lupaev.shop.service.PaymentProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderFacade {

    private final OrderRepository orderRepository;
    private final InvoiceRepository invoiceRepository;
    private final OrderItemRepository orderItemRepository;
    private final PaymentResultRepository paymentResultRepository;
    private final PaymentProcessor paymentProcessor;
    private final OrderService orderService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final InvoiceMapper invoiceMapper;
    private final PaymentDetailsValidator paymentDetailsValidator;


    public InvoiceDTO processOrder(ShoppingCartDTO shoppingCartDTO) {
        log.info("Processing order for shopping cart: {}", shoppingCartDTO);
        ShoppingCart shoppingCart = shoppingCartMapper.convertToShoppingCart(shoppingCartDTO);
        Order order = shoppingCart.getOrder();
        PaymentDetails paymentDetails = shoppingCart.getPaymentDetails();

        paymentDetailsValidator.validate(paymentDetails);

        validateOrderItems(order);

        PaymentResult paymentResult = processPayment(paymentDetails);

        Invoice invoice = createAndSaveInvoice(order, paymentResult);

        updateOrderItems(order);
        orderRepository.save(order);
        paymentResultRepository.save(paymentResult);

        InvoiceDTO invoiceDTO = invoiceMapper.toDTO(invoice);
        log.info("Order processed successfully for shopping cart: {}", shoppingCartDTO);
        return invoiceDTO;
    }

    private void validateOrderItems(Order order) {
        log.info("Validating order items for order: {}", order);
        int sumOfOrder = order.getItems().stream().mapToInt(OrderItem::getQuantity).sum();
        Integer sumOfQuantities = orderItemRepository.sumOfQuantities();
        if (sumOfQuantities == null || sumOfOrder > sumOfQuantities) {
            log.error("Not enough quantities for order: {}", order);
            throw new NotEnoughQuantityException("Not enough quantities");
        }
        log.info("Order items validated successfully for order: {}", order);
    }

    private PaymentResult processPayment(PaymentDetails paymentDetails) {
        log.info("Processing payment for payment details: {}", paymentDetails);
        PaymentResult paymentResult = paymentProcessor.process(paymentDetails);
        log.info("Payment processed successfully for payment details: {}", paymentDetails);
        return paymentResult;
    }

    private Invoice createAndSaveInvoice(Order order, PaymentResult paymentResult) {
        log.info("Creating and saving invoice for order: {}", order);
        Invoice invoice = orderService.getInvoice(order, paymentResult);
        invoiceRepository.save(invoice);
        log.info("Invoice created and saved successfully for order: {}", order);
        return invoice;
    }

    private void updateOrderItems(Order order) {
        log.info("Updating order items for order: {}", order);
        List<OrderItem> items = order.getItems();
        items.forEach(orderItem -> orderItem.setOrder(order));
        orderItemRepository.saveAll(items);
        log.info("Order items updated successfully for order: {}", order);
    }
}
