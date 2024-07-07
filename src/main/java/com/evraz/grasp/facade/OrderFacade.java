package com.evraz.grasp.facade;

import com.evraz.grasp.dto.InvoiceDTO;
import com.evraz.grasp.dto.ShoppingCartDTO;
import com.evraz.grasp.entity.Order;
import com.evraz.grasp.entity.OrderItem;
import com.evraz.grasp.entity.ShoppingCart;
import com.evraz.grasp.mapper.ShoppingCartMapper;
import com.evraz.grasp.repository.OrderItemRepository;
import com.evraz.grasp.repository.OrderRepository;
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

@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final PaymentProcessor paymentProcessor;
    private final OrderService orderService;
    private final ShoppingCartMapper shoppingCartMapper;


    public InvoiceDTO processOrder(ShoppingCartDTO shoppingCartDTO) {

        ShoppingCart shoppingCart = shoppingCartMapper.convertToShoppingCart(shoppingCartDTO);

        Order order = shoppingCart.getOrder();

        int sumOfOrder = order.getItems().stream().mapToInt(OrderItem::getQuantity).sum();

        Integer sumOfQuantities = orderItemRepository.sumOfQuantities();

        if (sumOfOrder > sumOfQuantities) {
            throw new RuntimeException();
        } else {

        }

        return  null;
    }

}
