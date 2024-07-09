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
import com.evraz.grasp.service.PaymentService;
import com.evraz.grasp.specification.OrderItemSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
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

        ShoppingCart shoppingCart = shoppingCartMapper.convertToShoppingCart(shoppingCartDTO);

        Order order = shoppingCart.getOrder();
        PaymentDetails paymentDetails = shoppingCart.getPaymentDetails();

        List<OrderItem> items = order.getItems();
        int sumOfOrder = items.stream().mapToInt(OrderItem::getQuantity).sum();

        Integer sumOfQuantities = orderItemRepository.sumOfQuantities();

        PaymentResult paymentResult;

        if (sumOfQuantities == null || sumOfOrder > sumOfQuantities) {
            throw new NotEnoughQuantityException("Not enough quantities");
        } else {
            paymentResult = paymentProcessor.process(paymentDetails);
        }

        Invoice invoice = orderService.getInvoice(order, paymentResult);
        invoiceRepository.save(invoice);

        items.stream().forEach(orderItem -> orderItem.setOrder(order));
        orderItemRepository.saveAll(items);
        orderRepository.save(order);
        paymentResultRepository.save(paymentResult);

        //invice
            //  order
                //OrderItem
            //paymentResult

        return  invoiceMapper.toDTO(invoice);
    }

}
