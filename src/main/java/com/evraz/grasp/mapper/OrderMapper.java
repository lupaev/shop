package com.evraz.grasp.mapper;

import com.evraz.grasp.dto.OrderDTO;
import com.evraz.grasp.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO toOrderDTO(Order order);
    Order toOrder(OrderDTO orderDTO);

    List<OrderDTO> toOrderDTO(List<Order> orders);
    List<Order> toOrders(List<OrderDTO> orderDTOs);
}
