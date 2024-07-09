package com.evraz.grasp.mapper;

import com.evraz.grasp.dto.OrderDTO;
import com.evraz.grasp.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {InvoiceMapper.class, OrderItemMapper.class})
public interface OrderMapper {
    @Mapping(target = "items", source = "items")
    OrderDTO toOrderDTO(Order order);
    @Mapping(target = "items", source = "items")
    Order toOrder(OrderDTO orderDTO);
}
