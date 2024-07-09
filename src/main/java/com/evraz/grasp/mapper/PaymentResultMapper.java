package com.evraz.grasp.mapper;


import com.evraz.grasp.dto.PaymentResultDTO;
import com.evraz.grasp.entity.PaymentResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentResultMapper {
    @Mapping(target = "successful", source = "successful")
    @Mapping(target = "transactionNumber", source = "transactionNumber")
    @Mapping(target = "errorMessage", source = "errorMessage")
    PaymentResultDTO toDto(PaymentResult paymentResult);
}
