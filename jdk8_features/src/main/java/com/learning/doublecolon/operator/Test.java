package com.learning.doublecolon.operator;

public class Test {

	public static void show() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + ": Hello from show()");
		}
	}

	public void display() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + ": Welcome to display()");
		}
	}

	public static int getFactorial(int num) {
		System.out.println("\nIn Class: com.learning.doublecolon.operator.Test, Method: getFactorial");
		if (num < 0) {
			return 0;
		}
		int fact = 1;
		if (num == 0) {
			return fact;
		}
		for (int i = num; i > 0; i--) {
			fact = fact * i;
		}
		return fact;
	}
}
