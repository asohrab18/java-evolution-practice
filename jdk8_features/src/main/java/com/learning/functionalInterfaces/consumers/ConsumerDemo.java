package com.learning.functionalInterfaces.consumers;

import java.util.function.Consumer;

public class ConsumerDemo {

	static Consumer<String> smsConsumer = s -> {
		if (s == null || s.isEmpty() || s.isBlank()) {
			System.out.println("Message not found.");
		} else {
			System.out.println("Message sent successfully as: " + s);
		}
	};

	public static void sendMessage(String message) {
		smsConsumer.accept(message);
	}

	public static void main(String[] args) {
		String message = "Hello World!";
		sendMessage(message);
	}

}
