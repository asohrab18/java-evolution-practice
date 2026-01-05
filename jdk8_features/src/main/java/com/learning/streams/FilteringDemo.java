package com.learning.streams;

import java.util.List;
import com.learning.model.Employee;
import com.learning.model.EmployeeDto;

public class FilteringDemo {

	private static List<Employee> employees = EmployeeDto.findEmployees();

	static void printEmployees() {
		employees.stream().forEach(e -> System.out.println(e));
	}

	static void printActiveEmployees() {
		employees.stream().filter(e -> e.isActive()).forEach(e -> System.out.println(e));
	}

	static void printInactiveEmployees() {
		employees.stream().filter(e -> !e.isActive()).forEach(e -> System.out.println(e));
	}

	static void printEmployeesWithSalaryGreaterThanInput(double input) {
		employees.stream().filter(e -> e.getSalary() > input).forEach(e -> System.out.println(e));
	}

	static void printActiveEmployeesWithSalaryGreaterThanInput(double input) {
		employees.stream().filter(e -> e.isActive()).filter(e -> e.getSalary() > input)
				.forEach(e -> System.out.println(e));
	}

	static void printEmployeesWithSalaryLessThanInput(double input) {
		employees.stream().filter(e -> e.getSalary() < input).forEach(e -> System.out.println(e));
	}

	static void printActiveEmployeesWithSalaryLessThanInput(double input) {
		employees.stream().filter(e -> e.isActive()).filter(e -> e.getSalary() < input)
				.forEach(e -> System.out.println(e));
	}

	static void printActiveEmployeesFromGivenDepartmentWithSalaryGreaterThanInput(String department, double input) {
		employees.stream().filter(e -> e.isActive()).filter(e -> e.getDept().equalsIgnoreCase(department))
				.filter(e -> e.getSalary() > input).forEach(e -> System.out.println(e));
	}

	static void printActiveEmployeesFromGivenDepartmentWithSalaryLessThanInput(String department, double input) {
		employees.stream().filter(e -> e.isActive()).filter(e -> e.getDept().equalsIgnoreCase(department))
				.filter(e -> e.getSalary() < input).forEach(e -> System.out.println(e));
	}

	public static void main(String[] args) {
		printEmployees();
	}

}
