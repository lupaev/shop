package com.evraz.grasp.mapper;

import com.evraz.grasp.dto.ShoppingCartDTO;
import com.evraz.grasp.entity.ShoppingCart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PaymentDetailsMapper.class, OrderMapper.class})
public interface ShoppingCartMapper {
    ShoppingCartDTO convertToShoppingCartDTO(ShoppingCart shoppingCart);
    ShoppingCart convertToShoppingCart(ShoppingCartDTO shoppingCartDTO);

    List<ShoppingCart> convertToShoppingCartList(List<ShoppingCartDTO> shoppingCartDTOList);
    List<ShoppingCartDTO> convertToShoppingCartDTOList(List<ShoppingCart> shoppingCartList);

}
