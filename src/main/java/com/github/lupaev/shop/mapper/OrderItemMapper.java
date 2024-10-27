package com.github.lupaev.shop.mapper;

import com.github.lupaev.shop.dto.OrderItemDTO;
import com.github.lupaev.shop.entity.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemDTO toDTO(OrderItem orderItem);
    OrderItem fromDTO(OrderItemDTO orderItemDTO);

    List<OrderItemDTO> toDTO(List<OrderItem> orderItems);
    List<OrderItem> fromDTO(List<OrderItemDTO> orderItemDTOS);
}
