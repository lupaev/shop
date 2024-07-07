package com.evraz.grasp.mapper;

import com.evraz.grasp.dto.OrderItemDTO;
import com.evraz.grasp.entity.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemDTO toDTO(OrderItem orderItem);
    OrderItem fromDTO(OrderItemDTO orderItemDTO);

    List<OrderItemDTO> toDTO(List<OrderItem> orderItems);
    List<OrderItem> fromDTO(List<OrderItemDTO> orderItemDTOS);
}
