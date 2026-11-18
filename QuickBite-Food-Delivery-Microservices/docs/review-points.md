# Review / Viva Points

## Problem Analysis
QuickBite needs fast restaurant browsing, order placement and payment processing during peak hours.

## Service Discovery
Eureka stores the locations of services. Services register themselves when they start.

## API Gateway
The gateway exposes one public endpoint (`localhost:8080`) and forwards requests to internal services.

## JWT
The Auth Service creates a signed token after login. The Gateway validates the token before protected requests.

## Restaurant Service
Maintains restaurant and menu data.

## Order Service
Creates orders and coordinates payment.

## Payment Service
Simulates payment processing and stores payment status.

## Inter-service communication
Order Service uses REST to call Payment Service.

## Database
Each business service has its own H2 database context. This demonstrates database-per-service separation.

## Scalability
During peak hours, multiple instances of a service can be started with different ports and registered in Eureka. The gateway/discovery layer can then distribute requests.

## DTI LinkedIn article
For the rubric's LinkedIn requirement, create/publish a separate article about the project's Design Thinking process:
Empathize -> Define -> Ideate -> Prototype -> Test.
Do not claim a LinkedIn publication from this local project; the article must be published in your LinkedIn account.
