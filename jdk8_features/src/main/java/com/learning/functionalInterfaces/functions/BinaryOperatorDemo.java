package com.learning.functionalInterfaces.functions;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

import com.learning.utils.AppConstants;

public class BinaryOperatorDemo {

	static BinaryOperator<Integer> multiplyOperator = (n1, n2) -> n1 * n2;

	static IntBinaryOperator differenceOperator = (n1, n2) -> Math.abs(n1 - n2);

	static LongBinaryOperator additionOperator = (n1, n2) -> n1 + n2;

	static DoubleBinaryOperator divisionOperator = (d1, d2) -> {
		if (d2 == AppConstants.DOUBLE_0) {
			return AppConstants.DOUBLE_0;
		}
		return d1 / d2;
	};

	public static void testBinaryOperators() {
		int num1 = AppConstants.THREE, num2 = AppConstants.FOUR;
		int multiplication = multiplyOperator.apply(num1, num2);
		System.out.println("Number1 = " + num1 + "\nNumber2 = " + num2 + "\nMultiplication = " + multiplication + "\n");

		double d1 = AppConstants.DOUBLE_9_DOT_3, d2 = AppConstants.DOUBLE_4_DOT_5;
		double division = divisionOperator.applyAsDouble(d1, d2);
		System.out.println("Number1 = " + d1 + "\nNumber2 = " + d2 + "\nDivision = " + division + "\n");

		int difference = differenceOperator.applyAsInt(num1, num2);
		System.out.println("Number1 = " + num1 + "\nNumber2 = " + num2 + "\nDifference = " + difference + "\n");

		long l1 = AppConstants.LONG_12, l2 = AppConstants.LONG_10;
		long addition = additionOperator.applyAsLong(l1, l2);
		System.out.println("Number1 = " + l1 + "\nNumber2 = " + l2 + "\nAddition = " + addition + "\n");
	}

	public static void main(String[] args) {
		testBinaryOperators();
	}
}
