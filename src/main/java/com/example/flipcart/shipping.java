package com.example.flipcart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class shipping {
    @GetMapping("/shipping")
    public String getData() {
        return "your order has been shipped successfully";
    }

    @GetMapping("/tracking")
    public String trackOrder() {
        return "Your order is in transit and will be delivered soon";
    }

    @GetMapping("/status")
    public String orderStatus() {
        return "Your order status is: Delivered";
    }

    @GetMapping("/sale")
    public String saleService() {
        return "Big Sale! Get up to 50% discount on your order";
    }
}
