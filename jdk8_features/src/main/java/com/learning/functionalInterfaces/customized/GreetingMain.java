package com.learning.functionalInterfaces.customized;

public class GreetingMain {

	public static void main(String[] args) {
		Greeting g = () -> System.out.println("Welcome to JDK-8!");

		g.perform();

	}

}
