package com.github.lupaev.shop.dto;

import jakarta.validation.constraints.NotNull;

public record OrderItemDTO(
        @NotNull
        Double price,
        @NotNull
        Integer quantity)
{}
