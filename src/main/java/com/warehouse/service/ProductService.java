package com.warehouse.service;

import com.warehouse.entity.Product;
import com.warehouse.repository.ProductRepository;
import com.warehouse.util.ProductSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("Product price cannot be negative");
        }
        if (product.getStock() < 0) {
            throw new IllegalArgumentException("Product stock cannot be negative");
        }
        return productRepository.save(product);
    }

    public List<Product> getSortedProducts(String by) {
        List<Product> products = getAllProducts();
        if ("price".equalsIgnoreCase(by)) {
            return ProductSorter.sortByPrice(products);
        } else if ("stock".equalsIgnoreCase(by)) {
            return ProductSorter.sortByStock(products);
        } else {
            throw new IllegalArgumentException("Invalid sort field: '" + by + "'. Allowed values are 'price' or 'stock'.");
        }
    }
}
