package com.learning.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.learning.model.Employee;
import com.learning.model.EmployeeDto;
import com.learning.model.Student;
import com.learning.model.StudentDto;

public class CollectorsDemo {

	private static List<Employee> employees = EmployeeDto.findEmployees();

	static void printEmployeesByDepartment() {
		Map<String, List<Employee>> byDept = employees.stream().collect(Collectors.groupingBy(Employee::getDept));

		System.out.println(byDept);
	}

	/**
	 * This collector converts each element to a double and computes the arithmetic
	 * mean (average). Finally it returns a Double.
	 */
	static void testAveragingDouble() {
		System.out.println("=======================================================");
		List<Integer> numbers = List.of(1, 2, 3);
		System.out.println("Numbers = " + numbers);
		Double average = numbers.stream().collect(Collectors.averagingDouble(n -> n));
		System.out.println("Average = " + average);
		System.out.println("=======================================================");

		List<Double> salaries = employees.stream().map(e -> e.getSalary()).collect(Collectors.toList());
		System.out.println("Salaries of employees = " + salaries);
		Double averageSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("\nAverage Salary = " + averageSalary);
		System.out.println("=======================================================");

		List<Student> students = StudentDto.findStudents();
		List<Integer> ages = students.stream().map(s -> s.getAge()).collect(Collectors.toList());
		System.out.println("Ages of students = " + ages);
		Double averageAge = students.stream().collect(Collectors.averagingDouble(Student::getAge));
		System.out.println("Average Age = " + averageAge);
		System.out.println("=======================================================");

		List<Integer> prices = List.of(100, 200, 300);
		System.out.println("Prices = " + prices);
		Double averagePrice = prices.stream().collect(Collectors.averagingDouble(p -> p));
		System.out.println("Average Price = " + averagePrice);

		Double averagePriceWithTax = prices.stream().collect(Collectors.averagingDouble(p -> p + 0.18 * p));
		System.out.println("Average Price with 18% GST = " + averagePriceWithTax);
		System.out.println("=======================================================");
	}

	public static void main(String[] args) {
		printEmployeesByDepartment();
		testAveragingDouble();

	}

}
