package com.github.lupaev.shop.dto;

public record InvoiceDTO(
        Double paymentAmount,
        OrderDTO orderDTO,
        PaymentResultDTO paymentResultDTO)
{}
