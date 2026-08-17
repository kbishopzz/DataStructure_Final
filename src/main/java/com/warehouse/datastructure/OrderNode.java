package com.warehouse.datastructure;

import com.warehouse.entity.Order;

public class OrderNode {
    public Order data;
    public OrderNode left;
    public OrderNode right;

    public OrderNode(Order data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
