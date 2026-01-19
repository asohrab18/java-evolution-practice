package com.learning.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.learning.model.Candidate;
import com.learning.model.CandidateDto;
import com.learning.model.Employee;
import com.learning.model.EmployeeDto;
import com.learning.model.Order;
import com.learning.model.OrderDto;
import com.learning.model.Person;
import com.learning.model.PersonDto;
import com.learning.model.Student;
import com.learning.model.StudentDto;

public class CollectorsDemo {

	private static List<Employee> employees = EmployeeDto.findEmployees();
	private static List<Student> students = StudentDto.findStudents();
	private static List<Person> persons = PersonDto.findPersons();
	private static List<Candidate> candidates = CandidateDto.findCandidates();
	private static List<Order> orders = OrderDto.findOrders();
	private static List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	private static List<Integer> duplicateNumbers = List.of(5, 5, 5, 1, 1, 1, 4, 4, 4, 2, 2, 2, 3, 3);

	private static List<Integer> numbersIncludingNull = Arrays.asList(1, 2, null, 3, 4, 5, 6, null, 7, 8, 9, null, 10);

	private static List<Double> prices = List.of(100.18d, 200.86d, 300.56d);
	private static List<Long> numbersL = List.of(123456L, 2765432L, 3982376L);
	private static List<String> names = List.of("Ali", "Aman", "Bilal", "Simond", "Salman");

	private static List<String> words = List.of("Apple", "Coconut", "Pear", "Blanket", "Dates", "Guava", "Picture",
			"Mango", "Orange", "Bat", "Ball", "Cat", "Cat", "Cat", "Banana");

	/**
	 * This collector converts each element to a double and computes the arithmetic
	 * mean (average). Finally it returns a Double.
	 */
	static void testAveragingDouble() {
		System.out.println("===================== testAveragingDouble() =====================");
		System.out.println("Numbers = " + numbers);
		Double average = numbers.stream().collect(Collectors.averagingDouble(n -> n));
		System.out.println("Average = " + average);
		System.out.println("------------------------------------------------------------");

		List<Double> salaries = employees.stream().map(e -> e.getSalary()).collect(Collectors.toList());
		System.out.println("Salaries of employees = " + salaries);

		Double averageSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("\nAverage Salary = " + averageSalary);
		System.out.println("------------------------------------------------------------");

		List<Integer> ages = students.stream().map(s -> s.getAge()).collect(Collectors.toList());
		System.out.println("Ages of students = " + ages);

		Double averageAge = students.stream().collect(Collectors.averagingDouble(Student::getAge));
		System.out.println("Average Age = " + averageAge);
		System.out.println("------------------------------------------------------------");

		System.out.println("Prices = " + prices);
		Double averagePrice = prices.stream().collect(Collectors.averagingDouble(p -> p));
		System.out.println("Average Price = " + averagePrice);

		Double averagePriceWithTax = prices.stream().collect(Collectors.averagingDouble(p -> p + 0.18 * p));
		System.out.println("Average Price with 18% GST = " + averagePriceWithTax);
		System.out.println("------------------------------------------------------------");
	}

	static void testAveragingInt() {
		System.out.println("\n\n===================== testAveragingInt() =====================");
		System.out.println("Numbers = " + numbers);

		Double average = numbers.stream().collect(Collectors.averagingInt(n -> n));
		System.out.println("Average = " + average);
		System.out.println("------------------------------------------------------------");

		List<Integer> ages = employees.stream().map(e -> e.getAge()).collect(Collectors.toList());
		System.out.println("Ages of employees = " + ages);

		Double averageAge = employees.stream().collect(Collectors.averagingInt(Employee::getAge));
		System.out.println("\nAverage Age = " + averageAge);
		System.out.println("------------------------------------------------------------");
	}

