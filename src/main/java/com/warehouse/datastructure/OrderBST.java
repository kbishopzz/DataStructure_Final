package com.warehouse.datastructure;

import com.warehouse.entity.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderBST {

    private OrderNode root;

    public OrderNode getRoot() {
        return root;
    }

    public void insert(Order order) {
        if (order == null) return;
        root = insertRecursive(root, order);
    }

    private OrderNode insertRecursive(OrderNode current, Order order) {
        if (current == null) {
            return new OrderNode(order);
        }

        // Left child = lower priority
        // Right child = higher priority or equal priority (duplicates placed in right subtree)
        if (order.getPriorityLevel() < current.data.getPriorityLevel()) {
            current.left = insertRecursive(current.left, order);
        } else {
            current.right = insertRecursive(current.right, order);
        }

        return current;
    }

    // Inorder traversal collecting orders in ascending order of priorityLevel
    public List<Order> getInorderOrders() {
        List<Order> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    public void inorder(OrderNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println("Order ID: " + node.data.getId() + ", Priority: " + node.data.getPriorityLevel());
        inorder(node.right);
    }

    private void inorderRecursive(OrderNode node, List<Order> result) {
        if (node == null) return;
        inorderRecursive(node.left, result);
        result.add(node.data);
        inorderRecursive(node.right, result);
    }

    // Highest priority is the rightmost node in the BST
    public Order findHighest() {
        if (root == null) return null;
        OrderNode current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    // Lowest priority is the leftmost node in the BST
    public Order findLowest() {
        if (root == null) return null;
        OrderNode current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }
}
