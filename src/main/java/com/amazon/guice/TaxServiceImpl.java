package com.amazon.guice;

class TaxServiceImpl implements TaxService {

    @Override
    public double calculateTax(double amountToTax) {
        return Math.round(amountToTax * .07 * 100.0) / 100.0;
    }

}
