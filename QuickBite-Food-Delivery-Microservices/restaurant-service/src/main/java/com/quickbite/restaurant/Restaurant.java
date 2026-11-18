package com.quickbite.restaurant;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    public Restaurant() {}
    public Restaurant(Long id, String name, String location) {
        this.id = id; this.name = name; this.location = location;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
}
