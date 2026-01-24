package com.learning.model;

import java.util.Arrays;
import java.util.List;

public final class AppUtils {

	private AppUtils() {
	}

	public static final List<Employee> employees = EmployeeDto.findEmployees();

	public static final List<Student> students = StudentDto.findStudents();

	public static final List<Person> persons = PersonDto.findPersons();

	public static final List<Candidate> candidates = CandidateDto.findCandidates();

	public static final List<Order> orders = OrderDto.findOrders();

	public static final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

	public static final List<Integer> duplicateNumbers = List.of(5, 5, 5, 1, 1, 1, 4, 4, 4, 2, 2, 2, 3, 3);

	public static final List<Integer> numbersIncludingNull = Arrays.asList(1, 2, null, 3, 4, 5, 6, null, 7, 8, 9, null,
			10);

	public static final List<Double> prices = List.of(100.18d, 200.86d, 300.56d);

	public static final List<Long> numbersL = List.of(123456L, 2765432L, 3982376L);

	public static final List<String> names = List.of("Ali", "Aman", "Bilal", "Simond", "Salman");

	public static final List<String> words = List.of("Apple", "Coconut", "Spoon", "Table", "Apple", "Coconut", "Cat",
			"Cat", "Cat", "Banana", "Banana", "Microservices");
}
