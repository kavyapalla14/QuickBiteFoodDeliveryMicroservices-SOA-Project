package com.quickbite.payment;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentRepository repo;
    public PaymentController(PaymentRepository repo) { this.repo=repo; }

    @PostMapping
    public Payment pay(@RequestBody PaymentRequest request) {
        // Academic/demo payment simulation: every positive amount succeeds.
        String status = request.amount() > 0 ? "SUCCESS" : "FAILED";
        return repo.save(new Payment(request.orderId(), request.amount(), status));
    }

    @GetMapping
    public List<Payment> all() { return repo.findAll(); }

    public record PaymentRequest(Long orderId, double amount) {}
}
