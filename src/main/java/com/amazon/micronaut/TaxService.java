package com.amazon.micronaut;

import jakarta.inject.Singleton;

@Singleton
class TaxService {

    double calculateTax(double amountToTax) {
        return Math.round(amountToTax * .07 * 100.0) / 100.0;
    }

}
