package com.evraz.shop.dto;

public record InvoiceDTO(
        Double paymentAmount,
        OrderDTO orderDTO,
        PaymentResultDTO paymentResultDTO)
{}
