package com.github.lupaev.shop.mapper;

import com.github.lupaev.shop.dto.OrderDTO;
import com.github.lupaev.shop.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {InvoiceMapper.class, OrderItemMapper.class})
public interface OrderMapper {
    @Mapping(target = "items", source = "items")
    OrderDTO toOrderDTO(Order order);
    @Mapping(target = "items", source = "items")
    Order toOrder(OrderDTO orderDTO);
}
