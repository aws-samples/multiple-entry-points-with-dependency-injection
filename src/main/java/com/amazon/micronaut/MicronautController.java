package com.amazon.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;

@Controller
public class MicronautController {

    private final TaxService taxService;

    @Inject
    public MicronautController(TaxService taxService) {
        this.taxService = taxService;
    }

    @Get
    public double calculateTax(@QueryValue double amountToTax) {
        return this.taxService.calculateTax(amountToTax);
    }

}
