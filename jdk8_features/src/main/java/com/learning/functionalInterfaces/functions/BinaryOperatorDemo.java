package com.learning.functionalInterfaces.functions;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

public class BinaryOperatorDemo {

	static BinaryOperator<Integer> multiplyOperator = (n1, n2) -> n1 * n2;

	static IntBinaryOperator differenceOperator = (n1, n2) -> Math.abs(n1 - n2);

	static LongBinaryOperator additionOperator = (n1, n2) -> n1 + n2;

	static DoubleBinaryOperator divisionOperator = (d1, d2) -> {
		if (d2 == 0d) {
			return 0d;
		}
		return d1 / d2;
	};

	public static void testBinaryOperators() {
		int num1 = 3, num2 = 4;
		int multiplication = multiplyOperator.apply(num1, num2);
		System.out.println("Number1 = " + num1 + "\nNumber2 = " + num2 + "\nMultiplication = " + multiplication + "\n");

		double d1 = 9.3d, d2 = 4.5d;
		double division = divisionOperator.applyAsDouble(d1, d2);
		System.out.println("Number1 = " + d1 + "\nNumber2 = " + d2 + "\nDivision = " + division + "\n");

		int difference = differenceOperator.applyAsInt(num1, num2);
		System.out.println("Number1 = " + num1 + "\nNumber2 = " + num2 + "\nDifference = " + difference + "\n");

		long l1 = 12l, l2 = 10l;
		long addition = additionOperator.applyAsLong(l1, l2);
		System.out.println("Number1 = " + l1 + "\nNumber2 = " + l2 + "\nAddition = " + addition + "\n");
	}

	public static void main(String[] args) {
		testBinaryOperators();
	}
}
