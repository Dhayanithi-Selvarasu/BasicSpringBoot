package com.food_order.demo.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.food_order.demo.Model.FoodOrder;
import com.food_order.demo.Repository.FoodOrderRepository;
import com.food_order.demo.Exception.FoodOrderNotFoundException;

@Service
public class FoodOrderService {
    private final FoodOrderRepository foodOrderRepository;

    public FoodOrderService(FoodOrderRepository repository) {
        this.foodOrderRepository = repository;
    }

    public FoodOrder addOrder(FoodOrder order) {
        return foodOrderRepository.save(order);
    }

    public java.util.List<FoodOrder> getAllOrders() {
        return foodOrderRepository.findAll();
    }

    public FoodOrder getOrderById(Long orderId) {
        return foodOrderRepository.findById(orderId).orElseThrow(() ->
            new FoodOrderNotFoundException("Order not found with ID: " + orderId));
    }

    public FoodOrder updateOrder(Long orderId, FoodOrder updatedOrder) {
        FoodOrder order = getOrderById(orderId);
        order.setCustomerName(updatedOrder.getCustomerName());
        order.setFoodItem(updatedOrder.getFoodItem());
        order.setQuantity(updatedOrder.getQuantity());
        order.setPrice(updatedOrder.getPrice());
        return foodOrderRepository.save(order);
    }

    public FoodOrder updateQuantity(Long orderId, int quantity) {
        FoodOrder order = getOrderById(orderId);
        order.setQuantity(quantity);
        return foodOrderRepository.save(order);
    }

    public String deleteOrder(Long orderId) {
        FoodOrder order = getOrderById(orderId);
        foodOrderRepository.delete(order);
        return "Order deleted successfully";
    }
}
