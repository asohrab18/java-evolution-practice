package com.learning.doublecolon.operator;

import java.util.List;
import java.util.function.IntUnaryOperator;
import com.learning.functionalInterfaces.customized.Greeting;
import com.learning.model.Computer;
import com.learning.model.EmployeeDto;
import com.learning.utils.AppUtils;

public class MethodReferenceDemo {

	static Runnable firstRunnable = Computer::show;

	static Computer comp = new Computer();
	static Runnable secondRunnable = comp::display;

	static Runnable thirdRunnable = EmployeeDto::printEmployees;

	static Greeting greeting = EmployeeDto::printEmployees;

	static IntUnaryOperator factorialOperator = Computer::getFactorial;

	public static void testEmployees() {
		Thread t = new Thread(thirdRunnable);
		t.start();

		for (int i = 1; i <= 3; i++) {
			System.out.println(i + ": Main-Thread");
		}
	}

	public static void testShow() {
		Thread t = new Thread(firstRunnable);
		t.start();

		for (int i = 1; i <= 5; i++) {
			System.out.println(i + ": Main-Thread");
		}
	}

	public static void testDisplay() {
		Thread t = new Thread(secondRunnable);
		t.start();

		for (int i = 1; i <= 5; i++) {
			System.out.println(i + ": Main-Thread");
		}
	}

	public static void testGreeting() {
		greeting.perform();
	}

	public static void testFactorial() {
		int num = 5;
		int factorial = factorialOperator.applyAsInt(num);
		System.out.println("Number = " + num + "\nFactorial = " + factorial + "\n");
	}

	public static void testUsingStream() {
		List<Integer> nums = AppUtils.NUMBERS;

		nums.stream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		testShow();
		testDisplay();
		testEmployees();
		testGreeting();
		testFactorial();
		testUsingStream();
	}
}
