package com.quickbite.restaurant;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long restaurantId;
    private String itemName;
    private double price;

    public MenuItem() {}
    public MenuItem(Long id, Long restaurantId, String itemName, double price) {
        this.id=id; this.restaurantId=restaurantId; this.itemName=itemName; this.price=price;
    }
    public Long getId() { return id; }
    public Long getRestaurantId() { return restaurantId; }
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public void setId(Long id){this.id=id;}
    public void setRestaurantId(Long x){this.restaurantId=x;}
    public void setItemName(String x){this.itemName=x;}
    public void setPrice(double x){this.price=x;}
}
