package com.learning.streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.learning.model.Animal;
import com.learning.model.AppUtils;
import com.learning.model.Cat;
import com.learning.model.Dog;

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
		List<Integer> numbers1 = AppUtils.ODD_NUMBERS;
		List<Integer> numbers2 = AppUtils.EVEN_NUMBERS;
		List<String> NAMES = AppUtils.NAMES;

		Stream<Integer> numbersStream = numbers1.stream();
		boolean allOdd = numbersStream.allMatch(i -> i % 2 != 0);

		System.out.println("Numbers1 = " + numbers1);
		System.out.println("Are all NUMBERS Odd? ANS: " + allOdd);
		System.out.println("------------------------------------------------------------");

		Stream<Integer> numbersStream2 = numbers2.stream();
		boolean allEven = numbersStream2.allMatch(i -> i % 2 == 0);

		System.out.println("Numbers2 = " + numbers2);
		System.out.println("Are all NUMBERS Even? ANS: " + allEven);
		System.out.println("------------------------------------------------------------");

		Stream<String> namesStream = NAMES.stream();
		boolean allNamesStartWithA = namesStream.allMatch(s -> s.startsWith("A"));

		System.out.println("Names = " + NAMES);
		System.out.println("Do all NAMES start with A? ANS: " + allNamesStartWithA);
		System.out.println("------------------------------------------------------------");
	}

	public static void testAnyMatch() {
		System.out.println("\n\n===================== testAnyMatch() =====================");
		List<Integer> numbers1 = AppUtils.NUMBERS;
		List<Integer> numbers2 = AppUtils.EVEN_NUMBERS;
		List<String> NAMES = AppUtils.NAMES;

		Stream<Integer> numbersStream = numbers1.stream();
		boolean anyEven = numbersStream.anyMatch(i -> i % 2 == 0);

		System.out.println("Numbers1 = " + numbers1);
		System.out.println("Is there any even number? ANS: " + anyEven);
		System.out.println("------------------------------------------------------------");

		Stream<Integer> numbersStream2 = numbers2.stream();
		boolean anyOdd = numbersStream2.anyMatch(i -> i % 2 != 0);
		System.out.println("Numbers2 = " + numbers2);
		System.out.println("Is there any odd number? ANS: " + anyOdd);
		System.out.println("------------------------------------------------------------");

		Stream<String> namesStream = NAMES.stream();
		boolean anyNameStartsWithA = namesStream.anyMatch(s -> s.startsWith("A"));

		System.out.println("Names = " + NAMES);
		System.out.println("Is there any name starting with A? ANS: " + anyNameStartsWithA);
		System.out.println("------------------------------------------------------------");
	}

	public static void testCollect_V1() {
		System.out.println("\n\n===================== testCollect_V1() =====================");
		List<Integer> NUMBERS = AppUtils.NUMBERS;
		List<Integer> EVEN_NUMBERS = NUMBERS.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Numbers: " + NUMBERS);
		System.out.println("Even NUMBERS: " + EVEN_NUMBERS);
		System.out.println("------------------------------------------------------------");

		List<Integer> numbers2 = AppUtils.DUPLICATE_NUMBERS;
		Set<Integer> uniqueNumbers = numbers2.stream().collect(Collectors.toSet());
		System.out.println("Numbers: " + numbers2);
		System.out.println("unique NUMBERS: " + uniqueNumbers);
		System.out.println("------------------------------------------------------------");
	}

	public static void testCollect_V2() {
		System.out.println("\n\n===================== testCollect_V2() =====================");
		List<String> words = AppUtils.WORDS.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

		System.out.println("words: " + words);
		System.out.println("------------------------------------------------------------");

		Set<Integer> numbers = AppUtils.DUPLICATE_NUMBERS.stream().collect(HashSet::new, HashSet::add, HashSet::addAll);

		System.out.println("numbers: " + numbers);
		System.out.println("------------------------------------------------------------");

		StringBuilder nameBuilder = AppUtils.NAMES.stream().collect(StringBuilder::new, StringBuilder::append,
				StringBuilder::append);

		System.out.println("nameBuilder: " + nameBuilder);
		System.out.println("------------------------------------------------------------");

		BiConsumer<ArrayList<Integer>, Integer> accumulator = (list, num) -> {
			if (num % 2 == 0) {
				list.add(num);
			}
		};

		List<Integer> evenNumbers = AppUtils.NUMBERS.stream().collect(ArrayList::new, accumulator, ArrayList::addAll);

		System.out.println("evenNumbers: " + evenNumbers);
		System.out.println("------------------------------------------------------------");
	}

	public static void testConcat() {
		System.out.println("\n\n===================== testConcat() =====================");
		Stream<String> wordsStream = AppUtils.WORDS.stream();
		Stream<String> namesStream = AppUtils.NAMES.stream();

		Stream<String> concatedStream = Stream.concat(wordsStream, namesStream);
		concatedStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<Dog> dogs = Stream.of(new Dog("Buddy"), new Dog("Rocky"));
		Stream<Cat> cats = Stream.of(new Cat("Kitty"), new Cat("Mimi"));
		Stream<Animal> animals = Stream.concat(dogs, cats);
		animals.forEach(a -> System.out.println(a.getName()));
		System.out.println("------------------------------------------------------------");

		Stream<Integer> oddNumbersStream = AppUtils.ODD_NUMBERS.stream();
		Stream<Integer> evenNumbersStream = AppUtils.EVEN_NUMBERS.stream();

		Stream<Integer> oddEvenconcatedStream = Stream.concat(oddNumbersStream, evenNumbersStream);

		oddEvenconcatedStream.forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Stream<Integer> parallelStream = AppUtils.NUMBERS.stream().parallel();
		Stream<Integer> normalStream = AppUtils.DUPLICATE_NUMBERS.stream();

		Stream<Integer> resultantStream = Stream.concat(parallelStream, normalStream);

		System.out.println(resultantStream.isParallel()
				? "A parallel stream concated with normal stream and the result stream is parallel stream."
				: "The result stream is not Parallel Stream.");

		System.out.println("------------------------------------------------------------");
	}

	public static void main(String[] args) {
		createStream();
		testAllMatch();
		testAnyMatch();
		testCollect_V1();
		testCollect_V2();
		testConcat();
	}

}
