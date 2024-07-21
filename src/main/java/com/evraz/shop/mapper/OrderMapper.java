package com.evraz.shop.mapper;

import com.evraz.shop.dto.OrderDTO;
import com.evraz.shop.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {InvoiceMapper.class, OrderItemMapper.class})
public interface OrderMapper {
    @Mapping(target = "items", source = "items")
    OrderDTO toOrderDTO(Order order);
    @Mapping(target = "items", source = "items")
    Order toOrder(OrderDTO orderDTO);
}
