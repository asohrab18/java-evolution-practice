package com.learning.doublecolon.operator;

import com.learning.functionalInterfaces.customized.Greeting;
import com.learning.model.EmployeeDto;

public class MethodReferenceDemo {

	static Runnable firstRunnable = Test::show;

	static Test test = new Test();
	static Runnable secondRunnable = test::display;

	static Runnable thirdRunnable = EmployeeDto::printEmployees;

	static Greeting greeting = EmployeeDto::printEmployees;

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

	public static void main(String[] args) {
		testShow();
		testDisplay();
		testEmployees();
		testGreeting();
	}

}
