package com.learning.functionalInterfaces.consumers;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import com.learning.utils.AppUtils;

public class ConsumerDemo {

	static Consumer<String> loggerConsumer = s -> System.out.println("\n[INFO] " + s);

	static Consumer<String> printConsumer = s -> System.out.println(s);

	static DoubleConsumer printRupeesInDollarConsumer = r -> System.out
			.println("INR " + r + " = USD " + (r * 0.01113d));

	static DoubleConsumer printDollarInRupeesConsumer = r -> System.out
			.println("USD " + r + " = INR " + (r / 0.01113d));

	static LongConsumer printRupeesInPaisaConsumer = r -> System.out.println("INR " + r + " = " + (r * 100) + " paisa");

	static IntConsumer printDollarInCentsConsumer = r -> System.out.println("USD " + r + " = " + (r * 100) + " cents");

	public static void printMessage(String message) {
		loggerConsumer.accept("Inside printMessage:");
		printConsumer.accept(message);
	}

	public static void printItems() {
		loggerConsumer.accept("Consumer used to print List items:");
		List<String> words = AppUtils.WORDS;
		words.forEach(printConsumer);

	}

	public static void useInStream() {
		loggerConsumer.accept("Consumer used in Stream:");
		List<String> words = AppUtils.WORDS;
		words.stream().filter(s -> s.length() < 6).forEach(printConsumer);
	}

	public static void convertCurrency() {
		loggerConsumer.accept("Currency Conversion:");
		double rupees = 1000d;
		printRupeesInDollarConsumer.accept(rupees);

		double dollar = 1d;
		printDollarInRupeesConsumer.accept(dollar);

		long rupeesL = 1l;
		printRupeesInPaisaConsumer.accept(rupeesL);

		int dollarI = 1;
		printDollarInCentsConsumer.accept(dollarI);
	}

	public static void main(String[] args) {
		printMessage("Hi");
		printItems();
		useInStream();
		convertCurrency();
	}

}
