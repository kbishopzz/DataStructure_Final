-- MySQL Full Initialization Script for Warehouse Management System
-- Use this script to manually initialize or reset your MySQL database in MySQL Workbench or terminal.

CREATE DATABASE IF NOT EXISTS warehouse_db;
USE warehouse_db;

-- Drop existing tables in reverse dependency order
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;

-- 1. Create Products Table
CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    stock INT NOT NULL
);

-- 2. Create Customers Table
CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- 3. Create Orders Table
CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_date DATE,
    priority_level INT NOT NULL,
    customer_id BIGINT,
    CONSTRAINT fk_orders_customer FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE SET NULL
);

-- 4. Create Order Items Table
CREATE TABLE order_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    quantity INT NOT NULL,
    product_id BIGINT,
    order_id BIGINT,
    CONSTRAINT fk_order_items_product FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
    CONSTRAINT fk_order_items_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

-- =======================================================
-- Sample Data Population (Reference: Warehouse_API.postman_collection.json)
-- =======================================================

-- Populate Products
INSERT INTO products (id, name, price, stock) VALUES 
(1, 'Mechanical Keyboard', 89.99, 45),
(2, 'Ergonomic Gaming Mouse', 49.50, 120),
(3, 'UltraHD 4K Monitor', 349.99, 15);

-- Populate Customers
INSERT INTO customers (id, name, email) VALUES 
(1, 'Jane Doe', 'jane.doe@example.com'),
(2, 'John Smith', 'john.smith@example.com'),
(3, 'Alice Johnson', 'alice.j@example.com'),
(4, 'Bob Lee', 'bob.lee@example.com');

-- Populate Orders
INSERT INTO orders (id, order_date, priority_level, customer_id) VALUES 
(1, '2026-08-10', 5, 1),  -- Medium Priority (5) - Jane Doe
(2, '2026-08-10', 9, 2),  -- High Priority (9)   - John Smith
(3, '2026-08-10', 2, 3),  -- Low Priority (2)    - Alice Johnson
(4, '2026-08-10', 7, 4);  -- Priority (7)        - Bob Lee

-- Populate Order Items
INSERT INTO order_items (id, quantity, product_id, order_id) VALUES 
(1, 2, 1, 1),
(2, 1, 2, 2),
(3, 1, 3, 3),
(4, 1, 1, 4);
