package com.learning.functionalInterfaces.functions;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;
import com.learning.model.Employee;
import com.learning.model.dto.EmployeeDto;
import com.learning.utils.AppConstants;

public class BiFunctionDemo {

	static BiFunction<Employee, Integer, Double> salaryFunction = (emp, id) -> {
		double salary = AppConstants.DOUBLE_0;
		if (emp == null || id <= AppConstants.ZERO) {
			return salary;
		}
		if (emp.getId() == id) {
			salary = emp.getSalary();
		}
		return salary;
	};

	static ToDoubleBiFunction<Integer, String> marksFunction = (id, name) -> {
		double marks = AppConstants.DOUBLE_0;
		if (id <= AppConstants.ZERO || name == null || name.isBlank() || name.isEmpty()) {
			return marks;
		}

		name = name.trim();

		if (id == AppConstants.ONE && name.equalsIgnoreCase(AppConstants.ADAM)) {
			marks = AppConstants.DOUBLE_78_DOT_5;
		} else if (id == AppConstants.TWO && name.equalsIgnoreCase(AppConstants.CELINA)) {
			marks = AppConstants.DOUBLE_80_DOT_25;
		} else if (id == AppConstants.THREE && name.equalsIgnoreCase(AppConstants.DENIS)) {
			marks = AppConstants.DOUBLE_90_DOT_85;
		}
		return marks;
	};

	static ToIntBiFunction<String, String> stringLengthFunction = (s1, s2) -> {
		if (s1 == null) {
			s1 = AppConstants.EMPTY;
		}
		if (s2 == null) {
			s2 = AppConstants.EMPTY;
		}
		s1 = s1.trim();
		s2 = s2.trim();
		return s1.concat(s2).length();
	};

	static ToLongBiFunction<Integer, Integer> squareBiFunction = (num1, num2) -> (long) num1 * num2;

	public static void testBiFunctions() {
		List<Employee> employees = EmployeeDto.findEmployees();

		int empId = AppConstants.TEN;
		employees.stream().forEach(emp -> {
			double salary = salaryFunction.apply(emp, empId);
			if (salary > AppConstants.DOUBLE_0) {
				System.out.println("Employee Id = " + empId + " Salary = " + salary + "\n");
			}
		});

		int id = AppConstants.ONE;
		String name = AppConstants.ADAM;
		double marks = marksFunction.applyAsDouble(id, name);
		System.out.println("Candiate Id = " + id + "\nName: " + name + "\nMarks = " + marks + "\n");

		int length = stringLengthFunction.applyAsInt(name, name);
		System.out.println("String1: " + name + "\nString2: " + name + "\nLength = " + length + "\n");

		int num1 = AppConstants.INT_1234567891, num2 = AppConstants.INT_312345678;
		long square = squareBiFunction.applyAsLong(num1, num2);
		System.out.println("Number1 = " + num1 + "\nNumber2 = " + num2 + "\nSquare = " + square + "\n");
	}

	public static void main(String[] args) {
		testBiFunctions();
	}
}
