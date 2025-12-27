package com.example.pathology.controllers;

import com.example.pathology.Services.TestOrderService;
import com.example.pathology.entities.TestOrder;
import com.example.pathology.entities.TestOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test-orders")
public class TestOrderController {
    private final TestOrderService testOrderService;

    @GetMapping
    public ResponseEntity<List<TestOrder>> getAllOrders(){
        List<TestOrder> testOrders = testOrderService.getAllOrders();

        return ResponseEntity.ok(testOrders);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TestOrder> getOrderById(@PathVariable UUID id){
        TestOrder testOrder = testOrderService.getOrderById(id);

        return ResponseEntity.ok(testOrder);
    }

    @PostMapping
    public ResponseEntity<TestOrder> createOrder(@RequestBody TestOrderDto testOrderDto){
        TestOrder testOrder = testOrderService.createOrder(testOrderDto);

        return ResponseEntity.ok(testOrder);
    }
}
