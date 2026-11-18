package com.quickbite.restaurant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantRepository restaurants;
    private final MenuRepository menus;

    public RestaurantController(RestaurantRepository restaurants, MenuRepository menus) {
        this.restaurants = restaurants; this.menus = menus;
    }

    @GetMapping
    public List<Restaurant> all() { return restaurants.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> one(@PathVariable Long id) {
        return restaurants.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/menu")
    public List<MenuItem> menu(@PathVariable Long id) {
        return menus.findByRestaurantId(id);
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurants.save(restaurant);
    }

    @PostMapping("/{id}/menu")
    public MenuItem addMenu(@PathVariable Long id, @RequestBody MenuItem item) {
        item.setRestaurantId(id);
        return menus.save(item);
    }
}
