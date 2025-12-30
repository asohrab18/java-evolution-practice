package com.learning.lambdaExpressions;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class Calculator {

	public static void main(String[] args) {
		IntFunction<Integer> squareNumFunc = i -> i * i;
		Integer squareNum = squareNumFunc.apply(2);
		System.out.println("squareNum = " + squareNum);

		BiFunction<Integer, Integer, Integer> addFunction = (i, j) -> i + j;
		Integer addition = addFunction.apply(1, 2);
		System.out.println("addition = " + addition);

		BiFunction<Integer, Integer, Integer> divideFunction = (i, j) -> {
			if (j == 0) {
				return 0;
			}
			return i / j;
		};

		Integer division = divideFunction.apply(4, 2);
		System.out.println("division = " + division);

		Function<String, Integer> stringLengthCountFunc = s -> {
			if (s == null || s.isEmpty()) {
				return 0;
			}
			return s.length();
		};

		Integer length = stringLengthCountFunc.apply("AB");
		System.out.println("length = " + length);
	}

}
