package com.example.flipcart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class holiday
{
    @GetMapping("/holiday")
    public String getData()
    {
        return "your holiday offer is now live";
    }
}
