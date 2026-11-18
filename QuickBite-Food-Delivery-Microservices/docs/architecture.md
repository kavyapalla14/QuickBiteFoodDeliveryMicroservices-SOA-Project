# QuickBite Architecture

## Services

| Service | Port | Responsibility |
|---|---:|---|
| Eureka Discovery | 8761 | Service registry |
| API Gateway | 8080 | Single entry point + JWT validation + routing |
| Auth Service | 8081 | Login and JWT generation |
| Restaurant Service | 8082 | Restaurant and menu management |
| Order Service | 8083 | Create and view orders |
| Payment Service | 8084 | Simulated payment processing |

## Request flow

### Browse menu
Client -> API Gateway -> Restaurant Service -> H2

### Login
Client -> API Gateway -> Auth Service -> JWT returned

### Place order
Client -> API Gateway -> Order Service
Order Service -> Payment Service
Payment Service -> Order Service
Order Service -> Client

## Why this is microservices

Each business capability has its own deployable service and database context. A restaurant service can be scaled separately from payment or order processing.

## Peak traffic

API Gateway + Eureka allow requests to be routed to service instances. In a production deployment, multiple instances of the same service can run behind discovery/load balancing.

## Security

The API Gateway checks a JWT for protected `/orders/**` and `/payments/**` requests. Login is intentionally simple for the academic project.
