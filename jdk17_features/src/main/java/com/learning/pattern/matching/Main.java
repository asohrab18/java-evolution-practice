/**JEP 406 introduced Pattern Matching for switch as a preview feature in Java 17. 
 * It allows patterns to be used in case labels, making type-based conditional logic more concise.
* Reduces repetitive instanceof checks.
* Allows type patterns inside switch.
* Makes complex conditional logic easier to read.*/

package com.learning.pattern.matching;

public class Main {

	static String getType(Object obj) {
		return switch (obj) {
		case Integer i -> "Integer: " + i;
		case String s -> "String: " + s;
		default -> "Unknown";
		};
	}

	public static void main(String[] args) {
		System.out.println(getType("Geeks"));
		System.out.println(getType(100));
		System.out.println(getType(6.45f));
	}
}
