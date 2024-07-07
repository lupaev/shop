package com.evraz.grasp.mapper;


import com.evraz.grasp.dto.PaymentDetailsDTO;
import com.evraz.grasp.entity.PaymentResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentResultMapper {
    PaymentResult toEntity(PaymentDetailsDTO paymentDetailsDTO);
    PaymentDetailsDTO toDto(PaymentResult paymentResult);
}
