package com.example.flipcart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class orders {
    @GetMapping("/orders")
    public String getData()
    {
        return "My order list are:women kurta,pant and sleeper";
    }
}
