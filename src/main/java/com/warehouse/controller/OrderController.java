package com.warehouse.controller;

import com.warehouse.entity.Order;
import com.warehouse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping("/add-to-priority-tree")
    public ResponseEntity<Order> addToPriorityTree(@RequestBody Order order) {
        Order addedOrder = orderService.addOrderToPriorityTree(order);
        return ResponseEntity.ok(addedOrder);
    }

    @GetMapping("/priority/inorder")
    public ResponseEntity<List<Order>> getInorderPriority() {
        return ResponseEntity.ok(orderService.getInorderPriorityOrders());
    }

    @GetMapping("/priority/highest")
    public ResponseEntity<Order> getHighestPriority() {
        Order highestOrder = orderService.getHighestPriorityOrder();
        if (highestOrder == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(highestOrder);
    }

    @GetMapping("/priority/lowest")
    public ResponseEntity<Order> getLowestPriority() {
        Order lowestOrder = orderService.getLowestPriorityOrder();
        if (lowestOrder == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lowestOrder);
    }
}
