package com.evraz.shop.mapper;

import com.evraz.shop.dto.OrderItemDTO;
import com.evraz.shop.entity.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemDTO toDTO(OrderItem orderItem);
    OrderItem fromDTO(OrderItemDTO orderItemDTO);

    List<OrderItemDTO> toDTO(List<OrderItem> orderItems);
    List<OrderItem> fromDTO(List<OrderItemDTO> orderItemDTOS);
}
