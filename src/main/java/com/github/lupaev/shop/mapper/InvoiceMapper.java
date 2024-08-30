package com.github.lupaev.shop.mapper;

import com.github.lupaev.shop.dto.InvoiceDTO;
import com.github.lupaev.shop.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PaymentResultMapper.class, OrderMapper.class})
public interface InvoiceMapper {

    @Mapping(target = "orderDTO", source = "order")
    @Mapping(target = "paymentResultDTO", source = "paymentResult")
    @Mapping(target = "paymentAmount", source = "paymentAmount")
    InvoiceDTO toDTO(Invoice invoice);

}
