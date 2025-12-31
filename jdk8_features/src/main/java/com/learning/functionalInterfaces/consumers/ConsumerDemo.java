package com.learning.functionalInterfaces.consumers;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	static Consumer<String> loggerConsumer = s -> System.out.println("\n[INFO] " + s);

	static Consumer<String> printConsumer = s -> System.out.println(s);

	public static void printMessage(String message) {
		loggerConsumer.accept("Inside printMessage:");
		printConsumer.accept(message);
	}

	public static void printItems() {
		loggerConsumer.accept("Consumer used to print List items:");
		List<String> fruits = List.of("Apple", "Banana", "Coconut", "Guava");
		fruits.forEach(printConsumer);

	}

	public static void useInStream() {
		loggerConsumer.accept("Consumer used in Stream:");
		List<String> fruits = List.of("Apple", "Banana", "Coconut", "Guava");
		fruits.stream().filter(s -> s.length() < 6).forEach(printConsumer);
	}

	public static void main(String[] args) {
		printMessage("Hi");
		printItems();
		useInStream();
	}

}
