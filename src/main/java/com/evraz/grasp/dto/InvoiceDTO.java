package com.evraz.grasp.dto;

import com.evraz.grasp.entity.Order;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class InvoiceDTO {

    private Double paymentAmount;

    private OrderDTO orderDTO;
}
