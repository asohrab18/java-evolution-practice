package com.learning.doublecolon.operator;

public class MethodReferenceDemo {

	static Runnable firstRunnable = Test::show;

	static Test test = new Test();
	static Runnable secondRunnable = test::display;

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

	public static void main(String[] args) {
		testShow();
		testDisplay();
	}

}
