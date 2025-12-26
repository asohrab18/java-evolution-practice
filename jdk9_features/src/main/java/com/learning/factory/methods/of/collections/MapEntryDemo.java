package com.learning.factory.methods.of.collections;

import java.util.Map;

public class MapEntryDemo {

	public static void checkConvensionalMethod() {
		Map.Entry<Integer, String> entry = Map.entry(1, "Apple");
		System.out.println("Key: " + entry.getKey());
		System.out.println("Value: " + entry.getValue());

		try {
			entry.setValue("BANANA");
		} catch (UnsupportedOperationException e) {
			System.out.println("Map.Entry is immutable so it cannot be modified by any kind of value.");
		}

		try {
			entry.setValue("");
		} catch (UnsupportedOperationException e) {
			System.out.println("Map.Entry is immutable so it cannot be modified by any kind of value.");
		}

		try {
			entry.setValue(null);
		} catch (UnsupportedOperationException e) {
			System.out.println("Map.Entry is immutable so it cannot be modified by any kind of value.");
		}
	}

	public static void checkJava9OfEntries() {
		System.out.println("\nUsing Java-9 ofEntries() method:\n");
		Map<Integer, String> immutableMap = Map.ofEntries(Map.entry(1, "Apple"), Map.entry(2, "Banana"),
				Map.entry(3, "Coconut"), Map.entry(4, "Coconut"), Map.entry(0, ""));

		System.out.println("immutableMap: " + immutableMap);

		try {
			immutableMap.put(5, "MANGO");
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
		checkJava9OfEntries();

	}

}
