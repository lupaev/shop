package com.evraz.grasp.controller;

import com.evraz.grasp.dto.InvoiceDTO;
import com.evraz.grasp.dto.OrderDTO;
import com.evraz.grasp.dto.ShoppingCartDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    @PostMapping
    public ResponseEntity<InvoiceDTO> createOrder(@RequestBody ShoppingCartDTO shoppingCartDTO) {

//        return new ResponseEntity<>(, HttpStatus.CREATED);
        return null;
    }
}
