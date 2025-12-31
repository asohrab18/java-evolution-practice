package com.learning.functionalInterfaces.consumers;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	static Consumer<String> printConsumer = s -> System.out.println(s);

	public static void printMessage(String message) {
		printConsumer.accept(message);
	}

	public static void printItems() {
		List<String> fruits = List.of("Apple", "Banana", "Coconut", "Guava");
		fruits.forEach(printConsumer);

	}

	public static void main(String[] args) {
		printMessage("Hello World!");
		printItems();
	}

}
