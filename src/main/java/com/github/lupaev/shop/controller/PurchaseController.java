package com.github.lupaev.shop.controller;

import com.github.lupaev.shop.dto.InvoiceDTO;
import com.github.lupaev.shop.dto.ShoppingCartDTO;
import com.github.lupaev.shop.facade.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PurchaseController {
    private final OrderFacade orderFacade;

    @PostMapping("/order")
    public ResponseEntity<InvoiceDTO> createOrder(@Validated @RequestBody ShoppingCartDTO shoppingCartDTO) {
        return ResponseEntity.ok(orderFacade.processOrder(shoppingCartDTO));
    }
}
