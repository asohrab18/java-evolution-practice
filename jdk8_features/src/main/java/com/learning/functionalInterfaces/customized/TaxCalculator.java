package com.learning.functionalInterfaces.customized;

/** If interface has only one Single Abstract Method (SAM) then @FunctionalInterface annotation is optional. */
//@FunctionalInterface
public interface TaxCalculator {
	double calculate(double amount);
}
