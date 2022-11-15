package com.amazon.spring;

import org.springframework.stereotype.Service;

@Service
class TaxService {

    public double calculateTax(double amountToTax) {
        return Math.round(amountToTax * .07 * 100.0) / 100.0;
    }

}
