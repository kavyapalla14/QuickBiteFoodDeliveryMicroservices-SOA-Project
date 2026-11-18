package com.quickbite.restaurant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestaurantServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(RestaurantRepository restaurants, MenuRepository menus) {
        return args -> {
            if (restaurants.count() == 0) {
                Restaurant r1 = restaurants.save(new Restaurant(null, "Spice Garden", "Vijayawada"));
                Restaurant r2 = restaurants.save(new Restaurant(null, "Green Leaf", "Eluru"));
                menus.save(new MenuItem(null, r1.getId(), "Paneer Biryani", 180));
                menus.save(new MenuItem(null, r1.getId(), "Veg Fried Rice", 140));
                menus.save(new MenuItem(null, r1.getId(), "Gobi Manchurian", 110));
                menus.save(new MenuItem(null, r2.getId(), "Veg Meals", 120));
                menus.save(new MenuItem(null, r2.getId(), "Masala Dosa", 80));
            }
        };
    }
}
