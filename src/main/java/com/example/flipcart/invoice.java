package com.example.flipcart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class invoice
{
    @GetMapping("/invoice")
    public String generateInvoice()
    {
        return "Invoice generated successfully. Invoice ID: INV1001, Amount: ₹2500";
    }
}


