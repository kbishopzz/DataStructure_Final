package com.warehouse.util;

import com.warehouse.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductSorterTest {

    @Test
    @DisplayName("Test manual Insertion Sort by product price ascending")
    void testSortByPrice() {
        Product p1 = new Product(1L, "Laptop", 1200.0, 10);
        Product p2 = new Product(2L, "Mouse", 25.50, 100);
        Product p3 = new Product(3L, "Keyboard", 75.0, 50);

        List<Product> products = Arrays.asList(p1, p2, p3);
        List<Product> sorted = ProductSorter.sortByPrice(products);

        assertEquals(3, sorted.size());
        assertEquals("Mouse", sorted.get(0).getName());
        assertEquals(25.50, sorted.get(0).getPrice());
        assertEquals("Keyboard", sorted.get(1).getName());
        assertEquals(75.0, sorted.get(1).getPrice());
        assertEquals("Laptop", sorted.get(2).getName());
        assertEquals(1200.0, sorted.get(2).getPrice());
    }

    @Test
    @DisplayName("Test manual Insertion Sort by product stock ascending")
    void testSortByStock() {
        Product p1 = new Product(1L, "Laptop", 1200.0, 10);
        Product p2 = new Product(2L, "Mouse", 25.50, 100);
        Product p3 = new Product(3L, "Keyboard", 75.0, 5);

        List<Product> products = Arrays.asList(p1, p2, p3);
        List<Product> sorted = ProductSorter.sortByStock(products);

        assertEquals(3, sorted.size());
        assertEquals("Keyboard", sorted.get(0).getName());
        assertEquals(5, sorted.get(0).getStock());
        assertEquals("Laptop", sorted.get(1).getName());
        assertEquals(10, sorted.get(1).getStock());
        assertEquals("Mouse", sorted.get(2).getName());
        assertEquals(100, sorted.get(2).getStock());
    }
}
