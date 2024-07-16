package com.evraz.shop.mapper;


import com.evraz.shop.dto.PaymentResultDTO;
import com.evraz.shop.entity.PaymentResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentResultMapper {
    @Mapping(target = "successful", source = "successful")
    @Mapping(target = "transactionNumber", source = "transactionNumber")
    @Mapping(target = "errorMessage", source = "errorMessage")
    PaymentResultDTO toDto(PaymentResult paymentResult);
}
