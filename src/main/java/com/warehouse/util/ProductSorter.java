package com.warehouse.util;

import com.warehouse.entity.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductSorter {

    /**
     * Manual Insertion Sort by Product Price (Ascending).
     * No built-in JDK sorting (Collections.sort / Stream.sorted) used.
     */
    public static List<Product> sortByPrice(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return new ArrayList<>();
        }

        List<Product> sortedList = new ArrayList<>(products);

        for (int i = 1; i < sortedList.size(); i++) {
            Product current = sortedList.get(i);
            int j = i - 1;

            while (j >= 0 && sortedList.get(j).getPrice() > current.getPrice()) {
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }

            sortedList.set(j + 1, current);
        }

        return sortedList;
    }

    /**
     * Manual Insertion Sort by Product Stock (Ascending).
     * No built-in JDK sorting (Collections.sort / Stream.sorted) used.
     */
    public static List<Product> sortByStock(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return new ArrayList<>();
        }

        List<Product> sortedList = new ArrayList<>(products);

        for (int i = 1; i < sortedList.size(); i++) {
            Product current = sortedList.get(i);
            int j = i - 1;

            while (j >= 0 && sortedList.get(j).getStock() > current.getStock()) {
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }

            sortedList.set(j + 1, current);
        }

        return sortedList;
    }
}
