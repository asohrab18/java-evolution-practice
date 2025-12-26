package com.learning.factory.methods.of.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void checkConvensionalMethod() {
		Map<Integer, String> mutableMap = new HashMap<>();
		mutableMap.put(1, "APPLE");
		mutableMap.put(1, "PINEAPPLE");
		mutableMap.put(2, "BANANA");
		mutableMap.put(3, "COCONUT");
		mutableMap.put(4, "COCONUT");
		mutableMap.put(5, "");
		mutableMap.put(6, "");
		mutableMap.put(null, null);
		mutableMap.put(null, null);

		System.out.println("mutableMap: " + mutableMap);

		Map<Integer, String> unmodifiableMap = Collections.unmodifiableMap(mutableMap);
		try {
			unmodifiableMap.put(6, "MANGO");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify unmodifiable map.");
		}

		try {
			unmodifiableMap.put(null, "Orange");
		} catch (UnsupportedOperationException e) {
			System.out.println("null key insertion is not allowed in unmodifiable map.");
		}

		try {
			unmodifiableMap.put(7, null);
		} catch (UnsupportedOperationException e) {
			System.out.println("null value insertion is not allowed in unmodifiable map.");
		}
	}

	public static void checkJava9Of() {
		System.out.println(
				"\n============== In JDK-9, We can use of() method to create immutable Map. Returned Map is not HashMap. =================");

		Map<Integer, String> immutableEmptyMap = Map.of();
		System.out.println("immutableEmptyMap: " + immutableEmptyMap);

		Map<Integer, String> immutableMap = Map.of(1, "APPLE", 2, "BANANA", 3, "COCONUT", 4, "COCONUT", 5, "", 6, "");
		// In Map.of() method, duplicate key gives java.lang.IllegalArgumentException.
		// null key or null value gives java.lang.NullPointerException.
		System.out.println("immutableMap: " + immutableMap);

		try {
			immutableMap.put(7, "MANGO");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify immutable map.");
		}

		try {
			immutableMap.put(null, "Guava");
		} catch (UnsupportedOperationException e) {
			System.out.println("null key insertion is not allowed in immutable map.");
		}

		try {
			immutableMap.put(8, null);
		} catch (UnsupportedOperationException e) {
			System.out.println("null value insertion is not allowed in immutable map.");
		}
	}

	public static void main(String[] args) {
		checkConvensionalMethod();
		checkJava9Of();
	}

}
