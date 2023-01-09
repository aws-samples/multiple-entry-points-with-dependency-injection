package com.amazon.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {

    private final TaxService taxService;

    @Autowired
    public SpringController(TaxService taxService) {
        this.taxService = taxService;
    }

    @GetMapping("/")
    public ResponseEntity<Double> getTax(@RequestParam double amountToTax) {
        double tax = this.taxService.calculateTax(amountToTax);
        return ResponseEntity.ok(tax);
    }

}
