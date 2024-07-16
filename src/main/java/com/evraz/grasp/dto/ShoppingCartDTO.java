package com.evraz.grasp.dto;

import jakarta.validation.constraints.NotNull;

public record ShoppingCartDTO(
        @NotNull
        OrderDTO orderDTO,
        @NotNull
        PaymentDetailsDTO paymentDetailsDTO)
{}
