package com.evraz.grasp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShoppingCartDTO {
    @NotNull
    private OrderDTO orderDTO;
    @NotNull
    private PaymentDetailsDTO paymentDetailsDTO;
}
