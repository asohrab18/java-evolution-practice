package com.learning.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		Stream<String> stream = useStreamBuilder("V");
		stream.forEach(System.out::println);
		System.out.println("=========================================");

		Stream<String> statusStream = Stream.of("ACTIVE");
		statusStream.forEach(System.out::println);
		System.out.println("=========================================");

		Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5);
		numbersStream.forEach(System.out::println);
		System.out.println("=========================================");
	}

	public static void testAllMatch() {
		List<Integer> numbers1 = List.of(1, 3, 5, 7, 9);
		List<Integer> numbers2 = List.of(2, 4, 6, 8, 9);
		List<String> names = List.of("Adam", "Angelina", "Andrew");

		Stream<Integer> numbersStream = numbers1.stream();
		boolean allOdd = numbersStream.allMatch(i -> i % 2 != 0);

		System.out.println("Numbers1 = " + numbers1);
		System.out.println("Are all numbers Odd? ANS: " + allOdd);
		System.out.println("=========================================");

		Stream<Integer> numbersStream2 = numbers2.stream();
		boolean allEven = numbersStream2.allMatch(i -> i % 2 == 0);

		System.out.println("Numbers2 = " + numbers2);
		System.out.println("Are all numbers Even? ANS: " + allEven);
		System.out.println("=========================================");

		Stream<String> namesStream = names.stream();
		boolean allNamesStartWithA = namesStream.allMatch(s -> s.startsWith("A"));

		System.out.println("Names = " + names);
		System.out.println("Do all names start with A? ANS: " + allNamesStartWithA);
		System.out.println("=========================================");
	}

	public static void testAnyMatch() {
		List<Integer> numbers1 = List.of(1, 3, 5, 7, 9, 10);
		List<Integer> numbers2 = List.of(2, 4, 6, 8, 10, 12);
		List<String> names = List.of("Boby", "Denis", "Andrew");

		Stream<Integer> numbersStream = numbers1.stream();
		boolean anyEven = numbersStream.anyMatch(i -> i % 2 == 0);

		System.out.println("Numbers1 = " + numbers1);
		System.out.println("Is there any even number? ANS: " + anyEven);
		System.out.println("=========================================");

		Stream<Integer> numbersStream2 = numbers2.stream();
		boolean anyOdd = numbersStream2.anyMatch(i -> i % 2 != 0);
		System.out.println("Numbers2 = " + numbers2);
		System.out.println("Is there any odd number? ANS: " + anyOdd);
		System.out.println("=========================================");

		Stream<String> namesStream = names.stream();
		boolean anyNameStartsWithA = namesStream.anyMatch(s -> s.startsWith("A"));

		System.out.println("Names = " + names);
		System.out.println("Is there any name starting with A? ANS: " + anyNameStartsWithA);
		System.out.println("=========================================");
	}

	public static void testCollect() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Numbers: " + numbers);
		System.out.println("Even numbers: " + evenNumbers);
		System.out.println("=========================================");

		List<Integer> numbers2 = List.of(1, 2, 3, 1, 2, 3, 1, 2, 3);
		Set<Integer> uniqueNumbers = numbers2.stream().collect(Collectors.toSet());
		System.out.println("Numbers: " + numbers2);
		System.out.println("unique numbers: " + uniqueNumbers);
		System.out.println("=========================================");
	}

	public static void main(String[] args) {
		createStream();
		testAllMatch();
		testAnyMatch();
		testCollect();
	}

}
