package com.learning.functionalInterfaces.suppliers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import com.learning.model.Employee;

public class SupplierDemo {
	static Supplier<String> loggerSupplier = () -> "\n======================= New method starts ======================";
	static Supplier<String> greetingSupplier = () -> "Hello World!";
	static Supplier<Employee> employeeSupplier = () -> new Employee(123, "Marry", "HR", 123456d, true);
	static Supplier<LocalDateTime> dateTimeSupplier = () -> LocalDateTime.now();
	static Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);
	static Supplier<List<String>> plansStatusSupplier = () -> List.of("ACTIVE", "INACTIVE", "EXPIRED", "PREPAID", "POSTPAID");

	static BooleanSupplier activeSupplier = () -> true;
	static DoubleSupplier temperatureSupplier = () -> 34.9d;
	static IntSupplier countryCodeSupplier = () -> 91;
	static LongSupplier contactSupplier = () -> 9897123456l;

	public static void useSuppliers() {
		System.out.println(loggerSupplier.get());
		String msg = greetingSupplier.get();
		System.out.println("Greeting: " + msg + "\n");

		Employee employee = employeeSupplier.get();
		System.out.println("Employee: " + employee);

		LocalDateTime now = dateTimeSupplier.get();
		System.out.println("Current DateTime: " + now + "\n");

		int randomNumber = randomNumberSupplier.get();
		System.out.println("Random Number: " + randomNumber + "\n");

		List<String> plansStatus = plansStatusSupplier.get();
		System.out.println("Plans Status: " + plansStatus + "\n");

		System.out.println(activeSupplier.getAsBoolean());
		System.out.println(temperatureSupplier.getAsDouble());
		System.out.println(countryCodeSupplier.getAsInt());
		System.out.println(contactSupplier.getAsLong() + "\n");
	}

	public static void useSupplierWithOptional(String input) {
		System.out.println(loggerSupplier.get());
		System.out.println("input: " + input);
		Optional<String> inputOpt = Optional.ofNullable(input);

		Supplier<String> defaultSupplier = () -> "Default Value";

		String output = inputOpt.orElseGet(defaultSupplier);

		System.out.println("output: " + output);
	}

	public static void main(String[] args) {
		useSuppliers();
		useSupplierWithOptional("ABCD");
	}
}
