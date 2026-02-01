package com.learning.streams;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import com.learning.model.Animal;
import com.learning.model.AppUtils;
import com.learning.model.Candidate;
import com.learning.model.Cat;
import com.learning.model.Dog;
import com.learning.model.Employee;
import com.learning.model.Order;
import com.learning.model.Student;

public class StreamDemo {

	public static Stream<String> useStreamBuilder(String input) {
		if (input == null || input.isBlank() || input.isEmpty()) {
			return Stream.empty();
		}
		input = input.trim();
		Stream.Builder<String> sb = Stream.builder();
		if (input.equalsIgnoreCase("F")) {
			sb.accept("Apple");
			sb.accept("Banana");
			sb.add("Coconut");
			sb.add("Dates");
			sb.add("Guava");
		} else if (input.equalsIgnoreCase("V")) {
			sb.accept("Brinjal");
			sb.accept("Carrot");
			sb.add("Chilly");
			sb.add("Potato");
			sb.accept("Redish");
			sb.add("Tomato");
		} else {
			sb.accept("A");
			sb.accept("B");
			sb.add("C");
			sb.accept("D");
		}
		Stream<String> stream = sb.build();
		return stream;
	}

	public static void createStream() {
		System.out.println("===================== createStream() =====================");
		Stream<String> stream = useStreamBuilder("V");
		stream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<String> statusStream = Stream.of("ACTIVE");
		statusStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5);
		numbersStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");
	}

	public static void testAllMatch() {
		System.out.println("\n\n===================== testAllMatch() =====================");

		Stream<Integer> numbersStream = AppUtils.getIntStream("ODD_NUMBERS");
		boolean allOdd = numbersStream.allMatch(i -> i % 2 != 0);

		System.out.println("Are all NUMBERS Odd? ANS: " + allOdd);
		System.out.println("------------------------------------------------------------");

		Stream<Integer> numbersStream2 = AppUtils.getIntStream("EVEN_NUMBERS");
		boolean allEven = numbersStream2.allMatch(i -> i % 2 == 0);

		System.out.println("Are all NUMBERS Even? ANS: " + allEven);
		System.out.println("------------------------------------------------------------");

		Stream<String> namesStream = AppUtils.getStringStream("NAMES");
		boolean allNamesStartWithA = namesStream.allMatch(s -> s.startsWith("A"));

		System.out.println("Do all NAMES start with A? ANS: " + allNamesStartWithA);
		System.out.println("------------------------------------------------------------");
	}

	public static void testAnyMatch() {
		System.out.println("\n\n===================== testAnyMatch() =====================");

		Stream<Integer> numbersStream = AppUtils.getIntStream("NUMBERS");
		boolean anyEven = numbersStream.anyMatch(i -> i % 2 == 0);

		System.out.println("Is there any even number? ANS: " + anyEven);
		System.out.println("------------------------------------------------------------");

		Stream<Integer> numbersStream2 = AppUtils.getIntStream("EVEN_NUMBERS");
		boolean anyOdd = numbersStream2.anyMatch(i -> i % 2 != 0);
		System.out.println("Is there any odd number? ANS: " + anyOdd);
		System.out.println("------------------------------------------------------------");

		Stream<String> namesStream = AppUtils.getStringStream("NAMES");
		boolean anyNameStartsWithA = namesStream.anyMatch(s -> s.startsWith("A"));

		System.out.println("Is there any name starting with A? ANS: " + anyNameStartsWithA);
		System.out.println("------------------------------------------------------------");
	}

	public static void testCollect_V1() {
		System.out.println("\n\n===================== testCollect_V1() =====================");
		List<Integer> EVEN_NUMBERS = AppUtils.getIntStream("NUMBERS").filter(n -> n % 2 == 0)
				.collect(Collectors.toList());

		System.out.println("Even NUMBERS: " + EVEN_NUMBERS);
		System.out.println("------------------------------------------------------------");

		Set<Integer> uniqueNumbers = AppUtils.getIntStream("DUPLICATE_NUMBERS").collect(Collectors.toSet());

		System.out.println("unique NUMBERS: " + uniqueNumbers);
		System.out.println("------------------------------------------------------------");
	}

	public static void testCollect_V2() {
		System.out.println("\n\n===================== testCollect_V2() =====================");
		List<String> words = AppUtils.getStringStream("WORDS").collect(ArrayList::new, ArrayList::add,
				ArrayList::addAll);

		System.out.println("words: " + words);
		System.out.println("------------------------------------------------------------");

		Set<Integer> numbers = AppUtils.getIntStream("DUPLICATE_NUMBERS").collect(HashSet::new, HashSet::add,
				HashSet::addAll);

		System.out.println("numbers: " + numbers);
		System.out.println("------------------------------------------------------------");

		StringBuilder nameBuilder = AppUtils.getStringStream("NAMES").collect(StringBuilder::new, StringBuilder::append,
				StringBuilder::append);

		System.out.println("nameBuilder: " + nameBuilder);
		System.out.println("------------------------------------------------------------");

		BiConsumer<ArrayList<Integer>, Integer> accumulator = (list, num) -> {
			if (num % 2 == 0) {
				list.add(num);
			}
		};

		List<Integer> evenNumbers = AppUtils.getIntStream("NUMBERS").collect(ArrayList::new, accumulator,
				ArrayList::addAll);

		System.out.println("evenNumbers: " + evenNumbers);
		System.out.println("------------------------------------------------------------");
	}

	public static void testConcat() {
		System.out.println("\n\n===================== testConcat() =====================");
		Stream<String> wordsStream = AppUtils.getStringStream("WORDS");
		Stream<String> namesStream = AppUtils.getStringStream("NAMES");

		Stream<String> concatedStream = Stream.concat(wordsStream, namesStream);
		concatedStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<Dog> dogs = Stream.of(new Dog("Buddy"), new Dog("Rocky"));
		Stream<Cat> cats = Stream.of(new Cat("Kitty"), new Cat("Mimi"));
		Stream<Animal> animals = Stream.concat(dogs, cats);
		animals.forEach(a -> System.out.println(a.getName()));
		System.out.println("------------------------------------------------------------");

		Stream<Integer> oddNumbersStream = AppUtils.getIntStream("ODD_NUMBERS");
		Stream<Integer> evenNumbersStream = AppUtils.getIntStream("EVEN_NUMBERS");

		Stream<Integer> oddEvenconcatedStream = Stream.concat(oddNumbersStream, evenNumbersStream);

		oddEvenconcatedStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<Integer> parallelStream = AppUtils.getIntStream("NUMBERS").parallel();
		Stream<Integer> normalStream = AppUtils.getIntStream("DUPLICATE_NUMBERS");

		Stream<Integer> resultantStream = Stream.concat(parallelStream, normalStream);

		System.out.println(resultantStream.isParallel()
				? "A parallel stream concated with normal stream and the result stream is parallel stream."
				: "The result stream is not Parallel Stream.");

		System.out.println("------------------------------------------------------------");
	}

	public static void testCount() {
		System.out.println("\n\n===================== testCount() =====================");
		long candidates = AppUtils.CANDIDATES.stream().count();
		System.out.println("No. of candidates = " + candidates);

		System.out.println("------------------------------------------------------------");

		long employees = AppUtils.EMPLOYEES.stream().count();
		System.out.println("No. of employees = " + employees);
		System.out.println("------------------------------------------------------------");
	}

	public static void testDistinct() {
		System.out.println("\n\n===================== testDistinct() =====================");
		Stream<Integer> distinctNumbers = AppUtils.getIntStream("DUPLICATE_NUMBERS").distinct();

		distinctNumbers.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<Integer> distinctParallelNumbers = AppUtils.getIntStream("DUPLICATE_NUMBERS").parallel().distinct();

		distinctParallelNumbers.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<String> distinctWords = AppUtils.getStringStream("WORDS").distinct();
		distinctWords.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Order o1 = new Order(111, LocalDate.of(2023, 1, 18));
		Order o2 = new Order(111, LocalDate.of(1995, 11, 21));
		Order o3 = new Order(222, LocalDate.of(2025, 3, 8));
		Order o4 = new Order(222, LocalDate.of(1990, 10, 11));
		Order o5 = new Order(333, LocalDate.of(2021, 6, 9));
		Order o6 = new Order(333, LocalDate.of(1999, 9, 16));
		Order o7 = new Order(444, LocalDate.of(2026, 1, 12));
		Order o8 = new Order(444, LocalDate.of(1993, 8, 10));

		List<Order> orders = Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8);

		Stream<Order> distinctOrders = orders.stream().distinct();
		distinctOrders.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");
	}

	public static void testEmpty() {
		System.out.println("\n\n===================== testEmpty() =====================");
		Stream<Integer> intStream = AppUtils.getEmptyStream();
		System.out.println("Integer Stream count = " + intStream.count());

		Stream<String> strStream = AppUtils.getEmptyStream();
		System.out.println("String Stream count = " + strStream.count());
		System.out.println("------------------------------------------------------------");

		Stream<String> dataStream = AppUtils.getStringStream("OTHER");
		System.out.println("String Stream count = " + dataStream.count());
		System.out.println("------------------------------------------------------------");
	}

	public static void testFilter() {
		System.out.println("\n\n===================== testFilter() =====================");
		AppUtils.getIntStream("NUMBERS").filter(num -> num % 2 == 0).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.getStringStream("NAMES").filter(name -> name.startsWith("A")).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.EMPLOYEES.stream().filter(emp -> emp.getSalary() > 50000d)
				.forEach(emp -> System.out.println(emp.getName() + " has salary = " + emp.getSalary()));

		System.out
				.println("\n----------------------- filter & map together below -------------------------------------");

		AppUtils.getStringStream("WORDS").filter(word -> word.length() <= 5).map(String::toUpperCase)
				.forEach(System.out::println);

		System.out.println("------------------------------------------------------------");
	}

	public static void testFindAny() {
		System.out.println("\n\n===================== testFindAny() =====================");
		Optional<String> wordsOpt = AppUtils.getStringStream("WORDS").findAny();

		wordsOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Optional<Integer> evenNumbersOpt = AppUtils.getIntStream("NUMBERS").filter(n -> n % 2 == 0).findAny();

		evenNumbersOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");
	}

	public static void testFindFirst() {
		System.out.println("\n\n===================== testFindFirst() =====================");
		Optional<String> wordsOpt = AppUtils.getStringStream("WORDS").findFirst();

		wordsOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");

		Optional<Integer> evenNumbersOpt = AppUtils.getIntStream("NUMBERS").filter(n -> n % 2 == 0).findFirst();

		evenNumbersOpt.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");
	}

	public static void testFlatMap() {
		System.out.println("\n\n===================== testFlatMap() =====================");
		List<String> sentences = List.of("Java is powerful", "Streams are cool");

		Stream<String> resultStream = sentences.stream().flatMap(s -> {
			String[] words = s.split(" ");
			Stream<String> stringStream = Arrays.stream(words);
			return stringStream;
		});

		resultStream.forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		List<Candidate> candidates = List.of(new Candidate("Ali", "Finance", List.of("Java", "Spring")),
				new Candidate("Rahim", "Human Resource", List.of("SQL", "Docker")),
				new Candidate("John", "Science", List.of("Java", "AWS")));

		Stream<String> skillsStream = candidates.stream().flatMap(c -> {
			List<String> skills = c.getSkills();
			return skills.stream();
		});

		skillsStream.forEach(System.out::println);

		System.out.println("------------------------------------------------------------");
	}

	public static void testFlatMapToDouble() {
		System.out.println("\n\n===================== testFlatMapToDouble() =====================");

		DoubleStream studentsMarksStream = AppUtils.STUDENTS_WITH_MARKS.stream().flatMapToDouble(student -> {
			DoubleStream ds = Arrays.stream(student.getMarks());
			return ds;
		});

		studentsMarksStream.forEach(System.out::println);

		System.out.println("------------------------------------------------------------");
	}

	public static void testFlatMapToInt() {
		System.out.println("\n\n===================== testFlatMapToInt() =====================");

		IntStream subjectsCodesStream = AppUtils.STUDENTS_WITH_SUBJECTS_CODES.stream().flatMapToInt(student -> {
			IntStream is = Arrays.stream(student.getSubjectsCodes());
			return is;
		});

		subjectsCodesStream.forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		IntStream resultStream = AppUtils.STUDENTS_WITH_SUBJECTS_CODES.stream()
				.flatMapToInt(student -> student.getName().chars());

		resultStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");
	}

	public static void testFlatMapToLong() {
		System.out.println("\n\n===================== testFlatMapToLong() =====================");

		LongStream questionPapersCodesStream = AppUtils.STUDENTS_WITH_QUESTION_PAPERS_CODES.stream()
				.flatMapToLong(student -> {
					LongStream ls = Arrays.stream(student.getQuestionPapersCodes());
					return ls;
				});

		questionPapersCodesStream.forEach(System.out::println);

		System.out.println("------------------------------------------------------------");
	}

	public static void testForEach() {
		System.out.println("\n\n===================== testForEach() =====================");
		AppUtils.CANDIDATES.stream().forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		AppUtils.EMPLOYEES.stream().forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		AppUtils.ORDERS.stream().forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		AppUtils.PERSONS.stream().forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		AppUtils.STUDENTS.stream().forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		AppUtils.getStringStream("WORDS").forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		AppUtils.getIntStream("NUMBERS").forEach(System.out::println);
		System.out.println("------------------------------------------------------------");
	}

	public static void testForEachOrdered() {
		System.out.println("\n\n===================== testForEachOrdered() =====================");
		AppUtils.CANDIDATES.stream().forEachOrdered(System.out::println);
		System.out.println("------------------------------------------------------------");

		AppUtils.EMPLOYEES.stream().forEachOrdered(System.out::println);
		System.out.println("------------------------------------------------------------");

		AppUtils.ORDERS.stream().forEachOrdered(System.out::println);
		System.out.println("------------------------------------------------------------");

		AppUtils.PERSONS.stream().forEachOrdered(System.out::println);
		System.out.println("------------------------------------------------------------");

		AppUtils.STUDENTS.stream().forEachOrdered(System.out::println);
		System.out.println("------------------------------------------------------------");

		AppUtils.getStringStream("WORDS").forEachOrdered(System.out::println);
		System.out.println("------------------------------------------------------------");

		AppUtils.getIntStream("NUMBERS").forEachOrdered(System.out::println);
		System.out.println("------------------------------------------------------------");
	}

	public static void testGenerateWithLimit() {
		int limit = AppUtils.LIMIT;
		System.out.println("\n\n===================== testGenerateWithLimit() =====================");

		Stream<String> greetingsStream = Stream.generate(() -> "Hello");
		greetingsStream.limit(limit).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		Stream<Integer> randomNumbersStream = Stream.generate(() -> (int) (Math.random() * 100));

		randomNumbersStream.limit(limit).forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<LocalDateTime> currentDateTimeStream = Stream.generate(() -> LocalDateTime.now());

		currentDateTimeStream.limit(limit).forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<String> uuidStream = Stream.generate(() -> UUID.randomUUID().toString());

		uuidStream.limit(limit).forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<Candidate> candidateStream = Stream.generate(() -> new Candidate("Jack", "Science"));

		candidateStream.limit(limit).forEach(System.out::println);
		System.out.println("------------------------------------------------------------");
	}

	public static void testIterateWithLimit() {
		int limit = AppUtils.LIMIT;
		System.out.println("\n\n===================== testIterateWithLimit() =====================");
		Stream<Integer> numbersStream = Stream.iterate(1, n -> n + 1);

		numbersStream.limit(limit).forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<Integer> numbersDecrementStream = Stream.iterate(50, n -> n - 1);

		numbersDecrementStream.limit(limit).forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<Integer> evenNumbersStream = Stream.iterate(0, n -> n + 2);

		evenNumbersStream.limit(limit).forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<Integer> powerOfTwoStream = Stream.iterate(2, num -> (int) (Math.pow(num, 2)));

		powerOfTwoStream.limit(limit).forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<LocalDateTime> daysStream = Stream.iterate(LocalDateTime.now(), ldt -> ldt.plusDays(1));

		daysStream.limit(limit).forEach(System.out::println);
		System.out.println("------------------------------------------------------------");
	}

	public static void testMaps() {
		System.out.println("\n\n===================== testMaps() =====================");
		AppUtils.getStringStream("WORDS").map(String::toUpperCase).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.getIntStream("NUMBERS").map(num -> num * num).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.getStringStream("WORDS").map(word -> word + " has length = " + word.length())
				.forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.EMPLOYEES.stream().map(Employee::getName).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.EMPLOYEES.stream().map(emp -> emp.getSalary() + 1000d).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.getStringStream("NUMBERS_STRING").map(Integer::parseInt).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		DoubleStream salaryIncrementStream = AppUtils.EMPLOYEES.stream()
				.mapToDouble(emp -> emp.getSalary() + emp.getSalary() * 0.1d);

		salaryIncrementStream.forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		IntStream oddNumbersStream = AppUtils.getIntStream("ODD_NUMBERS").mapToInt(num -> num * 3);

		oddNumbersStream.forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		LongStream numbersLongStream = AppUtils.NUMBERS_L.stream().mapToLong(num -> num * 10l);

		numbersLongStream.forEach(System.out::println);

		System.out.println("------------------------------------------------------------");
	}

	public static void testMax() {
		System.out.println("\n\n===================== testMax() =====================");
		Optional<Integer> maximumNumber = AppUtils.getIntStream("NUMBERS").max(Comparator.naturalOrder());

		System.out.println(maximumNumber.orElse(0));
		System.out.println("------------------------------------------------------------");

		Optional<Integer> reverseMaximumNumber = AppUtils.getIntStream("NUMBERS").max(Comparator.reverseOrder());

		System.out.println(reverseMaximumNumber.orElse(0));
		System.out.println("------------------------------------------------------------");

		Optional<String> maximumName = AppUtils.getStringStream("NAMES").max(Comparator.naturalOrder());

		System.out.println(maximumName.orElse("NONE"));
		System.out.println("------------------------------------------------------------");

		Optional<String> maximumReverseName = AppUtils.getStringStream("NAMES").max(Comparator.reverseOrder());

		System.out.println(maximumReverseName.orElse("NONE"));
		System.out.println("------------------------------------------------------------");

		Optional<Employee> maximumSalaryEmployee = AppUtils.EMPLOYEES.stream()
				.max(Comparator.comparingDouble(Employee::getSalary));

		System.out.println(maximumSalaryEmployee.orElse(new Employee()));
		System.out.println("------------------------------------------------------------");

		Optional<String> maximumLengthWord = AppUtils.getStringStream("WORDS")
				.max(Comparator.comparing(String::length));

		System.out.println(maximumLengthWord.orElse(""));
		System.out.println("------------------------------------------------------------");
	}

	public static void testMin() {
		System.out.println("\n\n===================== testMin() =====================");
		Optional<Integer> minimumNumber = AppUtils.getIntStream("NUMBERS").min(Comparator.naturalOrder());

		System.out.println(minimumNumber.orElse(0));
		System.out.println("------------------------------------------------------------");

		Optional<Integer> reverseMinimumNumber = AppUtils.getIntStream("NUMBERS").min(Comparator.reverseOrder());

		System.out.println(reverseMinimumNumber.orElse(0));
		System.out.println("------------------------------------------------------------");

		Optional<String> minimumName = AppUtils.getStringStream("NAMES").min(Comparator.naturalOrder());

		System.out.println(minimumName.orElse("NONE"));
		System.out.println("------------------------------------------------------------");

		Optional<String> minimumReverseName = AppUtils.getStringStream("NAMES").min(Comparator.reverseOrder());

		System.out.println(minimumReverseName.orElse("NONE"));
		System.out.println("------------------------------------------------------------");

		Optional<Employee> minimumSalaryEmployee = AppUtils.EMPLOYEES.stream()
				.min(Comparator.comparingDouble(Employee::getSalary));

		System.out.println(minimumSalaryEmployee.orElse(new Employee()));
		System.out.println("------------------------------------------------------------");

		Optional<String> minimumLengthWord = AppUtils.getStringStream("WORDS")
				.min(Comparator.comparing(String::length));

		System.out.println(minimumLengthWord.orElse(""));
		System.out.println("------------------------------------------------------------");
	}

	public static void testNoneMatch() {
		System.out.println("\n\n===================== testNoneMatch() =====================");
		boolean allPositiveNumbers = AppUtils.getIntStream("NUMBERS").noneMatch(n -> n < 0);

		System.out.println("All numbers are positive? Ans: " + allPositiveNumbers);
		System.out.println("------------------------------------------------------------");

		boolean noNumberGreaterThanTen = AppUtils.getIntStream("NUMBERS").noneMatch(n -> n >= 10);

		System.out.println("All numbers are less than 10? Ans: " + noNumberGreaterThanTen);
		System.out.println("------------------------------------------------------------");

		boolean noWordIsEmpty = AppUtils.getStringStream("WORDS").noneMatch(String::isEmpty);

		System.out.println("There is no empty word? Ans: " + noWordIsEmpty);
		System.out.println("------------------------------------------------------------");

		boolean noEmployeeWithHigherSalary = AppUtils.EMPLOYEES.stream().noneMatch(e -> e.getSalary() >= 500000);

		System.out.println("There is no employee with salary >= 500000? Ans: " + noEmployeeWithHigherSalary);
		System.out.println("------------------------------------------------------------");

		boolean noNumberGreaterThanFive = AppUtils.getIntStream("NUMBERS").noneMatch(n -> {
			System.out.println("Checking: " + n);
			return n >= 5;
		});

		System.out.println("All numbers are less than 5? Ans: " + noNumberGreaterThanFive);
		System.out.println("------------------------------------------------------------");

		boolean allOddNumbers = AppUtils.getIntStream("EVEN_NUMBERS").noneMatch(n -> n % 2 == 0);
		System.out.println("All numbers are odd? Ans: " + allOddNumbers);
		System.out.println("------------------------------------------------------------");

		boolean allEvenNumbers = AppUtils.getIntStream("EVEN_NUMBERS").noneMatch(n -> n % 2 != 0);
		System.out.println("All numbers are even? Ans: " + allEvenNumbers);
		System.out.println("------------------------------------------------------------");
	}

	public static void testOf_VS_ArraysStream() {
		System.out.println("\n\n===================== testOf_VS_ArraysStream() =====================");
		Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5);
		numbersStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<String> namesStream = Stream.of("Adam", "Baby", "Celina", "Don", "Elizabeth");
		namesStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<String> alphabetsStream = Stream.of(AppUtils.ALPHABETS_ARRAY);
		alphabetsStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<String> alphabetsStream2 = Arrays.stream(AppUtils.ALPHABETS_ARRAY);
		alphabetsStream2.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<int[]> numbersArrayStream = Stream.of(AppUtils.NUMBERS_ARRAY);
		System.out.println("Number of elements = " + numbersArrayStream.count());

		Stream<int[]> numbersArrayStream2 = Stream.of(AppUtils.NUMBERS_ARRAY);
		numbersArrayStream2.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		IntStream numbersArrayStream3 = Arrays.stream(AppUtils.NUMBERS_ARRAY);
		System.out.println("Number of elements = " + numbersArrayStream3.count());

		IntStream numbersArrayStream4 = Arrays.stream(AppUtils.NUMBERS_ARRAY);
		numbersArrayStream4.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<Student> studentStream = Stream.of(new Student("Ali", 10), new Student("Baby", 9),
				new Student("Celina", 20));

		studentStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream.of(AppUtils.LIMIT).forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		LongStream numbersLArrayStream = Arrays.stream(AppUtils.NUMBERS_ARRAY_L);
		numbersLArrayStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		DoubleStream numbersDArrayStream = Arrays.stream(AppUtils.NUMBERS_ARRAY_D);
		numbersDArrayStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");
	}

	public static void testPeek() {
		System.out.println("\n\n===================== testPeek() =====================");
		AppUtils.getStringStream("NAMES").peek(s -> System.out.println("Before Filter, name: " + s))
				.filter(s -> s.length() >= 5).map(String::toUpperCase)
				.forEach(s -> System.out.println("After filtering and mapping, name of 5 or more characters: " + s));

		System.out.println("------------------------------------------------------------");

		AppUtils.getIntStream("NUMBERS").peek(n -> System.out.println("Before filter, number = " + n))
				.filter(n -> n % 2 == 0).forEach(n -> System.out.println("After filter, even number = " + n));

		System.out.println("------------------------------------------------------------");

		AppUtils.EMPLOYEES.stream().peek(
				emp -> System.out.println("Before Mapping, " + emp.getName() + " has salary = " + emp.getSalary()))
				.map(emp -> {
					emp.setSalary(emp.getSalary() + 1000d);
					return emp;
				}).forEach(emp -> System.out.println("After Mapping (Increment = INR 1000/-), " + emp.getName()
						+ " has salary = " + emp.getSalary() + "\n"));
	}

	public static void testReduce_V1() {
		System.out.println("\n\n===================== testReduce_V1() =====================");
		OptionalInt sumOpt = Arrays.stream(AppUtils.NUMBERS_ARRAY).reduce((num1, num2) -> num1 + num2);

		sumOpt.ifPresent(sum -> System.out.println("Sum of numbers = " + sum));

		System.out.println("------------------------------------------------------------");

		OptionalInt productOpt = Arrays.stream(AppUtils.NUMBERS_ARRAY).reduce((num1, num2) -> num1 * num2);

		productOpt.ifPresent(product -> System.out.println("Product of numbers = " + product));

		System.out.println("------------------------------------------------------------");

		Optional<Integer> minOpt = AppUtils.getIntStream("NUMBERS").reduce((num1, num2) -> num1 < num2 ? num1 : num2);

		minOpt.ifPresent(min -> System.out.println("Minimum number = " + min));

		System.out.println("------------------------------------------------------------");

		Optional<Integer> maxOpt = AppUtils.getIntStream("NUMBERS").reduce((num1, num2) -> num1 > num2 ? num1 : num2);

		maxOpt.ifPresent(max -> System.out.println("Maximum number = " + max));

		System.out.println("------------------------------------------------------------");

		Optional<String> concatenatedOpt = Arrays.stream(AppUtils.ALPHABETS_ARRAY).reduce((s1, s2) -> s1 + s2);
		concatenatedOpt.ifPresent(s -> System.out.println("Concatenated Output = " + s));

		System.out.println("------------------------------------------------------------");
	}

	public static void testReduce_V2() {
		System.out.println("\n\n===================== testReduce_V2() =====================");
		int sum = Arrays.stream(AppUtils.NUMBERS_ARRAY).reduce(10, (num1, num2) -> num1 + num2);

		System.out.println("Sum of numbers = " + sum);

		System.out.println("------------------------------------------------------------");

		int product = Arrays.stream(AppUtils.NUMBERS_ARRAY).reduce(100, (num1, num2) -> num1 * num2);

		System.out.println("Product of numbers = " + product);

		System.out.println("------------------------------------------------------------");

		int min = AppUtils.getIntStream("NUMBERS").reduce(1, (num1, num2) -> num1 < num2 ? num1 : num2);

		System.out.println("Minimum number = " + min);

		System.out.println("------------------------------------------------------------");

		int max = AppUtils.getIntStream("NUMBERS").reduce(500, (num1, num2) -> num1 > num2 ? num1 : num2);

		System.out.println("Maximum number = " + max);

		System.out.println("------------------------------------------------------------");

		String concatenatedOutput = Arrays.stream(AppUtils.ALPHABETS_ARRAY).reduce("ACRONYM -> ", (s1, s2) -> s1 + s2);
		System.out.println("Concatenated Output = " + concatenatedOutput);

		System.out.println("------------------------------------------------------------");
	}

	public static void testReduce_V3() {
		System.out.println("\n\n===================== testReduce_V3() =====================");
		Double sum = AppUtils.getIntStream("ODD_NUMBERS").reduce(0.0, (subtotal, element) -> subtotal + element,
				(a, b) -> a + b);

		System.out.println("Sum = " + sum);
		System.out.println("------------------------------------------------------------");

		String concatenated = AppUtils.getStringStream("NAMES").reduce("", (partial, name) -> partial + name + " ",
				(s1, s2) -> s1 + s2);

		System.out.println("Concatenated names: " + concatenated);
		System.out.println("------------------------------------------------------------");

		Integer sumOfSquares = AppUtils.getIntStream("EVEN_NUMBERS").reduce(0,
				(subtotal, element) -> subtotal + element * element, (a, b) -> a + b);

		System.out.println("Sum of squares = " + sumOfSquares);
		System.out.println("------------------------------------------------------------");

		String namesOfAllEmployees = AppUtils.EMPLOYEES.stream().reduce("",
				(partial, person) -> partial + person.getName() + " ", (s1, s2) -> s1 + s2);

		System.out.println("Names of all Employees: " + namesOfAllEmployees);
		System.out.println("------------------------------------------------------------");
	}

	public static void testSkip_Limit() {
		System.out.println("\n\n===================== testSkip_Limit() =====================");

		AppUtils.getIntStream("NUMBERS").skip(5).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.getStringStream("WORDS").skip(3).limit(2).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.EMPLOYEES.stream().skip(5).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");
	}

	public static void testSorted_V1() {
		System.out.println("\n\n===================== testSorted_V1() =====================");

		AppUtils.getIntStream("DUPLICATE_NUMBERS").sorted().forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.getStringStream("WORDS").sorted().forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.EMPLOYEES.stream().map(Employee::getName).sorted().forEach(System.out::println);

		System.out.println("------------------------------------------------------------");
	}

	public static void testSorted_V2() {
		System.out.println("\n\n===================== testSorted_V2() =====================");

		AppUtils.getIntStream("DUPLICATE_NUMBERS").sorted(Comparator.reverseOrder()).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.getStringStream("WORDS").sorted(Comparator.reverseOrder()).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.EMPLOYEES.stream().map(Employee::getName).sorted(Comparator.reverseOrder())
				.forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.getStringStream("WORDS").sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);

		System.out.println("------------------------------------------------------------");

		AppUtils.EMPLOYEES.stream().sorted(Comparator.comparingDouble(Employee::getSalary))
				.forEach(e -> System.out.println(e.getName() + " | Salary = " + e.getSalary()));

		System.out.println("------------------------------------------------------------");

		AppUtils.EMPLOYEES.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.forEach(e -> System.out.println(e.getName() + " | Salary = " + e.getSalary()));

		System.out.println("------------------------------------------------------------");

		AppUtils.EMPLOYEES.stream().sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getName))
				.forEach(e -> System.out.println("Age = " + e.getAge() + " | Name: " + e.getName()));

		System.out.println("------------------------------------------------------------");

	}

	public static void testToArray_V1() {
		System.out.println("\n\n===================== testToArray_V1() =====================");
		Object[] numbersArray = AppUtils.getIntStream("NUMBERS").toArray();
		for (Object num : numbersArray) {
			System.out.println(num);
		}

		System.out.println("------------------------------------------------------------");

		Object[] namesArray = AppUtils.getStringStream("NAMES").toArray();
		for (Object name : namesArray) {
			System.out.println(name);
		}

		System.out.println("------------------------------------------------------------");

		Object[] employeesArray = AppUtils.EMPLOYEES.stream().toArray();
		for (Object employee : employeesArray) {
			System.out.println(employee);
		}

		System.out.println("------------------------------------------------------------");

		Object[] studentsArray = AppUtils.STUDENTS.stream().toArray();
		for (Object student : studentsArray) {
			System.out.println(student);
		}

		System.out.println("------------------------------------------------------------");
	}

	public static void testToArray_V2() {
		System.out.println("\n\n===================== testToArray_V2() =====================");
		Integer[] numbersArray = AppUtils.getIntStream("NUMBERS").toArray(Integer[]::new);
		for (Integer num : numbersArray) {
			System.out.println(num);
		}

		System.out.println("------------------------------------------------------------");

		String[] namesArray = AppUtils.getStringStream("NAMES").toArray(String[]::new);
		for (String name : namesArray) {
			System.out.println(name);
		}

		System.out.println("------------------------------------------------------------");

		Employee[] employeesArray = AppUtils.EMPLOYEES.stream().toArray(Employee[]::new);
		for (Employee employee : employeesArray) {
			System.out.println(employee);
		}

		System.out.println("------------------------------------------------------------");

		Student[] studentsArray = AppUtils.STUDENTS.stream().toArray(Student[]::new);
		for (Student student : studentsArray) {
			System.out.println(student);
		}

		System.out.println("------------------------------------------------------------");

		Student[] sortedStudentsArray = AppUtils.STUDENTS.stream().filter(s -> s.getAge() > 20)
				.sorted(Comparator.comparing(Student::getName)).toArray(Student[]::new);

		for (Student student : sortedStudentsArray) {
			System.out.println(student);
		}

		System.out.println("------------------------------------------------------------");
	}

	public static void main(String[] args) {
		createStream();
		testAllMatch();
		testAnyMatch();
		testCollect_V1();
		testCollect_V2();
		testConcat();
		testCount();
		testDistinct();
		testEmpty();
		testFilter();
		testFindAny();
		testFindFirst();
		testFlatMap();
		testFlatMapToDouble();
		testFlatMapToInt();
		testFlatMapToLong();
		testForEach();
		testForEachOrdered();
		testGenerateWithLimit();
		testIterateWithLimit();
		testMaps();
		testMax();
		testMin();
		testNoneMatch();
		testOf_VS_ArraysStream();
		testPeek();
		testReduce_V1();
		testReduce_V2();
		testReduce_V3();
		testSkip_Limit();
		testSorted_V1();
		testSorted_V2();
		testToArray_V1();
		testToArray_V2();
	}
}