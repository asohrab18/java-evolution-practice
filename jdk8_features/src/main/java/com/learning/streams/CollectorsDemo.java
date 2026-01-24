package com.learning.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.learning.model.AppUtils;
import com.learning.model.Candidate;
import com.learning.model.Employee;
import com.learning.model.Order;
import com.learning.model.Person;
import com.learning.model.Student;

public class CollectorsDemo {

	static void testAveragingDouble() {
		System.out.println("===================== testAveragingDouble() =====================");
		System.out.println("Numbers = " + AppUtils.numbers);
		Double average = AppUtils.numbers.stream().collect(Collectors.averagingDouble(n -> n));
		System.out.println("Average = " + average);
		System.out.println("------------------------------------------------------------");

		List<Double> salaries = AppUtils.employees.stream().map(e -> e.getSalary()).collect(Collectors.toList());
		System.out.println("Salaries of employees = " + salaries);

		Double averageSalary = AppUtils.employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("\nAverage Salary = " + averageSalary);
		System.out.println("------------------------------------------------------------");

		List<Integer> ages = AppUtils.students.stream().map(s -> s.getAge()).collect(Collectors.toList());
		System.out.println("Ages of students = " + ages);

		Double averageAge = AppUtils.students.stream().collect(Collectors.averagingDouble(Student::getAge));
		System.out.println("Average Age = " + averageAge);
		System.out.println("------------------------------------------------------------");

		System.out.println("Prices = " + AppUtils.prices);
		Double averagePrice = AppUtils.prices.stream().collect(Collectors.averagingDouble(p -> p));
		System.out.println("Average Price = " + averagePrice);

		Double averagePriceWithTax = AppUtils.prices.stream().collect(Collectors.averagingDouble(p -> p + 0.18 * p));
		System.out.println("Average Price with 18% GST = " + averagePriceWithTax);
		System.out.println("------------------------------------------------------------");
	}

	static void testAveragingInt() {
		System.out.println("\n\n===================== testAveragingInt() =====================");
		System.out.println("Numbers = " + AppUtils.numbers);

		Double average = AppUtils.numbers.stream().collect(Collectors.averagingInt(n -> n));
		System.out.println("Average = " + average);
		System.out.println("------------------------------------------------------------");

		List<Integer> ages = AppUtils.employees.stream().map(e -> e.getAge()).collect(Collectors.toList());
		System.out.println("Ages of employees = " + ages);

		Double averageAge = AppUtils.employees.stream().collect(Collectors.averagingInt(Employee::getAge));
		System.out.println("\nAverage Age = " + averageAge);
		System.out.println("------------------------------------------------------------");
	}

	static void testAveragingLong() {
		System.out.println("\n\n===================== testAveragingLong() =====================");
		System.out.println("Numbers = " + AppUtils.numbersL);

		Double average = AppUtils.numbersL.stream().collect(Collectors.averagingLong(n -> n));
		System.out.println("Average = " + average);
		System.out.println("------------------------------------------------------------");
	}

