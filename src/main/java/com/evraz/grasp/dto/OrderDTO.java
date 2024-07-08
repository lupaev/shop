package com.evraz.grasp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    @NotNull
    private List<OrderItemDTO> items;

}
