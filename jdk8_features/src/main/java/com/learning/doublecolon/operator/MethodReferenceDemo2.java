package com.learning.doublecolon.operator;

import java.util.function.IntUnaryOperator;

public class MethodReferenceDemo2 {

	static IntUnaryOperator factorialOperator = Test::getFactorial;

	public static void main(String[] args) {
		int num = 5;
		int factorial = factorialOperator.applyAsInt(num);
		System.out.println("Number = " + num + "\nFactorial = " + factorial + "\n");
	}

}
