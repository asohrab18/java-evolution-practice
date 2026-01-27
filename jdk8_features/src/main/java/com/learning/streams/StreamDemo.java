package com.learning.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.learning.model.Animal;
import com.learning.model.AppUtils;
import com.learning.model.Cat;
import com.learning.model.Dog;
import com.learning.model.Order;

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
		List<String> words = AppUtils.getStringStream("WORDS").collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

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
	}

}
