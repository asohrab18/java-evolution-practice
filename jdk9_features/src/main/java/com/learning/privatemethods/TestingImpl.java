package com.learning.privatemethods;

public class TestingImpl implements Java9Interface {

	@Override
	public void greetAbstract(String message) {
		System.out.println(message);
	}

	public static void main(String[] args) {
		System.out.println("Organization: " + TestingImpl.COMPANY);
		System.out.println("Organization: " + Java9Interface.COMPANY);

		TestingImpl tm = new TestingImpl();
		tm.greetAbstract("Hello World!");
		tm.showDefault("  Welcome to JDK-9 World!  ");
		
		Java9Interface.displayStatic();

		// NOTE [1]: Cannot make a static reference to the non-static method showDefault() from the type Java9Interface
		// Java9Interface.showDefault("Hello");

		// NOTE [2]: The method displayStatic() is undefined for the type TestingImpl
		// TestingImpl.displayStatic();
	}

}
