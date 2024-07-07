package com.evraz.grasp.controller;

import com.evraz.grasp.dto.InvoiceDTO;
import com.evraz.grasp.dto.OrderDTO;
import com.evraz.grasp.dto.ShoppingCartDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PurchaseController {

    @PostMapping
    public ResponseEntity<InvoiceDTO> createOrder(@Validated @RequestBody OrderDTO orderDTO) {

//        return new ResponseEntity<>(, HttpStatus.CREATED);
        return null;
    }
}
