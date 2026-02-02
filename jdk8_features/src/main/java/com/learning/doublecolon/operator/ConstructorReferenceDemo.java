package com.learning.doublecolon.operator;

import com.learning.functionalInterfaces.customized.BankInformation;
import com.learning.functionalInterfaces.customized.EmployeeDataProvider;
import com.learning.functionalInterfaces.customized.EmployeeProvider;
import com.learning.functionalInterfaces.customized.StudentProvider;
import com.learning.model.Bank;
import com.learning.model.Employee;
import com.learning.model.Student;
import com.learning.utils.AppConstants;

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
		Employee employee = employeeDataProvider.get(AppConstants.HUNDRED, AppConstants.JOHN, AppConstants.FOURTY_EIGHT,
				AppConstants.CS, AppConstants.DOUBLE_120000, AppConstants.TRUE);

		System.out.println(employee);
	}

	public static void testStudent() {
		Student student = studentProvider.find(AppConstants.TOM, AppConstants.TWELVE);
		System.out.println(student);
	}

	public static void testBank() {
		Bank bank = bankInformation.of(AppConstants.HDFC, AppConstants.MEERUT, AppConstants.UP, AppConstants.INDIA);
		System.out.println(bank);
	}

	public static void main(String[] args) {
		testEmployee();
		testEmployeeData();
		testStudent();
		testBank();
	}
}
