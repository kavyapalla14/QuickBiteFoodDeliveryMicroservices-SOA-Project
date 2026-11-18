package com.quickbite.payment;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private double amount;
    private String paymentStatus;

    public Payment() {}
    public Payment(Long orderId, double amount, String paymentStatus) {
        this.orderId=orderId; this.amount=amount; this.paymentStatus=paymentStatus;
    }
    public Long getId(){return id;}
    public Long getOrderId(){return orderId;}
    public double getAmount(){return amount;}
    public String getPaymentStatus(){return paymentStatus;}
}
