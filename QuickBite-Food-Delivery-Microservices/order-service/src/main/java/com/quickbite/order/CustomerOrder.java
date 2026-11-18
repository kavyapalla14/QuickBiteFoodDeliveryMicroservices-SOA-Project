package com.quickbite.order;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class CustomerOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long userId;
    private Long restaurantId;
    private double totalAmount;
    private String status;

    public CustomerOrder() {}
    public CustomerOrder(Long userId, Long restaurantId, double totalAmount, String status) {
        this.userId=userId; this.restaurantId=restaurantId; this.totalAmount=totalAmount; this.status=status;
    }
    public Long getOrderId(){return orderId;}
    public Long getUserId(){return userId;}
    public Long getRestaurantId(){return restaurantId;}
    public double getTotalAmount(){return totalAmount;}
    public String getStatus(){return status;}
    public void setOrderId(Long x){this.orderId=x;}
    public void setUserId(Long x){this.userId=x;}
    public void setRestaurantId(Long x){this.restaurantId=x;}
    public void setTotalAmount(double x){this.totalAmount=x;}
    public void setStatus(String x){this.status=x;}
}