	static void testCollectingAndThen() {
		System.out.println("\n\n===================== testCollectingAndThen() =====================");
		List<String> mutableNames = AppUtils.students.stream().map(s -> s.getName()).collect(Collectors.toList());
		System.out.println("Mutable Names = " + mutableNames);

		mutableNames.add("Zeeshan");
		System.out.println("\nUpdated Mutable Names = " + mutableNames);

		System.out.println("------------------------------------------------------------");
		List<String> immutableNames = AppUtils.students.stream().map(s -> s.getName())
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

		System.out.println("Immutable Names = " + immutableNames);
		try {
			immutableNames.add("Mike");
		} catch (UnsupportedOperationException e) {
			System.out.println("\nCannot modify Immutable Names = " + immutableNames);
		}
		System.out.println("------------------------------------------------------------");

		System.out.println("Duplicate Numbers = " + AppUtils.duplicateNumbers);

		int howManyUniqueNumbers = AppUtils.duplicateNumbers.stream()
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Set::size));

		System.out.println("How many unique Numbers are available?\nANS: " + howManyUniqueNumbers);
		System.out.println("------------------------------------------------------------");

		List<Integer> sortedNumbers = AppUtils.numbers.stream()
				.collect(Collectors.collectingAndThen(Collectors.toSet(), set -> set.stream().sorted().toList()));

		System.out.println("Sorted unique Numbers = " + sortedNumbers);
		System.out.println("------------------------------------------------------------");
	}

	static void testCounting() {
		System.out.println("\n\n===================== testCounting() =====================");
		List<Integer> ages = AppUtils.employees.stream().map(e -> e.getAge())
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted().toList()));
		System.out.println("Ages = " + ages);

		Long minors = AppUtils.employees.stream().filter(e -> e.getAge() < 18).collect(Collectors.counting());
		System.out.println("No. of Minors = " + minors);

		Long adults = AppUtils.employees.stream().filter(e -> e.getAge() >= 18).collect(Collectors.counting());
		System.out.println("No. of Adults = " + adults);
		System.out.println("------------------------------------------------------------");
	}

	static void testGroupingBy_V1() {
		System.out.println("\n\n===================== testGroupingBy_V1() =====================");
		Function<Employee, String> departmentFunction = e -> e.getDept();
		Map<String, List<Employee>> employeesMap = AppUtils.employees.stream()
				.collect(Collectors.groupingBy(departmentFunction));

		System.out.println(employeesMap);
		System.out.println("------------------------------------------------------------");

		Map<String, List<Person>> personsMap = AppUtils.persons.stream().collect(Collectors.groupingBy(Person::getCountry));
		System.out.println(personsMap);
		System.out.println("------------------------------------------------------------");

		Map<Integer, List<String>> wordsMap = AppUtils.words.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(wordsMap);
		System.out.println("------------------------------------------------------------");

		System.out.println("Numbers: " + AppUtils.numbers);
		Function<Integer, String> evenOddFunction = i -> i % 2 == 0 ? "EVEN" : "ODD";

		Map<String, List<Integer>> evenOddMap = AppUtils.numbers.stream().collect(Collectors.groupingBy(evenOddFunction));

		System.out.println(evenOddMap);
		System.out.println("------------------------------------------------------------");

		Function<String, Character> charFunction = s -> s.charAt(0);
		Map<Character, List<String>> namesMap = AppUtils.names.stream().collect(Collectors.groupingBy(charFunction));
		System.out.println(namesMap);
		System.out.println("------------------------------------------------------------");

		Function<Student, String> ageStatusFunction = s -> s.getAge() >= 18 ? "ADULTS" : "MINORS";
		Map<String, List<Student>> maturityMap = AppUtils.students.stream().collect(Collectors.groupingBy(ageStatusFunction));
		System.out.println(maturityMap);
		System.out.println("------------------------------------------------------------");
	}

	static void testGroupingBy_V2() {
		System.out.println("\n\n===================== testGroupingBy_V2() =====================");
		Map<String, List<Person>> personsMap = AppUtils.persons.stream()
				.collect(Collectors.groupingBy(Person::getCountry, Collectors.toList()));

		System.out.println(personsMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Long> personsCountingMap = AppUtils.persons.stream()
				.collect(Collectors.groupingBy(Person::getCountry, Collectors.counting()));

		System.out.println(personsCountingMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Double> employeesSalaryMap = AppUtils.employees.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.summingDouble(Employee::getSalary)));

		System.out.println(employeesSalaryMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Optional<Employee>> employeesHighestSalaryMap = AppUtils.employees.stream().collect(
				Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

		System.out.println(employeesHighestSalaryMap);
		System.out.println("------------------------------------------------------------");

		Map<String, List<String>> personsNameMap = AppUtils.persons.stream().collect(
				Collectors.groupingBy(Person::getCountry, Collectors.mapping(Person::getName, Collectors.toList())));

		System.out.println(personsNameMap);
		System.out.println("------------------------------------------------------------");

		Function<Student, String> adultsMinorFunction = s -> s.getAge() >= 18 ? "ADULTS" : "MINORS";
		Function<Student, String> nameAgeFunction = s -> s.getName() + " is " + s.getAge() + " years old.";

		Map<String, List<String>> studentsMap = AppUtils.students.stream().collect(
				Collectors.groupingBy(adultsMinorFunction, Collectors.mapping(nameAgeFunction, Collectors.toList())));

		System.out.println(studentsMap);
		System.out.println("------------------------------------------------------------");
	}

	static void testGroupingBy_V3() {
		System.out.println("\n\n===================== testGroupingBy_V3() =====================");
		Map<String, List<Candidate>> candidatesMap = AppUtils.candidates.stream()
				.collect(Collectors.groupingBy(Candidate::getDepartment, HashMap::new, Collectors.toList()));

		System.out.println(candidatesMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Long> candidatesCountMap = AppUtils.candidates.stream()
				.collect(Collectors.groupingBy(Candidate::getDepartment, LinkedHashMap::new, Collectors.counting()));

		System.out.println(candidatesCountMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Double> employeesMap = AppUtils.employees.stream().collect(
				Collectors.groupingBy(Employee::getDept, TreeMap::new, Collectors.summingDouble(Employee::getSalary)));

		System.out.println(employeesMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Double> employeesAverageSalaryMap = AppUtils.employees.stream().collect(Collectors
				.groupingBy(Employee::getDept, TreeMap::new, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(employeesAverageSalaryMap);
		System.out.println("------------------------------------------------------------");

		Map<String, List<String>> employeesNamesMap = AppUtils.employees.stream().collect(Collectors.groupingBy(
				Employee::getDept, TreeMap::new, Collectors.mapping(Employee::getName, Collectors.toList())));

		System.out.println(employeesNamesMap);
		System.out.println("------------------------------------------------------------");

		Map<String, DoubleSummaryStatistics> employeesSummaryMap = AppUtils.employees.stream().collect(Collectors
				.groupingBy(Employee::getDept, TreeMap::new, Collectors.summarizingDouble(Employee::getSalary)));

		System.out.println(employeesSummaryMap);
		System.out.println("------------------------------------------------------------");

		Map<String, Employee> highestPaidByDept = AppUtils.employees.stream()
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
		System.out.println("Words = " + AppUtils.words);

		ConcurrentMap<Integer, List<String>> wordsGroupMap = AppUtils.words.parallelStream()
				.collect(Collectors.groupingByConcurrent(String::length));

		wordsGroupMap.forEach((len, words) -> System.out.println(len + " -> " + words));
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, List<Candidate>> candidatesGroupMap = AppUtils.candidates.parallelStream()
				.collect(Collectors.groupingByConcurrent(Candidate::getDepartment));

		candidatesGroupMap.forEach((dept, members) -> System.out.println(dept + " -> " + members));

		System.out.println(
				"\n----------Difference Between groupingBy and groupingByConcurrent below: ----------------\n");
		// groupingBy → returns Map<K, List<T>>
		// NOT thread-safe
		Map<String, List<Candidate>> map1 = AppUtils.candidates.stream()
				.collect(Collectors.groupingBy(Candidate::getDepartment));

		System.out.println("map1 = " + map1);
		System.out.println("------------------------------------------------------------");

		// groupingByConcurrent → returns ConcurrentMap<K, List<T>>
		// Thread-safe, best with parallel streams
		ConcurrentMap<String, List<Candidate>> map2 = AppUtils.candidates.parallelStream()
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
		ConcurrentMap<String, Long> candidatesMap = AppUtils.candidates.parallelStream()
				.collect(Collectors.groupingByConcurrent(Candidate::getDepartment, Collectors.counting()));

		System.out.println(candidatesMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, List<String>> candidatesNamesMap = AppUtils.candidates.parallelStream()
				.collect(Collectors.groupingByConcurrent(Candidate::getDepartment,
						Collectors.mapping(Candidate::getName, Collectors.toList())));

		System.out.println(candidatesNamesMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, Double> totalSalaryMap = AppUtils.employees.parallelStream().collect(
				Collectors.groupingByConcurrent(Employee::getDept, Collectors.summingDouble(Employee::getSalary)));

		System.out.println(totalSalaryMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, Double> averageSalaryMap = AppUtils.employees.parallelStream().collect(
				Collectors.groupingByConcurrent(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(averageSalaryMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, Optional<Employee>> maxSalaryMap = AppUtils.employees.parallelStream().collect(Collectors
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
		ConcurrentMap<String, Long> candidatesMap = AppUtils.candidates.parallelStream().collect(
				Collectors.groupingByConcurrent(Candidate::getDepartment, ConcurrentHashMap::new, Collectors.counting())

		);

		System.out.println(candidatesMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, List<Integer>> evenOddMap = AppUtils.numbers.parallelStream().collect(Collectors
				.groupingByConcurrent(n -> n % 2 == 0 ? "EVEN" : "ODD", ConcurrentHashMap::new, Collectors.toList()));

		System.out.println(evenOddMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, Double> avgSalaryMap = AppUtils.employees.parallelStream().collect(Collectors.groupingByConcurrent(
				Employee::getDept, ConcurrentHashMap::new, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(avgSalaryMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<Integer, Set<String>> wordsMap = AppUtils.words.parallelStream()
				.collect(Collectors.groupingByConcurrent(String::length, ConcurrentHashMap::new, Collectors.toSet()));

		System.out.println(wordsMap);
		System.out.println("------------------------------------------------------------");
	}

	static void testJoining() {
		System.out.println("\n\n===================== testJoining() =====================");
		String joined = AppUtils.names.stream().collect(Collectors.joining());
		System.out.println(joined);
		System.out.println("------------------------------------------------------------");

		String joinedWithDelimeter = AppUtils.names.stream().collect(Collectors.joining(", "));
		System.out.println(joinedWithDelimeter);
		System.out.println("------------------------------------------------------------");

		String joinedWithPrefixSuffix = AppUtils.names.stream().collect(Collectors.joining(", ", "<students>", "</students>"));
		System.out.println(joinedWithPrefixSuffix);
		System.out.println("------------------------------------------------------------");
	}

	static void testMapping() {
		System.out.println("\n\n===================== testMapping() =====================");
		List<String> data = AppUtils.words.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
		System.out.println(data);
		System.out.println("------------------------------------------------------------");

		Map<String, List<String>> employeesMap = AppUtils.employees.stream().collect(
				Collectors.groupingBy(Employee::getDept, Collectors.mapping(Employee::getName, Collectors.toList())));

		System.out.println(employeesMap);
		System.out.println("------------------------------------------------------------");

		Map<Integer, Set<String>> wordLengthMap = AppUtils.words.stream().collect(
				Collectors.groupingBy(String::length, Collectors.mapping(String::toUpperCase, Collectors.toSet())));

		System.out.println(wordLengthMap);
		System.out.println("------------------------------------------------------------");
	}

	static void testMaxBy() {
		System.out.println("\n\n===================== testMaxBy() =====================");
		System.out.println("Numbers = " + AppUtils.numbers);
		Optional<Integer> maxNumberOpt = AppUtils.numbers.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
		maxNumberOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Optional<Integer> maxNumberOpt2 = AppUtils.numbers.stream().collect(Collectors.maxBy(Comparator.reverseOrder()));
		maxNumberOpt2.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		System.out.println("Numbers Including Null = " + AppUtils.numbersIncludingNull);

		AppUtils.numbersIncludingNull.sort(Comparator.nullsFirst(Comparator.naturalOrder()));

		System.out.println("Numbers with Null First = " + AppUtils.numbersIncludingNull);

		AppUtils.numbersIncludingNull.sort(Comparator.nullsLast(Comparator.naturalOrder()));
		System.out.println("Numbers with Null Last = " + AppUtils.numbersIncludingNull);
		System.out.println("------------------------------------------------------------");

		Optional<Employee> employeeOpt = AppUtils.employees.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

		employeeOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Optional<Order> latestOrderOpt = AppUtils.orders.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Order::getOrderDate)));

		latestOrderOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Map<String, Optional<Employee>> employeeOptionalMap = AppUtils.employees.stream().collect(Collectors
				.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

		employeeOptionalMap.forEach((department, optionalEmployee) -> System.out
				.println(department + "" + optionalEmployee.orElse(new Employee())));
	}

	static void testMinBy() {
		System.out.println("\n\n===================== testMinBy() =====================");
		System.out.println("Numbers = " + AppUtils.numbers);
		Optional<Integer> minNumberOpt = AppUtils.numbers.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
		minNumberOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Optional<Integer> minNumberOpt2 = AppUtils.numbers.stream().collect(Collectors.minBy(Comparator.reverseOrder()));
		minNumberOpt2.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Optional<Employee> employeeOpt = AppUtils.employees.stream()
				.collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));

		employeeOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Optional<Order> oldOrderOpt = AppUtils.orders.stream()
				.collect(Collectors.minBy(Comparator.comparing(Order::getOrderDate)));

		oldOrderOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Map<String, Optional<Employee>> employeeOptionalMap = AppUtils.employees.stream().collect(Collectors
				.groupingBy(Employee::getDept, Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))));

		employeeOptionalMap.forEach((department, optionalEmployee) -> System.out
				.println(department + "" + optionalEmployee.orElse(new Employee())));

		System.out.println("------------------------------------------------------------");
	}

	static void testPartitioningBy_V1() {
		System.out.println("\n\n===================== testPartitioningBy_V1() =====================");
		System.out.println("Numbers = " + AppUtils.numbers);

		Map<Boolean, List<Integer>> numbersMap = AppUtils.numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

		System.out.println("numbersMap = " + numbersMap);
		System.out.println("Odd Numbers = " + numbersMap.get(false));
		System.out.println("Even Numbers = " + numbersMap.get(true));
		System.out.println("------------------------------------------------------------");

		System.out.println("names = " + AppUtils.names);
		Map<Boolean, List<String>> namesMap = AppUtils.names.stream().collect(Collectors.partitioningBy(s -> s.length() > 4));

		System.out.println("namesMap = " + namesMap);
		System.out.println("Names with less than or equal to 4 characters = " + namesMap.get(false));
		System.out.println("Names with greater than 4 characters = " + namesMap.get(true));
		System.out.println("------------------------------------------------------------");

		double salary = 15000d;
		Map<Boolean, List<Employee>> employeesMap = AppUtils.employees.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getSalary() >= salary));

		List<Employee> employeesWithHigherSalary = employeesMap.get(true);
		List<Employee> employeesWithLowerSalary = employeesMap.get(false);

		Function<Employee, String> nameFunction = e -> e.getName();

		List<String> names = employeesWithHigherSalary.stream()
				.collect(Collectors.mapping(nameFunction, Collectors.toList()));

		List<String> otherNames = employeesWithLowerSalary.stream()
				.collect(Collectors.mapping(nameFunction, Collectors.toList()));

		System.out.println("Employees With Salary >= " + salary + " : " + names);
		System.out.println("Employees With Salary < " + salary + " : " + otherNames);
		System.out.println("------------------------------------------------------------");
	}

	static void testPartitioningBy_V2() {
		System.out.println("\n\n===================== testPartitioningBy_V2() =====================");
		System.out.println("Numbers = " + AppUtils.numbers);

		Map<Boolean, Long> numbersMap = AppUtils.numbers.stream()
				.collect(Collectors.partitioningBy(n -> n % 2 == 0, Collectors.counting()));

		System.out.println("Total available Odd Numbers = " + numbersMap.get(false));
		System.out.println("Total available Even Numbers = " + numbersMap.get(true));
		System.out.println("------------------------------------------------------------");

		System.out.println("names = " + AppUtils.names);
		Map<Boolean, String> namesMap = AppUtils.names.stream()
				.collect(Collectors.partitioningBy(s -> s.length() > 4, Collectors.joining(", ")));

		System.out.println("Names with less than or equal to 4 characters = " + namesMap.get(false));
		System.out.println("Names with greater than 4 characters = " + namesMap.get(true));
		System.out.println("------------------------------------------------------------");

		double salary = 15000d;

		Map<Boolean, List<String>> employeesMap = AppUtils.employees.stream().collect(Collectors.partitioningBy(
				emp -> emp.getSalary() >= salary, Collectors.mapping(Employee::getName, Collectors.toList())));

		List<String> employeesWithHigherSalary = employeesMap.get(true);
		List<String> employeesWithLowerSalary = employeesMap.get(false);

		System.out.println("Employees With Salary >= " + salary + " : " + employeesWithHigherSalary);
		System.out.println("Employees With Salary < " + salary + " : " + employeesWithLowerSalary);
		System.out.println("------------------------------------------------------------");
	}

	static void testReducing_V1() {
		System.out.println("\n\n===================== testReducing_V1() =====================");
		System.out.println("words = " + AppUtils.words + "\n");

		BinaryOperator<String> longStringBo = (s1, s2) -> s1.length() >= s2.length() ? s1 : s2;
		Optional<String> longestStringOpt = AppUtils.words.stream().collect(Collectors.reducing(longStringBo));

		System.out.println("Longest String is '" + longestStringOpt.get() + "'\n");
		System.out.println("------------------------------------------------------------");

		BinaryOperator<Employee> highestSalaryBo = (emp1, emp2) -> emp1.getSalary() >= emp2.getSalary() ? emp1 : emp2;
		Optional<Employee> highestSalaryOpt = AppUtils.employees.stream().collect(Collectors.reducing(highestSalaryBo));

		System.out.println("Highest salary employee is: " + highestSalaryOpt.get() + "\n");
		System.out.println("------------------------------------------------------------");
	}

	static void testReducing_V2() {
		System.out.println("\n\n===================== testReducing_V2() =====================");
		BinaryOperator<String> longStringBo = (s1, s2) -> s1.length() >= s2.length() ? s1 : s2;
		String longestString = AppUtils.words.stream().collect(Collectors.reducing("", longStringBo));

		System.out.println("Longest String is '" + longestString + "'\n");
		System.out.println("------------------------------------------------------------");

		BinaryOperator<Employee> highestSalaryBo = (emp1, emp2) -> emp1.getSalary() >= emp2.getSalary() ? emp1 : emp2;
		Employee highestSalaryEmployee = AppUtils.employees.stream()
				.collect(Collectors.reducing(new Employee(), highestSalaryBo));

		System.out.println("Highest salary employee is: " + highestSalaryEmployee + "\n");
		System.out.println("------------------------------------------------------------");
	}

	static void testReducing_V3() {
		System.out.println("\n\n===================== testReducing_V3() =====================");

		BinaryOperator<Integer> ageBo = (a1, a2) -> a1 >= a2 ? a1 : a2;
		Integer age = AppUtils.students.stream().collect(Collectors.reducing(0, Student::getAge, ageBo));
		System.out.println("Oldest Student's age is: " + age + "\n");
		System.out.println("------------------------------------------------------------");

		BinaryOperator<Double> salaryBo = (sal1, sal2) -> sal1 >= sal2 ? sal1 : sal2;
		Double maxSalary = AppUtils.employees.stream().collect(Collectors.reducing(0d, Employee::getSalary, salaryBo));
		System.out.println("Highest salary of an employee is: " + maxSalary + "\n");
		System.out.println("------------------------------------------------------------");
	}

	static void testSummarizingDouble() {
		System.out.println("\n\n===================== testSummarizingDouble() =====================");
		DoubleSummaryStatistics employeesSalaryStatistics = AppUtils.employees.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		System.out.println(employeesSalaryStatistics);
		System.out.println("------------------------------------------------------------");
	}

	static void testSummarizingInt() {
		System.out.println("\n\n===================== testSummarizingInt() =====================");
		IntSummaryStatistics employessAgeStatistics = AppUtils.employees.stream()
				.collect(Collectors.summarizingInt(Employee::getAge));

		System.out.println(employessAgeStatistics);
		System.out.println("------------------------------------------------------------");
	}

	static void testSummarizingLong() {
		System.out.println("\n\n===================== testSummarizingLong() =====================");
		LongSummaryStatistics numbersSummaryStatistics = AppUtils.numbersL.stream()
				.collect(Collectors.summarizingLong(num -> num));
		System.out.println(numbersSummaryStatistics);
		System.out.println("------------------------------------------------------------");
	}

	static void testSummingDouble() {
		System.out.println("\n\n===================== testSummingDouble() =====================");
		Double totalSalaryOfEmployees = AppUtils.employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("Total Salary of all employees = " + totalSalaryOfEmployees);
		System.out.println("------------------------------------------------------------");

		Map<String, Double> employeesSalaryMap = AppUtils.employees.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.summingDouble(Employee::getSalary)));

		employeesSalaryMap.forEach((dept, totalSalary) -> System.out.println(dept + ": " + totalSalary));

		System.out.println("------------------------------------------------------------");
	}

	static void testSummingInt() {
		System.out.println("\n\n===================== testSummingInt() =====================");
		System.out.println("numbers = " + AppUtils.numbers);
		Integer sum = AppUtils.numbers.stream().collect(Collectors.summingInt(n -> n));
		System.out.println("Total Sum = " + sum);
		System.out.println("------------------------------------------------------------");
	}

	static void testSummingLong() {
		System.out.println("\n\n===================== testSummingLong() =====================");
		System.out.println("numbers = " + AppUtils.numbersL);
		Long sum = AppUtils.numbersL.stream().collect(Collectors.summingLong(n -> n));
		System.out.println("Total Sum = " + sum);
		System.out.println("------------------------------------------------------------");
	}

	static void testToCollection() {
		System.out.println("\n\n===================== testToCollection() =====================");
		List<String> fruits = List.of("Apple", "Banana", "Coconut", "Mango");
		ArrayList<String> fruitsArrayList = fruits.stream().collect(Collectors.toCollection(ArrayList::new));
		System.out.println("fruitsArrayList = " + fruitsArrayList);
		System.out.println("------------------------------------------------------------");

		List<Integer> ranks = List.of(10, 20, 30, 40, 50);
		LinkedList<Integer> ranksLinkedList = ranks.stream().collect(Collectors.toCollection(LinkedList::new));
		System.out.println("ranksLinkedList = " + ranksLinkedList);
		System.out.println("------------------------------------------------------------");

		List<String> alphabets = List.of("A", "A", "B", "C", "C", "D");
		HashSet<String> alphabetsHashSet = alphabets.stream().collect(Collectors.toCollection(HashSet::new));
		System.out.println("alphabetsHashSet = " + alphabetsHashSet);
		System.out.println("------------------------------------------------------------");

		List<Integer> rollNumbers = List.of(5, 2, 4, 3, 1, 1, 1, 2, 3, 4, 6, 8, 9, 10, 10);
		TreeSet<Integer> rollNumbersTreeSet = rollNumbers.stream().collect(Collectors.toCollection(TreeSet::new));
		System.out.println("rollNumbersTreeSet = " + rollNumbersTreeSet);
		System.out.println("------------------------------------------------------------");

		List<Integer> nums = List.of(40, 10, 30);
		PriorityQueue<Integer> numsPriorityQueue = nums.stream().collect(Collectors.toCollection(PriorityQueue::new));
		System.out.println("numsPriorityQueue = " + numsPriorityQueue);
		System.out.println("------------------------------------------------------------");
	}

	static void testToList() {
		System.out.println("\n\n===================== testToList() =====================");
		List<String> immutableFruits = List.of("Apple", "Banana", "Coconut", "Mango");
		System.out.println("fruits = " + immutableFruits);

		List<String> mutableFruits = immutableFruits.stream().collect(Collectors.toList());
		mutableFruits.add("Papaya");
		System.out.println("mutableFruits = " + mutableFruits);
		System.out.println("------------------------------------------------------------");
	}

	static void testToSet() {
		System.out.println("\n\n===================== testToSet() =====================");
		Set<String> immutableFruits = Set.of("Apple", "Banana", "Coconut", "Mango");
		System.out.println("fruits = " + immutableFruits);

		Set<String> mutableFruits = immutableFruits.stream().collect(Collectors.toSet());
		mutableFruits.add("Papaya");
		mutableFruits.add("Papaya");
		mutableFruits.add("Guava");
		System.out.println("mutableFruits = " + mutableFruits);
		System.out.println("------------------------------------------------------------");
	}

	static void testToConcurrentMap_V1() {
		System.out.println("\n\n===================== testToConcurrentMap_V1() =====================");

		ConcurrentMap<Integer, String> employeesMap = AppUtils.employees.stream()
				.collect(Collectors.toConcurrentMap(Employee::getId, Employee::getName));

		System.out.println("Employees Map = " + employeesMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, Integer> namesMap = AppUtils.names.stream()
				.collect(Collectors.toConcurrentMap(name -> name, String::length));

		System.out.println("Names Map = " + namesMap);
		System.out.println("------------------------------------------------------------");
	}

	static void testToConcurrentMap_V2() {
		System.out.println("\n\n===================== testToConcurrentMap_V2() =====================");

		ConcurrentMap<String, Integer> wordsMap = AppUtils.words.stream()
				.collect(Collectors.toConcurrentMap(word -> word, String::length, (val1, val2) -> val1 + val2 * 0));

		System.out.println("Words Map = " + wordsMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, Double> departmentSalaryMap = AppUtils.employees.stream().collect(Collectors
				.toConcurrentMap(Employee::getDept, Employee::getSalary, (sal1, sal2) -> sal1 >= sal2 ? sal1 : sal2));

		System.out.println("Department-Salary Map = " + departmentSalaryMap);
		System.out.println("------------------------------------------------------------");

		ConcurrentMap<String, Integer> wordFrequencyMap = AppUtils.words.stream()
				.collect(Collectors.toConcurrentMap(word -> word, val -> 1, (val1, val2) -> val1 + val2));

		System.out.println("Word Frequency Map = " + wordFrequencyMap);
		System.out.println("------------------------------------------------------------");
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
		testPartitioningBy_V1();
		testPartitioningBy_V2();
		testReducing_V1();
		testReducing_V2();
		testReducing_V3();
		testSummarizingDouble();
		testSummarizingInt();
		testSummarizingLong();
		testSummingDouble();
		testSummingInt();
		testSummingLong();
		testToCollection();
		testToList();
		testToSet();
		testToConcurrentMap_V1();
		testToConcurrentMap_V2();
	}
}
