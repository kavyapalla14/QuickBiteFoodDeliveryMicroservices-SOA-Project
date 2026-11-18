# Windows quick start

Open separate Command Prompt/PowerShell windows:

1. `cd discovery-server` -> `mvn spring-boot:run`
2. `cd auth-service` -> `mvn spring-boot:run`
3. `cd restaurant-service` -> `mvn spring-boot:run`
4. `cd payment-service` -> `mvn spring-boot:run`
5. `cd order-service` -> `mvn spring-boot:run`
6. `cd api-gateway` -> `mvn spring-boot:run`

Then open `http://localhost:8761`.

If Maven is not installed, install Maven and make sure `mvn` works in Command Prompt.
