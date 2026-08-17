package com.warehouse.datastructure;

import com.warehouse.entity.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderBSTTest {

    private OrderBST bst;

    @BeforeEach
    void setUp() {
        bst = new OrderBST();
    }

    @Test
    @DisplayName("Test BST insertion and in-order traversal returns orders sorted by priority")
    void testInorderTraversalSorted() {
        Order order1 = new Order(1L, LocalDate.now(), 5, null);
        Order order2 = new Order(2L, LocalDate.now(), 2, null);
        Order order3 = new Order(3L, LocalDate.now(), 9, null);
        Order order4 = new Order(4L, LocalDate.now(), 1, null);

        bst.insert(order1);
        bst.insert(order2);
        bst.insert(order3);
        bst.insert(order4);

        List<Order> sortedOrders = bst.getInorderOrders();
        assertEquals(4, sortedOrders.size());
        assertEquals(1, sortedOrders.get(0).getPriorityLevel());
        assertEquals(2, sortedOrders.get(1).getPriorityLevel());
        assertEquals(5, sortedOrders.get(2).getPriorityLevel());
        assertEquals(9, sortedOrders.get(3).getPriorityLevel());
    }

    @Test
    @DisplayName("Test findHighest and findLowest priority order methods")
    void testFindHighestAndLowest() {
        Order order1 = new Order(10L, LocalDate.now(), 7, null);
        Order order2 = new Order(20L, LocalDate.now(), 3, null);
        Order order3 = new Order(30L, LocalDate.now(), 10, null);
        Order order4 = new Order(40L, LocalDate.now(), 1, null);

        bst.insert(order1);
        bst.insert(order2);
        bst.insert(order3);
        bst.insert(order4);

        Order highest = bst.findHighest();
        assertNotNull(highest);
        assertEquals(10, highest.getPriorityLevel());
        assertEquals(30L, highest.getId());

        Order lowest = bst.findLowest();
        assertNotNull(lowest);
        assertEquals(1, lowest.getPriorityLevel());
        assertEquals(40L, lowest.getId());
    }

    @Test
    @DisplayName("Test duplicate priority level placement in BST")
    void testDuplicatePriorityInsertion() {
        Order orderA = new Order(1L, LocalDate.now(), 4, null);
        Order orderB = new Order(2L, LocalDate.now(), 4, null);
        Order orderC = new Order(3L, LocalDate.now(), 4, null);

        bst.insert(orderA);
        bst.insert(orderB);
        bst.insert(orderC);

        List<Order> sortedOrders = bst.getInorderOrders();
        assertEquals(3, sortedOrders.size());
        for (Order o : sortedOrders) {
            assertEquals(4, o.getPriorityLevel());
        }
    }
}
