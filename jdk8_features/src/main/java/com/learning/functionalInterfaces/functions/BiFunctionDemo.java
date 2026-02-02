package com.learning.functionalInterfaces.functions;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;
import com.learning.model.Employee;
import com.learning.model.dto.EmployeeDto;

public class BiFunctionDemo {

	static BiFunction<Employee, Integer, Double> salaryFunction = (emp, id) -> {
		double salary = 0d;
		if (emp == null || id <= 0) {
			return salary;
		}
		if (emp.getId() == id) {
			salary = emp.getSalary();
		}
		return salary;
	};

	static ToDoubleBiFunction<Integer, String> marksFunction = (id, name) -> {
		double marks = 0d;
		if (id <= 0 || name == null || name.isBlank() || name.isEmpty()) {
			return marks;
		}

		name = name.trim();

		if (id == 1 && name.equalsIgnoreCase("ADAM")) {
			marks = 78.5d;
		} else if (id == 2 && name.equalsIgnoreCase("CELINA")) {
			marks = 80.25d;
		} else if (id == 3 && name.equalsIgnoreCase("DENIS")) {
			marks = 90.85d;
		}
		return marks;
	};

	static ToIntBiFunction<String, String> stringLengthFunction = (s1, s2) -> {
		if (s1 == null) {
			s1 = "";
		}
		if (s2 == null) {
			s2 = "";
		}
		s1 = s1.trim();
		s2 = s2.trim();
		return s1.concat(s2).length();
	};

	static ToLongBiFunction<Integer, Integer> squareBiFunction = (num1, num2) -> (long) num1 * num2;

	public static void testBiFunctions() {
		List<Employee> employees = EmployeeDto.findEmployees();

		int empId = 10;
		employees.stream().forEach(emp -> {
			double salary = salaryFunction.apply(emp, empId);
			if (salary > 0d) {
				System.out.println("Employee Id = " + empId + " Salary = " + salary + "\n");
			}
		});

		int id = 1;
		String name = "Adam";
		double marks = marksFunction.applyAsDouble(id, name);
		System.out.println("Candiate Id = " + id + "\nName: " + name + "\nMarks = " + marks + "\n");

		int length = stringLengthFunction.applyAsInt(name, name);
		System.out.println("String1: " + name + "\nString2: " + name + "\nLength = " + length + "\n");

		int num1 = 1234567891, num2 = 312345678;
		long square = squareBiFunction.applyAsLong(num1, num2);
		System.out.println("Number1 = " + num1 + "\nNumber2 = " + num2 + "\nSquare = " + square + "\n");
	}

	public static void main(String[] args) {
		testBiFunctions();
	}
}
