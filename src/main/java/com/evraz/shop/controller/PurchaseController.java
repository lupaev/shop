package com.evraz.shop.controller;

import com.evraz.shop.dto.InvoiceDTO;
import com.evraz.shop.dto.ShoppingCartDTO;
import com.evraz.shop.facade.OrderFacade;
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
