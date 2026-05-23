package com.example.flipcart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class shipping
{
    @GetMapping("/shipping")
    public String getData()
    {
        return "your order has been shipped successfully";
    }
}
