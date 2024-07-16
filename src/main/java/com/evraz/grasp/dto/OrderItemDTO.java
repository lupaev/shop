package com.evraz.grasp.dto;

import jakarta.validation.constraints.NotNull;

public record OrderItemDTO(
        @NotNull
        Double price,
        @NotNull
        Integer quantity)
{}
