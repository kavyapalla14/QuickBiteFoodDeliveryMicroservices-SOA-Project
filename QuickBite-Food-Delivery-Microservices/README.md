# QuickBite – Demand-Driven Food Delivery & Order Orchestration System

A review-ready Spring Boot microservices project based on the Continuous Evaluation Project requirements.

## Architecture

Browser/Postman
      |
      v
API Gateway :8080
      |
      +--> Auth Service       :8081  (JWT)
      +--> Restaurant Service :8082  (menus/restaurants)
      +--> Order Service      :8083  (orders)
                |
                +--> Payment Service :8084 (payments)

Eureka Discovery Server :8761

Services:
- discovery-server
- api-gateway
- auth-service
- restaurant-service
- order-service
- payment-service
- quickbite-ui (simple browser demo)

## Technology

- Java 17
- Spring Boot 3.3.5
- Spring Cloud 2023.0.3
- Spring Cloud Gateway
- Eureka Server / Eureka Discovery Client
- Spring Data JPA
- H2 database
- JWT authentication
- REST APIs
- Maven

## Fastest way to run for today's review

### 1. Check Java and Maven

```bash
java -version
mvn -version
```

Java 17+ is recommended.

### 2. Start services in this order

Open 6 terminals.

Terminal 1:
```bash
cd discovery-server
mvn spring-boot:run
```

Terminal 2:
```bash
cd auth-service
mvn spring-boot:run
```

Terminal 3:
```bash
cd restaurant-service
mvn spring-boot:run
```

Terminal 4:
```bash
cd payment-service
mvn spring-boot:run
```

Terminal 5:
```bash
cd order-service
mvn spring-boot:run
```

Terminal 6:
```bash
cd api-gateway
mvn spring-boot:run
```

Wait about 20–40 seconds for Eureka registration.

Open:
- Eureka dashboard: http://localhost:8761
- Gateway: http://localhost:8080
- Restaurant API through gateway: http://localhost:8080/restaurants

### 3. Test login

POST:
http://localhost:8080/auth/login

JSON:
```json
{
  "username": "divya",
  "password": "1234"
}
```

Copy the returned `token`.

### 4. Browse restaurants

GET:
http://localhost:8080/restaurants

GET menu:
http://localhost:8080/restaurants/1/menu

### 5. Create an order

POST:
http://localhost:8080/orders

Header:
```text
Authorization: Bearer YOUR_TOKEN
Content-Type: application/json
```

Body:
```json
{
  "userId": 1,
  "restaurantId": 1,
  "totalAmount": 320.00
}
```

The Order Service calls Payment Service internally. If payment succeeds, the order becomes CONFIRMED.

### 6. Check payment

GET:
http://localhost:8080/payments

### 7. Check orders

GET:
http://localhost:8080/orders

## Demo script for review

1. Explain the problem: food ordering must remain fast during peak lunch/dinner traffic.
2. Show the architecture diagram in `docs/architecture.md`.
3. Start Eureka and show registered services.
4. Show JWT login.
5. Show restaurant/menu API.
6. Place an order.
7. Explain Order -> Payment inter-service communication.
8. Show payment record and confirmed order.
9. Explain API Gateway as the single entry point.
10. Explain that Eureka supports service discovery and enables horizontal scaling/load balancing.

## Important note

This is an academic/demo implementation. Payment is simulated; no real bank/card transaction is performed.

## Useful URLs

- Eureka: http://localhost:8761
- Gateway: http://localhost:8080
- Auth: http://localhost:8081
- Restaurant: http://localhost:8082
- Order: http://localhost:8083
- Payment: http://localhost:8084
