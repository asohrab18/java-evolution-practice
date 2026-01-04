package com.learning.doublecolon.operator;

public class LambdaExpressionDemo {

	static Runnable r = () -> {
		for (int i = 1; i <= 15; i++) {
			System.out.println("Child-Thread");
		}
	};

	public static void main(String[] args) {
		Thread t = new Thread(r);
		t.start();

		for (int i = 1; i <= 15; i++) {
			System.out.println("Main-Thread");
		}
	}
}
