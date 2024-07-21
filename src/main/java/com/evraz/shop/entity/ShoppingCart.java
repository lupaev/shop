package com.evraz.shop.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    private Order order;
    private PaymentDetails paymentDetails;

}
