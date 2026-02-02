package com.learning.functionalInterfaces.customized;

import com.learning.utils.AppConstants;

public class TaxCalculatorMain {

	public static void main(String[] args) {
		TaxCalculator gstCalc = amount -> amount * AppConstants.EIGHTEEN / AppConstants.HUNDRED;
		TaxCalculator serviceTaxCalc = amount -> amount * AppConstants.FIFTEEN / AppConstants.HUNDRED;

		double basicPrice = AppConstants.DOUBLE_160000;
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
