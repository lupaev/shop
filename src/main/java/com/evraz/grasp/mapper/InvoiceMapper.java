package com.evraz.grasp.mapper;

import com.evraz.grasp.dto.InvoiceDTO;
import com.evraz.grasp.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PaymentResultMapper.class, OrderMapper.class})
public interface InvoiceMapper {

    @Mapping(target = "orderDTO", source = "order")
    @Mapping(target = "paymentResultDTO", source = "paymentResult")
    @Mapping(target = "paymentAmount", source = "paymentAmount")
    InvoiceDTO toDTO(Invoice invoice);

}
