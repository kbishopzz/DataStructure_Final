# Warehouse Inventory & Order Priority System

A Spring Boot backend application integrating fundamental **Data Structures and Algorithms (DSA)** to manage warehouse inventory and order dispatch prioritization.

---

## 📑 Project Documents & Deliverables

| Document / Asset | Location | Description |
| :--- | :--- | :--- |
| **Theory Answers & AI Disclosure** | [`documents/questionPanswers.md`](file:///documents/questionPanswers.md) | Answers to all 11 DSA theoretical questions and the AI usage disclosure. |
| **Project Assignment Specification** | [`documents/SD_DSA_FINAL_SUMMER_2026.docx`](file:///documents/SD_DSA_FINAL_SUMMER_2026.docx) | Official project requirements and rubric document. |
| **Postman API Collection** | [`Warehouse_API.postman_collection.json`](file:///Warehouse_API.postman_collection.json) | Ready-to-import Postman collection covering all REST endpoints. |
| **Database Setup Script** | [`setup_mysql.sql`](file:///setup_mysql.sql) | Optional manual SQL setup script for MySQL database & sample data. |

---

## 📬 How to Use the Postman Collection

The workspace includes a pre-configured Postman collection file: **[`Warehouse_API.postman_collection.json`](file:///Warehouse_API.postman_collection.json)**.

### Step 1: Import into Postman
1. Open the **Postman** desktop application (or web client).
2. Click the **Import** button in the top-left corner of the Postman workspace.
3. Drag and drop `Warehouse_API.postman_collection.json` into the file upload dialog (or click **files** and browse to the project directory).
4. Click **Import**. You will see the collection **"Warehouse Management System API"** in your left sidebar.

### Step 2: Configure Environment / Variables
* The collection defines a collection variable `baseUrl` defaulted to:
  ```text
  http://localhost:8080
  ```
* If your application runs on a different port or host, update the `baseUrl` variable under the collection's **Variables** tab.

### Step 3: Start the Backend Application
Ensure the Spring Boot server is running before executing requests:
```bash
mvn spring-boot:run
```

---

### Step 4: Recommended Request Execution Order

#### 1. Products API
* **`POST /products` (Create Products)**:
  * Create *Mechanical Keyboard* (Price: 89.99, Stock: 45)
  * Create *Ergonomic Gaming Mouse* (Price: 49.50, Stock: 120)
  * Create *UltraHD 4K Monitor* (Price: 349.99, Stock: 15)
* **`GET /products`**: Fetch all product records from the database.
* **`GET /products/sorted?by=price`**: Returns products sorted in ascending order of price using **manual Insertion Sort**.
* **`GET /products/sorted?by=stock`**: Returns products sorted in ascending order of stock quantity using **manual Insertion Sort**.

#### 2. Orders API & Binary Search Tree (BST) Operations
* **`POST /orders` (Create Orders)**:
  * Create *Medium Priority (5)* for customer Jane Doe.
  * Create *High Priority (9)* for customer John Smith.
  * Create *Low Priority (2)* for customer Alice Johnson.
  *(Each newly created order is automatically persisted to the database and inserted into the in-memory Order Priority BST).*
* **`POST /orders/add-to-priority-tree`**: Manually insert an order directly into the BST structure.
* **`GET /orders`**: Fetch all orders from the database.
* **`GET /orders/priority/inorder`**: Executes an **in-order traversal** of the BST, returning orders in ascending priority order ($1 \to 10$).
* **`GET /orders/priority/highest`**: Traverses to the **rightmost node** of the BST to retrieve the order with the highest priority level.
* **`GET /orders/priority/lowest`**: Traverses to the **leftmost node** of the BST to retrieve the order with the lowest priority level.

---

## 📋 Course Requirements & Completion Checklist

All requirements outlined in the course specification document ([`documents/SD_DSA_FINAL_SUMMER_2026.docx`](file:///documents/SD_DSA_FINAL_SUMMER_2026.docx)) have been fulfilled:

### 1. Database & JPA Entities
- [x] **Product Entity**: `id`, `name`, `price`, `stock` with JPA annotations.
- [x] **Customer Entity**: `id`, `name`, `email` with JPA annotations.
- [x] **Order Entity**: `id`, `orderDate`, `priorityLevel` (1–10), and `@ManyToOne` relationship with `Customer`.
- [x] **OrderItem Entity**: `id`, `quantity`, `@ManyToOne` with `Product`, and `@ManyToOne` with `Order`.
- [x] **Entity Relationships**:
  - One Customer $\to$ Many Orders (`@OneToMany`)
  - One Order $\to$ Many OrderItems (`@OneToMany`)
  - One Product $\to$ Many OrderItems (`@OneToMany`)

### 2. REST API Endpoints
- [x] `GET /products` — Retrieve all products.
- [x] `POST /products` — Create a new product.
- [x] `GET /products/sorted?by=price` — Retrieve products sorted by price.
- [x] `GET /products/sorted?by=stock` — Retrieve products sorted by stock.
- [x] `POST /orders` — Create order (persists to DB and inserts into BST).
- [x] `GET /orders` — Retrieve all orders.
- [x] `POST /orders/add-to-priority-tree` — Insert order into BST priority structure.
- [x] `GET /orders/priority/inorder` — Retrieve orders via BST in-order traversal.
- [x] `GET /orders/priority/highest` — Retrieve highest priority order (rightmost node).
- [x] `GET /orders/priority/lowest` — Retrieve lowest priority order (leftmost node).

### 3. Binary Search Tree (BST) Implementation
- [x] **Custom BST implementation** (`OrderBST.java` & `OrderNode.java`) with no built-in tree libraries.
- [x] **Recursive insertion**: Left subtree for lower priority; right subtree for higher or equal priority.
- [x] **Duplicate priority handling**: Duplicate priority levels are placed in the right subtree.
- [x] **In-order traversal**: Traverses Left $\to$ Current $\to$ Right to return orders in ascending priority order.
- [x] **`findHighest()`**: Iterates to the rightmost leaf node in $\mathcal{O}(h)$ time.
- [x] **`findLowest()`**: Iterates to the leftmost leaf node in $\mathcal{O}(h)$ time.

### 4. Manual Sorting Algorithm
- [x] **Manual Insertion Sort** (`ProductSorter.java`) implemented from scratch.
- [x] **No built-in Java sorting utilities** used (no `Collections.sort()` or `Stream.sorted()`).
- [x] Supports sorting products ascending by **price**.
- [x] Supports sorting products ascending by **stock**.

### 5. Architectural Cleanliness & Layer Separation
- [x] **Controller Layer** (`ProductController.java`, `OrderController.java`): Exposes REST routes, returns proper HTTP status codes (`200 OK`, `201 Created`, `400 Bad Request`, `404 Not Found`), delegates all logic to services.
- [x] **Service Layer** (`ProductService.java`, `OrderService.java`): Contains business logic, sorting coordination, input validation, and repository operations.
- [x] **Repository Layer** (`ProductRepository`, `OrderRepository`, `CustomerRepository`, `OrderItemRepository`): Extends `JpaRepository` for data access.

### 6. Automated Unit Testing
- [x] **JUnit 5 Unit Tests** in `src/test/java`:
  - `OrderBSTTest`: Tests in-order traversal sorting, `findHighest()` / `findLowest()` edge cases, and duplicate priority insertion.
  - `ProductSorterTest`: Tests manual Insertion Sort by price and by stock.
- [x] All 5 automated unit tests pass successfully (`mvn test`).

### 7. Application Theory & Deliverables
- [x] **Theory Questions Answered**: Located at [`documents/questionPanswers.md`](file:///documents/questionPanswers.md).
- [x] **AI Tool Usage Disclosure**: Outlined in Section 4 of [`documents/questionPanswers.md`](file:///documents/questionPanswers.md).
- [x] **Demo Video Preparation**: Covered in the section below.

---

## 🧪 Running the Unit Tests

Execute the full suite of unit tests with Maven:
```bash
mvn test
```

Expected output:
```text
[INFO] Running com.warehouse.util.ProductSorterTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.warehouse.datastructure.OrderBSTTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## 🚀 Getting Started & Running the Application

### Prerequisites
* **Java**: JDK 17 or later
* **Maven**: 3.8+
* **Database**: MySQL 8.0+ (or use built-in H2 fallback)

### Database Configuration
Database credentials and settings can be reviewed or adjusted in [`src/main/resources/application.properties`](file:///src/main/resources/application.properties):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/warehouse_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=D3c619seven4!
spring.jpa.hibernate.ddl-auto=update
spring.sql.init.mode=always
```

### Build & Launch
```bash
# Clean and compile
mvn clean compile

# Run the Spring Boot application
mvn spring-boot:run
```
The application will start on `http://localhost:8080`.

---

## 🎥 Demo Video Guide

When recording your demo video submission, ensure you demonstrate the following 3 key items:

1. **API Functionality in Postman**:
   * Create products and orders using the imported Postman collection.
   * Fetch all products and orders to confirm persistence.
2. **BST Traversal Results**:
   * Execute `GET /orders/priority/inorder` to show orders sorted in ascending order of priority.
   * Execute `GET /orders/priority/highest` and `GET /orders/priority/lowest` to show min/max retrieval.
3. **Manual Sorting Results**:
   * Execute `GET /products/sorted?by=price` and `GET /products/sorted?by=stock` to display the output of your custom Insertion Sort.
