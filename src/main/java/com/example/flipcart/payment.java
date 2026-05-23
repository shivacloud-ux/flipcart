package com.example.flipcart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class payment
{
    @GetMapping("/payment")
    public String getData()
    {
        return "you can payment by Paytm,phone pay,UPI,cash on delivery";
    }
}
