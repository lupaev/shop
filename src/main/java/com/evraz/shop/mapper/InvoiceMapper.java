package com.evraz.shop.mapper;

import com.evraz.shop.dto.InvoiceDTO;
import com.evraz.shop.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PaymentResultMapper.class, OrderMapper.class})
public interface InvoiceMapper {

    @Mapping(target = "orderDTO", source = "order")
    @Mapping(target = "paymentResultDTO", source = "paymentResult")
    @Mapping(target = "paymentAmount", source = "paymentAmount")
    InvoiceDTO toDTO(Invoice invoice);

}
