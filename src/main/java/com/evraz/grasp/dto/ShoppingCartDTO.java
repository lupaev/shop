package com.evraz.grasp.dto;

import lombok.Data;

@Data
public class ShoppingCartDTO {
    private OrderDTO orderDTO;
    private PaymentDetailsDTO paymentDetailsDTO;
}
