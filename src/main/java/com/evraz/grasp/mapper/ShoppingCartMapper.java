package com.evraz.grasp.mapper;

import com.evraz.grasp.dto.ShoppingCartDTO;
import com.evraz.grasp.entity.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PaymentDetailsMapper.class, OrderMapper.class})
public interface ShoppingCartMapper {
    @Mapping(target = "orderDTO", source = "order")
    @Mapping(target = "paymentDetailsDTO", source = "paymentDetails")
    ShoppingCartDTO convertToShoppingCartDTO(ShoppingCart shoppingCart);
    @Mapping(target = "order", source = "orderDTO")
    @Mapping(target = "paymentDetails", source = "paymentDetailsDTO")
    ShoppingCart convertToShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
