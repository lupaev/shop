package com.evraz.shop.dto;

import jakarta.validation.constraints.NotNull;

public record OrderItemDTO(
        @NotNull
        Double price,
        @NotNull
        Integer quantity)
{}
