package com.evraz.shop.entity;

import lombok.Data;

@Data
public class ShoppingCart {

    private Order order;
    private PaymentDetails paymentDetails;

}
