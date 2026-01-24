package com.learning.streams;

import com.learning.model.AppUtils;

public class FilteringDemo {

	static void printEmployees() {
		AppUtils.employees.stream().forEach(e -> System.out.println(e));
	}

	static void printActiveEmployees() {
		AppUtils.employees.stream().filter(e -> e.isActive()).forEach(e -> System.out.println(e));
	}

	static void printInactiveEmployees() {
		AppUtils.employees.stream().filter(e -> !e.isActive()).forEach(e -> System.out.println(e));
	}

	static void printEmployeesWithSalaryGreaterThanInput(double input) {
		AppUtils.employees.stream().filter(e -> e.getSalary() > input).forEach(e -> System.out.println(e));
	}

	static void printActiveEmployeesWithSalaryGreaterThanInput(double input) {
		AppUtils.employees.stream().filter(e -> e.isActive()).filter(e -> e.getSalary() > input)
				.forEach(e -> System.out.println(e));
	}

	static void printEmployeesWithSalaryLessThanInput(double input) {
		AppUtils.employees.stream().filter(e -> e.getSalary() < input).forEach(e -> System.out.println(e));
	}

	static void printActiveEmployeesWithSalaryLessThanInput(double input) {
		AppUtils.employees.stream().filter(e -> e.isActive()).filter(e -> e.getSalary() < input)
				.forEach(e -> System.out.println(e));
	}

	static void printActiveEmployeesFromGivenDepartmentWithSalaryGreaterThanInput(String department, double input) {
		AppUtils.employees.stream().filter(e -> e.isActive()).filter(e -> e.getDept().equalsIgnoreCase(department))
				.filter(e -> e.getSalary() > input).forEach(e -> System.out.println(e));
	}

	static void printActiveEmployeesFromGivenDepartmentWithSalaryLessThanInput(String department, double input) {
		AppUtils.employees.stream().filter(e -> e.isActive()).filter(e -> e.getDept().equalsIgnoreCase(department))
				.filter(e -> e.getSalary() < input).forEach(e -> System.out.println(e));
	}

	public static void main(String[] args) {
		printEmployees();
	}

}
