package com.github.lupaev.shop.mapper;

import com.github.lupaev.shop.dto.ShoppingCartDTO;
import com.github.lupaev.shop.entity.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PaymentDetailsMapper.class, OrderMapper.class})
public interface ShoppingCartMapper {
    @Mapping(target = "order", source = "orderDTO")
    @Mapping(target = "paymentDetails", source = "paymentDetailsDTO")
    ShoppingCart convertToShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
