package com.example.flipcart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class visa
{
    @GetMapping("/visa")
    public String getData()
    {
        return "your order has been  shipped and delivery successfully check";
    }
}
