package com.github.lupaev.shop.dto;

import jakarta.validation.constraints.NotNull;

public record ShoppingCartDTO(
        @NotNull
        OrderDTO orderDTO,
        @NotNull
        PaymentDetailsDTO paymentDetailsDTO)
{}
