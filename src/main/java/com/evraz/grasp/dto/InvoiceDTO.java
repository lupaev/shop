package com.evraz.grasp.dto;

import lombok.Data;

@Data
public class InvoiceDTO {

    private Double paymentAmount;

    private OrderDTO orderDTO;

    private PaymentResultDTO paymentResultDTO;
}
