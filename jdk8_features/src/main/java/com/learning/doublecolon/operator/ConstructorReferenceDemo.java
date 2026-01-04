package com.learning.doublecolon.operator;

import com.learning.functionalInterfaces.customized.BankInformation;
import com.learning.functionalInterfaces.customized.EmployeeDataProvider;
import com.learning.functionalInterfaces.customized.EmployeeProvider;
import com.learning.functionalInterfaces.customized.StudentProvider;
import com.learning.model.Bank;
import com.learning.model.Employee;
import com.learning.model.Student;

public class ConstructorReferenceDemo {

	static EmployeeProvider employeeProvider = Employee::new;

	static EmployeeDataProvider employeeDataProvider = Employee::new;

	static StudentProvider studentProvider = Student::new;

	static BankInformation bankInformation = Bank::new;

	public static void testEmployee() {
		Employee employee = employeeProvider.get();
		System.out.println(employee);
	}

	public static void testEmployeeData() {
		Employee employee = employeeDataProvider.get(100, "Jesica", 48, "CS", 120000, true);
		System.out.println(employee);
	}

	public static void testStudent() {
		Student student = studentProvider.find("Tom", 12);
		System.out.println(student);
	}

	public static void testBank() {
		Bank bank = bankInformation.of("HDFC", "MEERUT", "UP", "INDIA");
		System.out.println(bank);
	}

	public static void main(String[] args) {
		testEmployee();
		testEmployeeData();
		testStudent();
		testBank();
	}
}
