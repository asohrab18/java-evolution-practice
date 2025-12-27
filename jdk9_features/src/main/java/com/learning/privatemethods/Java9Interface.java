package com.learning.privatemethods;

public interface Java9Interface {

	String COMPANY = "HTC GLOBAL";

	void greetAbstract(String message);

	default void showDefault(String input) {
		System.out.println("This is from default method: " + trimIt(input));
	}

	public static void displayStatic() {
		System.out.println("This is from static method. Roll Number is " + getRandomNumber());
	}

	// Java-9 allowed private methods in Interface
	private static int getRandomNumber() {
		return (int) (Math.random() * 100);
	}

	private String trimIt(String input) {
		if (input == null) {
			return "";
		}
		return input.trim();
	}

}