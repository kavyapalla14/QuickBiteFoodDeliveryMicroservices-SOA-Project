package com.quickbite.order;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository repo;
    private final RestTemplate restTemplate;

    public OrderController(OrderRepository repo, RestTemplate restTemplate) {
        this.repo=repo; this.restTemplate=restTemplate;
    }

    @GetMapping
    public List<CustomerOrder> all() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrder> one(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderRequest request) {
        CustomerOrder order = new CustomerOrder(
                request.userId(), request.restaurantId(), request.totalAmount(), "PAYMENT_PENDING");
        order = repo.save(order);

        try {
            Map<String,Object> paymentRequest = Map.of(
                    "orderId", order.getOrderId(),
                    "amount", order.getTotalAmount());

            PaymentResponse payment = restTemplate.postForObject(
                    "http://payment-service/payments",
                    paymentRequest,
                    PaymentResponse.class);

            if (payment != null && "SUCCESS".equals(payment.paymentStatus())) {
                order.setStatus("CONFIRMED");
            } else {
                order.setStatus("PAYMENT_FAILED");
            }
            repo.save(order);
            return ResponseEntity.ok(Map.of(
                    "message", "Order processed",
                    "order", order,
                    "payment", payment
            ));
        } catch (Exception ex) {
            order.setStatus("PAYMENT_SERVICE_UNAVAILABLE");
            repo.save(order);
            return ResponseEntity.status(503).body(Map.of(
                    "message", "Payment service unavailable",
                    "order", order
            ));
        }
    }

    public record OrderRequest(Long userId, Long restaurantId, double totalAmount) {}
    public record PaymentResponse(Long id, Long orderId, double amount, String paymentStatus) {}
}
