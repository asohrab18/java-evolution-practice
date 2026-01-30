package com.learning.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class AppUtils {

	private AppUtils() {
	}

	/**
	 * ============== Some useful properties: ==============
	 */
	public static final int LIMIT = 5;

	/**
	 * ============== List of some custom classes: ==============
	 */
	public static final List<Candidate> CANDIDATES = CandidateDto.findCandidates();

	public static final List<Employee> EMPLOYEES = EmployeeDto.findEmployees();

	public static final List<Order> ORDERS = OrderDto.findOrders();

	public static final List<Person> PERSONS = PersonDto.findPersons();

	public static final List<Student> STUDENTS = StudentDto.findStudents();

	public static final List<Student> STUDENTS_WITH_MARKS = StudentDto.findStudentsWithMarks();

	public static final List<Student> STUDENTS_WITH_SUBJECTS_CODES = StudentDto.findStudentsWithSubjectsCodes();

	public static final List<Student> STUDENTS_WITH_QUESTION_PAPERS_CODES = StudentDto
			.findStudentsWithQuestionPapersCodes();

	/**
	 * ============== List of some data types: ===============
	 */

	public static final List<Integer> DUPLICATE_NUMBERS = List.of(5, 5, 5, 1, 1, 1, 4, 4, 4, 2, 2, 2, 3, 3);

	public static final List<Integer> EVEN_NUMBERS = List.of(2, 4, 6, 8, 9);

	public static final List<Integer> NUMBERS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

	public static final List<Integer> NUMBERS_INCLUDING_NULL = Arrays.asList(1, 2, null, 3, 4, 5, 6, null, 7, 8);

	public static final List<Integer> ODD_NUMBERS = List.of(1, 3, 5, 7, 9);

	public static final List<Long> NUMBERS_L = List.of(123456L, 2765432L, 3982376L);

	public static final List<Double> PRICES = List.of(100.18d, 200.86d, 300.56d);

	public static final List<String> NAMES = List.of("Bob", "Adam", "Zeeshan", "Tanya", "Menis", "Eves", "Celina",
			"Denis");

	public static final List<String> NUMBERS_STRING = List.of("10", "20", "30", "40", "50", "60");

	public static final List<String> WORDS = List.of("Ant", "Apple", "Coconut", "Spoon", "Table", "Coconut",
			"Microservices");

	/**
	 * =============== Some methods are below: ================
	 */
	public static <T> Stream<T> getEmptyStream() {
		return Stream.empty();
	}

	/** We return Stream.empty(); to avoid NullPointerException. */
	public static Stream<Integer> getIntStream(String key) {
		Stream<Integer> resultStream = Stream.empty();
		if (key == null || key.isBlank() || key.isEmpty()) {
			return resultStream;
		}
		if (key.equalsIgnoreCase("DUPLICATE_NUMBERS")) {
			resultStream = DUPLICATE_NUMBERS.stream();
		} else if (key.equalsIgnoreCase("EVEN_NUMBERS")) {
			resultStream = EVEN_NUMBERS.stream();
		} else if (key.equalsIgnoreCase("NUMBERS")) {
			resultStream = NUMBERS.stream();
		} else if (key.equalsIgnoreCase("NUMBERS_INCLUDING_NULL")) {
			resultStream = NUMBERS_INCLUDING_NULL.stream();
		} else if (key.equalsIgnoreCase("ODD_NUMBERS")) {
			resultStream = ODD_NUMBERS.stream();
		}
		return resultStream;
	}

	public static Stream<String> getStringStream(String key) {
		Stream<String> resultStream = Stream.empty();
		if (key == null || key.isBlank() || key.isEmpty()) {
			return resultStream;
		}
		if (key.equalsIgnoreCase("WORDS")) {
			resultStream = WORDS.stream();
		} else if (key.equalsIgnoreCase("NAMES")) {
			resultStream = NAMES.stream();
		} else if (key.equalsIgnoreCase("NUMBERS_STRING")) {
			resultStream = NUMBERS_STRING.stream();
		}
		return resultStream;
	}
}