package com.evraz.grasp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItemDTO {

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;
}
