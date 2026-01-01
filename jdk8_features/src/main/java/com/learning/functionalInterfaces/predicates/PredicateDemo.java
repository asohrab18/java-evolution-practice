package com.learning.functionalInterfaces.predicates;

import java.util.List;
import java.util.function.Predicate;

import com.learning.model.Employee;
import com.learning.model.EmployeeDto;

public class PredicateDemo {

	static Predicate<Integer> evenPredicate = i -> i % 2 == 0;
	static Predicate<Integer> oddPredicate = evenPredicate.negate();
	static Predicate<Integer> positivePredicate = i -> i > 0;
	static Predicate<Integer> negativePredicate = positivePredicate.negate();
	static Predicate<Integer> zeroPredicate = Predicate.isEqual(0);
	static Predicate<String> permanentPredicate = Predicate.isEqual("PERMANENT");
	static Predicate<Employee> adultPredicate = e -> e.getAge() >= 18;
	static Predicate<Employee> minorPredicate = adultPredicate.negate();

	static Predicate<String> emptyStringPredicate = s -> {
		if (s == null || s.isEmpty() || s.isBlank()) {
			return true;
		}
		return false;
	};

	public static void testPredicates() {
		int num = -2;
		boolean even = evenPredicate.test(num);
		System.out.println(num + " is " + (even ? "EVEN NUMBER." : "ODD NUMBER."));

		boolean positiveAndEven = positivePredicate.and(evenPredicate).test(num);
		System.out.println(num + " is positive and even number? Ans: " + positiveAndEven);

		boolean positiveOrEven = positivePredicate.or(evenPredicate).test(num);
		System.out.println(num + " is either positive or even number or both? Ans: " + positiveOrEven);

		boolean odd = oddPredicate.test(num);
		System.out.println(num + " is odd number? Ans: " + odd);

		boolean negative = negativePredicate.test(num);
		System.out.println(num + " is negative number? Ans: " + negative);

		String input = "PERMANENT";
		boolean emptyOrNull = emptyStringPredicate.test(input);
		System.out.println("input = '" + input + "' is either empty or null? Ans: " + emptyOrNull);

		boolean zero = zeroPredicate.test(num);
		System.out.println(num + " is zero? Ans: " + zero);

		boolean permanent = permanentPredicate.test(input);
		System.out.println("input = '" + input + "' is PERMANENT? Ans: " + permanent);
	}

	public static void usePredicateWithStream() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
		System.out.println("\nGiven Numbers List: " + numbers);

		System.out.println("Even Numbers in List:");
		numbers.stream().filter(evenPredicate).forEach(n -> System.out.println(n));

		System.out.println("Odd Numbers in List:");
		numbers.stream().filter(oddPredicate).forEach(n -> System.out.println(n));

		System.out.println("\nAdults: ");
		List<Employee> employees = EmployeeDto.findEmployees();

		employees.stream().filter(adultPredicate)
				.forEach(e -> System.out.println("Name: " + e.getName() + "\t| Age: " + e.getAge()));

		System.out.println("\nMinors: ");
		employees.stream().filter(minorPredicate)
				.forEach(e -> System.out.println("Name: " + e.getName() + "\t| Age: " + e.getAge()));

	}

	public static void main(String[] args) {
		testPredicates();
		usePredicateWithStream();
	}

}