	static void testAveragingLong() {
		System.out.println("\n\n===================== testAveragingLong() =====================");
		System.out.println("Numbers = " + numbersL);

		Double average = numbersL.stream().collect(Collectors.averagingLong(n -> n));
		System.out.println("Average = " + average);
		System.out.println("------------------------------------------------------------");
	}

	static void testCollectingAndThen() {
		System.out.println("\n\n===================== testCollectingAndThen() =====================");
		List<String> mutableNames = students.stream().map(s -> s.getName()).collect(Collectors.toList());
		System.out.println("Mutable Names = " + mutableNames);

		mutableNames.add("Zeeshan");
		System.out.println("\nUpdated Mutable Names = " + mutableNames);

		System.out.println("------------------------------------------------------------");
		List<String> immutableNames = students.stream().map(s -> s.getName())
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

		System.out.println("Immutable Names = " + immutableNames);
		try {
			immutableNames.add("Mike");
		} catch (UnsupportedOperationException e) {
			System.out.println("\nCannot modify Immutable Names = " + immutableNames);
		}
		System.out.println("------------------------------------------------------------");

		System.out.println("Duplicate Numbers = " + duplicateNumbers);

		int howManyUniqueNumbers = duplicateNumbers.stream()
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Set::size));

		System.out.println("How many unique Numbers are available?\nANS: " + howManyUniqueNumbers);
		System.out.println("------------------------------------------------------------");

		List<Integer> sortedNumbers = numbers.stream()
				.collect(Collectors.collectingAndThen(Collectors.toSet(), set -> set.stream().sorted().toList()));

		System.out.println("Sorted unique Numbers = " + sortedNumbers);
		System.out.println("------------------------------------------------------------");
	}

	static void testCounting() {
		System.out.println("\n\n===================== testCounting() =====================");
		List<Integer> ages = employees.stream().map(e -> e.getAge())
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted().toList()));
		System.out.println("Ages = " + ages);

		Long minors = employees.stream().filter(e -> e.getAge() < 18).collect(Collectors.counting());
		System.out.println("No. of Minors = " + minors);

		Long adults = employees.stream().filter(e -> e.getAge() >= 18).collect(Collectors.counting());
		System.out.println("No. of Adults = " + adults);
		System.out.println("------------------------------------------------------------");
	}

	static void testGroupingBy_V1() {
		System.out.println("\n\n===================== testGroupingBy_V1() =====================");
		Function<Employee, String> departmentFunction = e -> e.getDept();
		Map<String, List<Employee>> employeesMap = employees.stream()
				.collect(Collectors.groupingBy(departmentFunction));

		System.out.println(employeesMap);
		System.out.println("------------------------------------------------------------");

		Map<String, List<Person>> personsMap = persons.stream().collect(Collectors.groupingBy(Person::getCountry));
		System.out.println(personsMap);
		System.out.println("------------------------------------------------------------");

		Map<Integer, List<String>> wordsMap = words.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(wordsMap);
		System.out.println("------------------------------------------------------------");

		System.out.println("Numbers: " + numbers);
		Function<Integer, String> evenOddFunction = i -> i % 2 == 0 ? "EVEN" : "ODD";

		Map<String, List<Integer>> evenOddMap = numbers.stream().collect(Collectors.groupingBy(evenOddFunction));

		System.out.println(evenOddMap);
		System.out.println("------------------------------------------------------------");

		Function<String, Character> charFunction = s -> s.charAt(0);
		Map<Character, List<String>> namesMap = names.stream().collect(Collectors.groupingBy(charFunction));
		System.out.println(namesMap);
		System.out.println("------------------------------------------------------------");

		Function<Student, String> ageStatusFunction = s -> s.getAge() >= 18 ? "ADULTS" : "MINORS";
		Map<String, List<Student>> maturityMap = students.stream().collect(Collectors.groupingBy(ageStatusFunction));
		System.out.println(maturityMap);
		System.out.println("------------------------------------------------------------");
	}

	static void testGroupingBy_V2() {
		System.out.println("\n\n===================== testGroupingBy_V2() =====================");
		Map<String, List<Person>> personsMap = persons.stream()
				.collect(Collectors.groupingBy(Person::getCountry, Collectors.toList()));

		System.out.println(personsMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Long> personsCountingMap = persons.stream()
				.collect(Collectors.groupingBy(Person::getCountry, Collectors.counting()));

		System.out.println(personsCountingMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Double> employeesSalaryMap = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.summingDouble(Employee::getSalary)));

		System.out.println(employeesSalaryMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Optional<Employee>> employeesHighestSalaryMap = employees.stream().collect(
				Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

		System.out.println(employeesHighestSalaryMap);
		System.out.println("------------------------------------------------------------");

		Map<String, List<String>> personsNameMap = persons.stream().collect(
				Collectors.groupingBy(Person::getCountry, Collectors.mapping(Person::getName, Collectors.toList())));

		System.out.println(personsNameMap);
		System.out.println("------------------------------------------------------------");

		Function<Student, String> adultsMinorFunction = s -> s.getAge() >= 18 ? "ADULTS" : "MINORS";
		Function<Student, String> nameAgeFunction = s -> s.getName() + " is " + s.getAge() + " years old.";

		Map<String, List<String>> studentsMap = students.stream().collect(
				Collectors.groupingBy(adultsMinorFunction, Collectors.mapping(nameAgeFunction, Collectors.toList())));

		System.out.println(studentsMap);
		System.out.println("------------------------------------------------------------");
	}

	static void testGroupingBy_V3() {
		System.out.println("\n\n===================== testGroupingBy_V3() =====================");
		Map<String, List<Candidate>> candidatesMap = candidates.stream()
				.collect(Collectors.groupingBy(Candidate::getDepartment, HashMap::new, Collectors.toList()));

		System.out.println(candidatesMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Long> candidatesCountMap = candidates.stream()
				.collect(Collectors.groupingBy(Candidate::getDepartment, LinkedHashMap::new, Collectors.counting()));

		System.out.println(candidatesCountMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Double> employeesMap = employees.stream().collect(
				Collectors.groupingBy(Employee::getDept, TreeMap::new, Collectors.summingDouble(Employee::getSalary)));

		System.out.println(employeesMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Double> employeesAverageSalaryMap = employees.stream().collect(Collectors
				.groupingBy(Employee::getDept, TreeMap::new, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(employeesAverageSalaryMap);
		System.out.println("------------------------------------------------------------");

		Map<String, List<String>> employeesNamesMap = employees.stream().collect(Collectors.groupingBy(
				Employee::getDept, TreeMap::new, Collectors.mapping(Employee::getName, Collectors.toList())));

		System.out.println(employeesNamesMap);
		System.out.println("------------------------------------------------------------");

		Map<String, DoubleSummaryStatistics> employeesSummaryMap = employees.stream().collect(Collectors
				.groupingBy(Employee::getDept, TreeMap::new, Collectors.summarizingDouble(Employee::getSalary)));

		System.out.println(employeesSummaryMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Employee> highestPaidByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDept, TreeMap::new, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));

		System.out.println(highestPaidByDept);
		System.out.println("------------------------------------------------------------");
	}

	/**
	 * groupingByConcurrent collector is mainly used with parallel streams to
	 * perform thread-safe grouping.
	 */
	static void testGroupingByConcurrent_V1() {
		System.out.println("\n\n===================== testGroupingByConcurrent_V1() =====================");
		System.out.println("Words = " + words);

		ConcurrentMap<Integer, List<String>> wordsGroupMap = words.parallelStream()
				.collect(Collectors.groupingByConcurrent(String::length));

		wordsGroupMap.forEach((len, words) -> System.out.println(len + " -> " + words));
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, List<Candidate>> candidatesGroupMap = candidates.parallelStream()
				.collect(Collectors.groupingByConcurrent(Candidate::getDepartment));

		candidatesGroupMap.forEach((dept, members) -> System.out.println(dept + " -> " + members));

		System.out.println(
				"\n----------Difference Between groupingBy and groupingByConcurrent below: ----------------\n");
		// groupingBy → returns Map<K, List<T>>
		// NOT thread-safe
		Map<String, List<Candidate>> map1 = candidates.stream()
				.collect(Collectors.groupingBy(Candidate::getDepartment));

		System.out.println("map1 = " + map1);
		System.out.println("------------------------------------------------------------");

		// groupingByConcurrent → returns ConcurrentMap<K, List<T>>
		// Thread-safe, best with parallel streams
		ConcurrentMap<String, List<Candidate>> map2 = candidates.parallelStream()
				.collect(Collectors.groupingByConcurrent(Candidate::getDepartment));

		System.out.println("map2 = " + map2);

		System.out.println("\n---------------- Verify Concurrent Behavior with Parallel Stream below: -------------");
		ConcurrentMap<Integer, List<Integer>> result = IntStream.range(1, 20).parallel().boxed()
				.collect(Collectors.groupingByConcurrent(n -> n % 2));

		System.out.println("Even -> " + result.get(0));
		System.out.println("Odd  -> " + result.get(1));
		System.out.println("------------------------------------------------------------");
	}

	static void testGroupingByConcurrent_V2() {
		System.out.println("\n\n===================== testGroupingByConcurrent_V2() =====================");
		ConcurrentMap<String, Long> candidatesMap = candidates.parallelStream()
				.collect(Collectors.groupingByConcurrent(Candidate::getDepartment, Collectors.counting()));

		System.out.println(candidatesMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, List<String>> candidatesNamesMap = candidates.parallelStream()
				.collect(Collectors.groupingByConcurrent(Candidate::getDepartment,
						Collectors.mapping(Candidate::getName, Collectors.toList())));

		System.out.println(candidatesNamesMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, Double> totalSalaryMap = employees.parallelStream().collect(
				Collectors.groupingByConcurrent(Employee::getDept, Collectors.summingDouble(Employee::getSalary)));

		System.out.println(totalSalaryMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, Double> averageSalaryMap = employees.parallelStream().collect(
				Collectors.groupingByConcurrent(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(averageSalaryMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, Optional<Employee>> maxSalaryMap = employees.parallelStream().collect(Collectors
				.groupingByConcurrent(Employee::getDept, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

		maxSalaryMap.forEach((dept, empOpt) -> {
			Employee emp = empOpt.orElse(new Employee());
			System.out.println(
					"In " + dept + " department, " + emp.getName() + " has maximum Salary = " + emp.getSalary());
		});
		System.out.println("------------------------------------------------------------");
	}

	static void testGroupingByConcurrent_V3() {
		System.out.println("\n\n===================== testGroupingByConcurrent_V3() =====================");
		ConcurrentMap<String, Long> candidatesMap = candidates.parallelStream().collect(
				Collectors.groupingByConcurrent(Candidate::getDepartment, ConcurrentHashMap::new, Collectors.counting())

		);

		System.out.println(candidatesMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, List<Integer>> evenOddMap = numbers.parallelStream().collect(Collectors
				.groupingByConcurrent(n -> n % 2 == 0 ? "EVEN" : "ODD", ConcurrentHashMap::new, Collectors.toList()));

		System.out.println(evenOddMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, Double> avgSalaryMap = employees.parallelStream().collect(Collectors.groupingByConcurrent(
				Employee::getDept, ConcurrentHashMap::new, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(avgSalaryMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<Integer, Set<String>> wordsMap = words.parallelStream()
				.collect(Collectors.groupingByConcurrent(String::length, ConcurrentHashMap::new, Collectors.toSet()));

		System.out.println(wordsMap);
		System.out.println("------------------------------------------------------------");
	}

	static void testJoining() {
		System.out.println("\n\n===================== testJoining() =====================");
		String joined = names.stream().collect(Collectors.joining());
		System.out.println(joined);
		System.out.println("------------------------------------------------------------");

		String joinedWithDelimeter = names.stream().collect(Collectors.joining(", "));
		System.out.println(joinedWithDelimeter);
		System.out.println("------------------------------------------------------------");

		String joinedWithPrefixSuffix = names.stream().collect(Collectors.joining(", ", "<students>", "</students>"));
		System.out.println(joinedWithPrefixSuffix);
		System.out.println("------------------------------------------------------------");
	}

	static void testMapping() {
		System.out.println("\n\n===================== testMapping() =====================");
		List<String> data = words.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
		System.out.println(data);
		System.out.println("------------------------------------------------------------");

		Map<String, List<String>> employeesMap = employees.stream().collect(
				Collectors.groupingBy(Employee::getDept, Collectors.mapping(Employee::getName, Collectors.toList())));

		System.out.println(employeesMap);
		System.out.println("------------------------------------------------------------");

		Map<Integer, Set<String>> wordLengthMap = words.stream().collect(
				Collectors.groupingBy(String::length, Collectors.mapping(String::toUpperCase, Collectors.toSet())));

		System.out.println(wordLengthMap);
		System.out.println("------------------------------------------------------------");
	}

	static void testMaxBy() {
		System.out.println("\n\n===================== testMaxBy() =====================");
		System.out.println("Numbers = " + numbers);
		Optional<Integer> maxNumberOpt = numbers.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
		maxNumberOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Optional<Integer> maxNumberOpt2 = numbers.stream().collect(Collectors.maxBy(Comparator.reverseOrder()));
		maxNumberOpt2.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		System.out.println("Numbers Including Null = " + numbersIncludingNull);

		numbersIncludingNull.sort(Comparator.nullsFirst(Comparator.naturalOrder()));

		System.out.println("Numbers with Null First = " + numbersIncludingNull);

		numbersIncludingNull.sort(Comparator.nullsLast(Comparator.naturalOrder()));
		System.out.println("Numbers with Null Last = " + numbersIncludingNull);
		System.out.println("------------------------------------------------------------");

		Optional<Employee> employeeOpt = employees.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

		employeeOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Optional<Order> latestOrderOpt = orders.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Order::getOrderDate)));

		latestOrderOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Map<String, Optional<Employee>> employeeOptionalMap = employees.stream().collect(Collectors
				.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

		employeeOptionalMap.forEach((department, optionalEmployee) -> System.out
				.println(department + "" + optionalEmployee.orElse(new Employee())));
	}

	static void testMinBy() {
		System.out.println("\n\n===================== testMinBy() =====================");
		System.out.println("Numbers = " + numbers);
		Optional<Integer> minNumberOpt = numbers.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
		minNumberOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Optional<Integer> minNumberOpt2 = numbers.stream().collect(Collectors.minBy(Comparator.reverseOrder()));
		minNumberOpt2.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Optional<Employee> employeeOpt = employees.stream()
				.collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));

		employeeOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Optional<Order> oldOrderOpt = orders.stream()
				.collect(Collectors.minBy(Comparator.comparing(Order::getOrderDate)));

		oldOrderOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Map<String, Optional<Employee>> employeeOptionalMap = employees.stream().collect(Collectors
				.groupingBy(Employee::getDept, Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))));

		employeeOptionalMap.forEach((department, optionalEmployee) -> System.out
				.println(department + "" + optionalEmployee.orElse(new Employee())));
	}

	public static void main(String[] args) {
		testAveragingDouble();
		testAveragingInt();
		testAveragingLong();
		testCollectingAndThen();
		testCounting();
		testGroupingBy_V1();
		testGroupingBy_V2();
		testGroupingBy_V3();
		testGroupingByConcurrent_V1();
		testGroupingByConcurrent_V2();
		testGroupingByConcurrent_V3();
		testJoining();
		testMapping();
		testMaxBy();
		testMinBy();
	}
}
