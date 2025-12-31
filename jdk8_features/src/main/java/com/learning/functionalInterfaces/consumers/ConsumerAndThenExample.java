package com.learning.functionalInterfaces.consumers;

import java.util.List;
import java.util.function.Consumer;

import com.learning.model.Employee;
import com.learning.model.EmployeeDto;

public class ConsumerAndThenExample {

	static Consumer<String> printStringConsumer = s -> System.out.println("String Input:" + s);

	static Consumer<String> printStringLengthConsumer = s -> {
		if (s == null) {
			System.out.println("Length of String = " + 0);
		} else {
			System.out.println("Length of String = " + s.length());
		}
	};

	static Consumer<Employee> printEmployeeConsumer = e -> System.out.println("Name:" + e.getName() + "\tSalary:" + e.getSalary());

	static Consumer<Employee> hike5000SalaryConsumer = e -> e.setSalary(e.getSalary() + 5000d);

	public static void printStringAndItsLength(String input) {
		printStringConsumer.andThen(printStringLengthConsumer).accept(input);
	}

	public static void increaseSalaryAndPrintEmployees() {
		System.out.println("Before Hike:");
		List<Employee> employees = EmployeeDto.findEmployees();
		employees.forEach(printEmployeeConsumer);

		System.out.println("\n====================================\nAfter Hike of INR 5000/-");
		System.out.println("====================================");

		Consumer<Employee> hikeAndPrintConsumer = hike5000SalaryConsumer.andThen(printEmployeeConsumer);
		employees.forEach(hikeAndPrintConsumer);
	}

	public static void main(String[] args) {
		increaseSalaryAndPrintEmployees();
	}

}
