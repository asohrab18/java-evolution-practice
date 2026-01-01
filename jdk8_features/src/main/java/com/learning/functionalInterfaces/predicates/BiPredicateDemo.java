package com.learning.functionalInterfaces.predicates;

import java.util.function.BiPredicate;

public class BiPredicateDemo {

	static BiPredicate<Integer, Integer> nonNullNumbers = (num1, num2) -> num1 != null && num2 != null;
	static BiPredicate<Integer, Integer> num1GreaterthanNum2 = (num1, num2) -> num1 > num2;

	static BiPredicate<String, String> nonNullStrings = (s1, s2) -> s1 != null && s2 != null;
	static BiPredicate<String, String> s1ContainsS2 = (s1, s2) -> s1.contains(s2);

	public static void testBiPredicates() {
		Integer num1 = 3, num2 = 1;

		boolean numbersComparison = nonNullNumbers.and(num1GreaterthanNum2).test(num1, num2);
		System.out.println("First number = " + num1 + "\nSecond Number = " + num2);
		System.out.println("Ques: Are both the numbers non-null where First number is greater than Second Number?\nANS: " + numbersComparison);

		String s1 = "MALAYALAM", s2 = "AYA";
		boolean StringsComparison = nonNullStrings.and(s1ContainsS2).test(s1, s2);
		System.out.println("\nFirst String = " + s1 + "\nSecond String = " + s2);
		System.out.println("Ques: Are both Strings non-null where First String contains Second String?\nANS: " + StringsComparison);

	}

	public static void main(String[] args) {
		testBiPredicates();
	}

}