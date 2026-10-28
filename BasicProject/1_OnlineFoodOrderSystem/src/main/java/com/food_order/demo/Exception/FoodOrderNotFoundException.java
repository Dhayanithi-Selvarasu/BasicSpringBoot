package com.food_order.demo.Exception;

@SuppressWarnings("serial")
public class FoodOrderNotFoundException extends RuntimeException {
    public FoodOrderNotFoundException(String message) {
        super(message);
    }
}
