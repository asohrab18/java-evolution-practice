package com.learning.lambdaExpressions;

import com.learning.functionalInterfaces.Greeting;

public class MainGreeting {

	public static void main(String[] args) {
		Greeting g = () -> System.out.println("Welcome to JDK-8!");

		g.perform();

	}

}
