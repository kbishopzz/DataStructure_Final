-- Sample Data Population derived from Warehouse_API.postman_collection.json

-- Insert Products
INSERT INTO products (id, name, price, stock) VALUES (1, 'Mechanical Keyboard', 89.99, 45);
INSERT INTO products (id, name, price, stock) VALUES (2, 'Ergonomic Gaming Mouse', 49.50, 120);
INSERT INTO products (id, name, price, stock) VALUES (3, 'UltraHD 4K Monitor', 349.99, 15);

-- Insert Customers
INSERT INTO customers (id, name, email) VALUES (1, 'Jane Doe', 'jane.doe@example.com');
INSERT INTO customers (id, name, email) VALUES (2, 'John Smith', 'john.smith@example.com');
INSERT INTO customers (id, name, email) VALUES (3, 'Alice Johnson', 'alice.j@example.com');
INSERT INTO customers (id, name, email) VALUES (4, 'Bob Lee', 'bob.lee@example.com');

-- Insert Orders (Medium, High, Low, and Custom Priority orders matching Postman collection)
INSERT INTO orders (id, order_date, priority_level, customer_id) VALUES (1, '2026-08-10', 5, 1);
INSERT INTO orders (id, order_date, priority_level, customer_id) VALUES (2, '2026-08-10', 9, 2);
INSERT INTO orders (id, order_date, priority_level, customer_id) VALUES (3, '2026-08-10', 2, 3);
INSERT INTO orders (id, order_date, priority_level, customer_id) VALUES (4, '2026-08-10', 7, 4);

-- Insert Sample Order Items (Linking Orders to Products)
INSERT INTO order_items (id, quantity, product_id, order_id) VALUES (1, 2, 1, 1);
INSERT INTO order_items (id, quantity, product_id, order_id) VALUES (2, 1, 2, 2);
INSERT INTO order_items (id, quantity, product_id, order_id) VALUES (3, 1, 3, 3);
INSERT INTO order_items (id, quantity, product_id, order_id) VALUES (4, 1, 1, 4);
