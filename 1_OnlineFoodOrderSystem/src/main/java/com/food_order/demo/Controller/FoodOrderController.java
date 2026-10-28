package com.food_order.demo.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import com.food_order.demo.Model.FoodOrder;
import com.food_order.demo.Service.FoodOrderService;

@RestController
@RequestMapping("/api/orders")
public class FoodOrderController {
    private final FoodOrderService foodOrderService;

    public FoodOrderController(FoodOrderService foodOrderService) {
        this.foodOrderService = foodOrderService;
    }

    @PostMapping("/add")
    public ResponseEntity<FoodOrder> addOrder(@Valid @RequestBody FoodOrder order) {
        return new ResponseEntity<>(foodOrderService.addOrder(order), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FoodOrder>> getAllOrders() {
        return ResponseEntity.ok(foodOrderService.getAllOrders());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<FoodOrder> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(foodOrderService.getOrderById(orderId));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<FoodOrder> updateOrder(@PathVariable Long orderId,
                                                  @Valid @RequestBody FoodOrder order) {
        return ResponseEntity.ok(foodOrderService.updateOrder(orderId, order));
    }

    @PatchMapping("/{orderId}/quantity")
    public ResponseEntity<FoodOrder> updateQuantity(@PathVariable Long orderId,
                                                     @RequestParam @Min(1) int quantity) {
        return ResponseEntity.ok(foodOrderService.updateQuantity(orderId, quantity));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(foodOrderService.deleteOrder(orderId));
    }
}
