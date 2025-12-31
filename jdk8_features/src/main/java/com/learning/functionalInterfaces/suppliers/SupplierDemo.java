package com.learning.functionalInterfaces.suppliers;

import java.util.function.Supplier;

import com.learning.model.Employee;

public class SupplierDemo {

	static Supplier<String> greetingSupplier = () -> "Hello World!";
	static Supplier<Employee> employeeSupplier = () -> new Employee(123, "Marry", "HR", 123456d, true);

	public static void main(String[] args) {
		String msg = greetingSupplier.get();
		System.out.println(msg);

		Employee employee = employeeSupplier.get();
		System.out.println(employee);
	}

}
