package com.learning.functionalInterfaces.functions;

import java.util.function.Function;

public class FunctionDemo {

	static Function<String, Integer> strLengthFunction = s -> {
		if (s == null) {
			return 0;
		}
		return s.length();
	};

	static Function<String, String> trimFunction = s -> {
		if (s == null) {
			return "";
		}
		return s.trim();
	};

	static Function<Integer, Integer> squareFunction = i -> {
		if (i == null) {
			return 0;
		}
		return i * i;
	};

	static Function<Integer, Integer> cubeFunction = i -> {
		if (i == null) {
			return 0;
		}
		return i * i * i;
	};

	static Function<Integer, Integer> multiplyBy2 = i -> {
		if (i == null) {
			return 0;
		}
		return i * 2;
	};

	static Function<Integer, Integer> add10 = i -> {
		if (i == null) {
			return 0;
		}
		return i + 10;
	};

	// Function.identity() – Returns the Input as-is. Useful in Streams.
	static Function<String, String> identityFunction = Function.identity();

	public static void testFunctions() {
		String input = "ABCD";
		Integer strLength = strLengthFunction.apply(input);
		System.out.println("String = " + input + "\nIt's Length = " + strLength + "\n");

		System.out.println("Identity Function O/P = " + identityFunction.apply(input) + "\n");

		Integer num = 2;
		Integer squareAndThenCube = squareFunction.andThen(cubeFunction).apply(num);
		System.out.println("Number = " + num + "\nIt's square and then cube = " + squareAndThenCube + "\n");

		Integer cubeAndThenSquare = squareFunction.compose(cubeFunction).apply(num);
		System.out.println("Number = " + num + "\nIt's cube and then square = " + cubeAndThenSquare + "\n");

		Integer multiplyBy2add10 = multiplyBy2.andThen(add10).apply(num);
		System.out.println("Number = " + num + "\n(Number * 2) + 10 = " + multiplyBy2add10 + "\n");

		Integer add10multiplyBy2 = multiplyBy2.compose(add10).apply(num);
		System.out.println("Number = " + num + "\n(Number + 10) * 2 = " + add10multiplyBy2 + "\n");

		String input2 = "     PQRS     ";
		Integer strLength2 = strLengthFunction.compose(trimFunction).apply(input2);
		System.out.println("String = " + input2 + "\nIt's Length = " + strLength2 + "\n");

		System.out.println("Identity Function O/P2 = " + identityFunction.apply(input2) + "\n");
		/**
		 * trimFunction.compose(strLengthFunction).apply(input2);
		 * 
		 * Error: The method compose(Function<? super V,? extends String>) in the type
		 * Function<String, String> is not applicable for the arguments
		 * (Function<String,Integer>)
		 * 
		 */

	}

	public static void main(String[] args) {
		testFunctions();
	}

}
