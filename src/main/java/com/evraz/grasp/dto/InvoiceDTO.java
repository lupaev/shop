package com.evraz.grasp.dto;

import lombok.Data;

public record InvoiceDTO(
        Double paymentAmount,
        OrderDTO orderDTO,
        PaymentResultDTO paymentResultDTO)
{}
