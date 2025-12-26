package com.learning.factory.methods.of.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {

	public static void checkConvensionalMethod() {
		List<String> mutableList = new ArrayList<>();
		mutableList.add("APPLE");
		mutableList.add("BANANA");
		mutableList.add("COCONUT");
		mutableList.add("COCONUT");
		mutableList.add("");
		mutableList.add("");
		mutableList.add(null);
		mutableList.add(null);

		System.out.println("mutableList: " + mutableList);

		List<String> unmodifiableList = Collections.unmodifiableList(mutableList);
		try {
			unmodifiableList.add("MANGO");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify unmodifiable list.");
		}

		try {
			unmodifiableList.add(null);
		} catch (UnsupportedOperationException e) {
			System.out.println("null insertion is not allowed in unmodifiable list.");
		}
	}

	public static void checkJava9Of() {
		System.out.println(
				"\n============== In JDK-9, We can use of() method to create immutable List. Returned list is not ArrayList. =================");

		List<String> immutableEmptyList = List.of();
		System.out.println("immutableEmptyList: " + immutableEmptyList);

		List<String> immutableList = List.of("APPLE", "BANANA", "COCONUT", "COCONUT", "", "");
		// In List.of() method, null gives java.lang.NullPointerException.
		System.out.println("immutableList: " + immutableList);

		try {
			immutableList.add("MANGO");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify immutable list.");
		}

		try {
			immutableList.add(null);
		} catch (UnsupportedOperationException e) {
			System.out.println("null insertion is not allowed in immutable list.");
		}

	}

	public static void main(String[] args) {
		checkConvensionalMethod();
		checkJava9Of();
	}

}
