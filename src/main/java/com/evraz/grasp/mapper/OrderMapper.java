package com.evraz.grasp.mapper;

import com.evraz.grasp.dto.OrderDTO;
import com.evraz.grasp.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {InvoiceMapper.class, OrderItemMapper.class})
public interface OrderMapper {
    @Mapping(target = "items", source = "items")
    OrderDTO toOrderDTO(Order order);
    @Mapping(target = "items", source = "items")
    Order toOrder(OrderDTO orderDTO);

    List<OrderDTO> toOrderDTO(List<Order> orders);
    List<Order> toOrders(List<OrderDTO> orderDTOs);
}
