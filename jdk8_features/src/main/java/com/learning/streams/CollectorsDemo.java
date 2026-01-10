package com.learning.streams;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.learning.model.Employee;
import com.learning.model.EmployeeDto;
import com.learning.model.Student;
import com.learning.model.StudentDto;

public class CollectorsDemo {

	private static List<Employee> employees = EmployeeDto.findEmployees();
	private static List<Student> students = StudentDto.findStudents();

	/**
	 * This collector converts each element to a double and computes the arithmetic
	 * mean (average). Finally it returns a Double.
	 */
	static void testAveragingDouble() {
		List<Integer> numbers = List.of(1, 2, 3);
		System.out.println("Numbers = " + numbers);
		Double average = numbers.stream().collect(Collectors.averagingDouble(n -> n));
		System.out.println("Average = " + average);
		System.out.println("=======================================================");

		List<Double> salaries = employees.stream().map(e -> e.getSalary()).collect(Collectors.toList());
		System.out.println("Salaries of employees = " + salaries);

		Double averageSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("\nAverage Salary = " + averageSalary);
		System.out.println("=======================================================");

		List<Integer> ages = students.stream().map(s -> s.getAge()).collect(Collectors.toList());
		System.out.println("Ages of students = " + ages);

		Double averageAge = students.stream().collect(Collectors.averagingDouble(Student::getAge));
		System.out.println("Average Age = " + averageAge);
		System.out.println("=======================================================");

		List<Integer> prices = List.of(100, 200, 300);
		System.out.println("Prices = " + prices);

		Double averagePrice = prices.stream().collect(Collectors.averagingDouble(p -> p));
		System.out.println("Average Price = " + averagePrice);

		Double averagePriceWithTax = prices.stream().collect(Collectors.averagingDouble(p -> p + 0.18 * p));
		System.out.println("Average Price with 18% GST = " + averagePriceWithTax);
		System.out.println("=======================================================");
	}

	static void testAveragingInt() {
		List<Integer> numbers = List.of(1, 2, 3);
		System.out.println("Numbers = " + numbers);

		Double average = numbers.stream().collect(Collectors.averagingInt(n -> n));
		System.out.println("Average = " + average);
		System.out.println("=======================================================");

		List<Integer> ages = employees.stream().map(e -> e.getAge()).collect(Collectors.toList());
		System.out.println("Ages of employees = " + ages);

		Double averageAge = employees.stream().collect(Collectors.averagingInt(Employee::getAge));
		System.out.println("\nAverage Age = " + averageAge);
		System.out.println("=======================================================");
	}

	static void testAveragingLong() {
		List<Long> numbers = List.of(123456L, 2765432L, 3982376L);
		System.out.println("Numbers = " + numbers);

		Double average = numbers.stream().collect(Collectors.averagingLong(n -> n));
		System.out.println("Average = " + average);
		System.out.println("=======================================================");
	}

	static void testCollectingAndThen() {
		List<String> mutableNames = students.stream().map(s -> s.getName()).collect(Collectors.toList());
		System.out.println("Mutable Names = " + mutableNames);

		mutableNames.add("Zeeshan");
		System.out.println("\nUpdated Mutable Names = " + mutableNames);

		System.out.println("=======================================================");
		List<String> immutableNames = students.stream().map(s -> s.getName())
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

		System.out.println("Immutable Names = " + immutableNames);
		try {
			immutableNames.add("Mike");
		} catch (UnsupportedOperationException e) {
			System.out.println("\nCannot modify Immutable Names = " + immutableNames);
		}
		System.out.println("=======================================================");

		List<Integer> numbers = List.of(5, 5, 5, 1, 1, 1, 4, 4, 4, 2, 2, 2, 3, 3);
		System.out.println("Numbers = " + numbers);

		int howManyUniqueNumbers = numbers.stream()
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Set::size));

		System.out.println("How many unique Numbers are available?\nANS: " + howManyUniqueNumbers);
		System.out.println("=======================================================");

		List<Integer> sortedNumbers = numbers.stream()
				.collect(Collectors.collectingAndThen(Collectors.toSet(), set -> set.stream().sorted().toList()));

		System.out.println("Sorted unique Numbers = " + sortedNumbers);
		System.out.println("=======================================================");
	}

	static void testCounting() {
		List<Integer> ages = employees.stream().map(e -> e.getAge())
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted().toList()));
		System.out.println("Ages = " + ages);

		Long minors = employees.stream().filter(e -> e.getAge() < 18).collect(Collectors.counting());
		System.out.println("No. of Minors = " + minors);

		Long adults = employees.stream().filter(e -> e.getAge() >= 18).collect(Collectors.counting());
		System.out.println("No. of Adults = " + adults);
		System.out.println("=======================================================");
	}

	static void testGroupingBy() {
		Function<Employee, String> departmentFunction = e -> e.getDept();
		Map<String, List<Employee>> employeesMap = employees.stream()
				.collect(Collectors.groupingBy(departmentFunction));

		System.out.println(employeesMap);
		System.out.println("=======================================================");

		List<String> words = List.of("Apple", "Coconut", "Pear", "Blanket", "Dates", "Guava", "Picture", "Mango",
				"Orange", "Bat", "Ball", "Cat", "Banana");
		
		Map<Integer, List<String>> wordsMap = words.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(wordsMap);
		System.out.println("=======================================================");

	}

	public static void main(String[] args) {
		testAveragingDouble();
		testAveragingInt();
		testAveragingLong();
		testCollectingAndThen();
		testCounting();
		testGroupingBy();
	}

}
