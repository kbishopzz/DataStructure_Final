package com.warehouse.service;

import com.warehouse.datastructure.OrderBST;
import com.warehouse.entity.Order;
import com.warehouse.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderBST orderBST;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.orderBST = new OrderBST();
    }

    public Order createOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (order.getPriorityLevel() < 1 || order.getPriorityLevel() > 10) {
            throw new IllegalArgumentException("Priority level must be between 1 and 10");
        }
        Order savedOrder = orderRepository.save(order);
        // Automatically populate priority tree on creation
        orderBST.insert(savedOrder);
        return savedOrder;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order addOrderToPriorityTree(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        orderBST.insert(order);
        return order;
    }

    public List<Order> getInorderPriorityOrders() {
        // If tree is empty but DB has orders, initialize BST from DB
        if (orderBST.getRoot() == null) {
            populateTreeFromRepository();
        }
        return orderBST.getInorderOrders();
    }

    public Order getHighestPriorityOrder() {
        if (orderBST.getRoot() == null) {
            populateTreeFromRepository();
        }
        return orderBST.findHighest();
    }

    public Order getLowestPriorityOrder() {
        if (orderBST.getRoot() == null) {
            populateTreeFromRepository();
        }
        return orderBST.findLowest();
    }

    private synchronized void populateTreeFromRepository() {
        List<Order> dbOrders = orderRepository.findAll();
        for (Order order : dbOrders) {
            orderBST.insert(order);
        }
    }
}
