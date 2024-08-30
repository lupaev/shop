package com.github.lupaev.shop.mapper;


import com.github.lupaev.shop.dto.PaymentDetailsDTO;
import com.github.lupaev.shop.entity.PaymentDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentDetailsMapper {

    PaymentDetails toPaymentDetails(PaymentDetailsDTO paymentDetailsDTO);
    PaymentDetailsDTO toPaymentDetailsDTO(PaymentDetails paymentDetails);

}
