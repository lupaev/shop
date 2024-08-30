package com.github.lupaev.shop.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    private Order order;
    private PaymentDetails paymentDetails;

}
