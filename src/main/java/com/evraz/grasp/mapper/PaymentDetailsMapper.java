package com.evraz.grasp.mapper;


import com.evraz.grasp.dto.PaymentDetailsDTO;
import com.evraz.grasp.entity.PaymentDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentDetailsMapper {

    PaymentDetails toPaymentDetails(PaymentDetailsDTO paymentDetailsDTO);
    PaymentDetailsDTO toPaymentDetailsDTO(PaymentDetails paymentDetails);

}
