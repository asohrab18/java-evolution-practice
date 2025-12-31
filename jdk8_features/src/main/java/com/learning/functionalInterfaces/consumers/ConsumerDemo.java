package com.learning.functionalInterfaces.consumers;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	static Consumer<String> printConsumer = s -> System.out.println(s);

	public static void printMessage(String message) {
		printConsumer.accept(message);
	}

	public static void printItems() {
		System.out.println("\nConsumer used to print List items:");
		List<String> fruits = List.of("Apple", "Banana", "Coconut", "Guava");
		fruits.forEach(printConsumer);

	}

	public static void useInStream() {
		System.out.println("\nConsumer used in Stream:");
		List<String> fruits = List.of("Apple", "Banana", "Coconut", "Guava");
		fruits.stream().filter(s -> s.length() < 6).forEach(printConsumer);
	}

	public static void main(String[] args) {
		printMessage("Hi");
		printItems();
		useInStream();
	}

}
