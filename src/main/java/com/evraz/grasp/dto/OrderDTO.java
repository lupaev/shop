package com.evraz.grasp.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private List<OrderItemDTO> items;
    private PaymentDetailsDTO paymentDetailsDTO;
}
