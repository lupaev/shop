package com.evraz.shop.mapper;


import com.evraz.shop.dto.PaymentDetailsDTO;
import com.evraz.shop.entity.PaymentDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentDetailsMapper {

    PaymentDetails toPaymentDetails(PaymentDetailsDTO paymentDetailsDTO);
    PaymentDetailsDTO toPaymentDetailsDTO(PaymentDetails paymentDetails);

}
