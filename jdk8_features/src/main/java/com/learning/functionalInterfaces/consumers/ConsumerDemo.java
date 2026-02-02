package com.learning.functionalInterfaces.consumers;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import com.learning.utils.AppConstants;
import com.learning.utils.AppUtils;

public class ConsumerDemo {

	static Consumer<String> loggerConsumer = s -> System.out.println("\n[INFO] " + s);

	static Consumer<String> printConsumer = s -> System.out.println(s);

	static DoubleConsumer printRupeesInDollarConsumer = r -> System.out
			.println("INR " + r + " = USD " + (r * AppConstants.DOUBLE_DOT_01113));

	static DoubleConsumer printDollarInRupeesConsumer = r -> System.out
			.println("USD " + r + " = INR " + (r / AppConstants.DOUBLE_DOT_01113));

	static LongConsumer printRupeesInPaisaConsumer = r -> System.out.println("INR " + r + " = " + (r * AppConstants.HUNDRED) + " paisa");

	static IntConsumer printDollarInCentsConsumer = r -> System.out.println("USD " + r + " = " + (r * AppConstants.HUNDRED) + " cents");

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
		words.stream().filter(s -> s.length() < AppConstants.SIX).forEach(printConsumer);
	}

	public static void convertCurrency() {
		loggerConsumer.accept("Currency Conversion:");
		double rupees = AppConstants.DOUBLE_1000;
		printRupeesInDollarConsumer.accept(rupees);

		double dollar = AppConstants.DOUBLE_1;
		printDollarInRupeesConsumer.accept(dollar);

		long rupeesL = AppConstants.LONG_1;
		printRupeesInPaisaConsumer.accept(rupeesL);

		int dollarI = AppConstants.ONE;
		printDollarInCentsConsumer.accept(dollarI);
	}

	public static void main(String[] args) {
		printMessage("Hi");
		printItems();
		useInStream();
		convertCurrency();
	}
}
