package com.learning.functionalInterfaces.functions;

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {

	static UnaryOperator<String> lowercaseOperator = s -> {
		if (s == null) {
			return s;
		}
		s = s.trim();
		return s.toLowerCase();
	};

	static LongUnaryOperator squareOperator = num -> (long) num * num;

	static IntUnaryOperator cubeOperator = num -> num * num * num;

	static DoubleUnaryOperator factorialOperator = num -> {
		double fact = 1d;
		if (num < 0d) {
			return 0;
		}
		if (num == 0d) {
			return fact;
		}
		for (double i = num; i > 0d; i--) {
			fact = fact * i;
		}
		return fact;
	};

	public static void testUnaryOperators() {
		String input = "     JKLM    ";
		String lowercaseOutput = lowercaseOperator.apply(input);
		System.out.println("input: " + input + "\nLower case Output: " + lowercaseOutput + "\n");

		long num = 1234567891l;
		long square = squareOperator.applyAsLong(num);
		System.out.println("Number = " + num + "\nIt's square = " + square + "\n");

		int numi = 2;
		int cube = cubeOperator.applyAsInt(numi);
		System.out.println("Number = " + numi + "\nIt's cube = " + cube + "\n");

		double numd = 17d;
		double factorial = factorialOperator.applyAsDouble(numd);
		System.out.println("Number = " + numd + "\nIt's factorial = " + factorial + "\n");
	}

	public static void main(String[] args) {
		testUnaryOperators();
	}
}
