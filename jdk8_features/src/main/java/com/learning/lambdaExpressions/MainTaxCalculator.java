package com.learning.lambdaExpressions;

import com.learning.functionalInterfaces.TaxCalculator;

public class MainTaxCalculator {

	public static void main(String[] args) {
		TaxCalculator gstCalc = amount -> amount * 18 / 100;
		TaxCalculator serviceTaxCalc = amount -> amount * 15 / 100;

		double basicPrice = 160000d;
		double gst = gstCalc.calculate(basicPrice);
		double serviceTax = serviceTaxCalc.calculate(basicPrice);
		double totalTax = gst + serviceTax;
		double totalAmount = basicPrice + totalTax;

		System.out.println("Bacic price = INR " + basicPrice);
		System.out.println("18% GST = INR " + gst);
		System.out.println("15% Service Tax = INR " + serviceTax);
		System.out.println("Total Tax = INR " + totalTax);
		System.out.println("Total Price (Bacic price + GST + Service Tax) = INR " + totalAmount);

	}

}
