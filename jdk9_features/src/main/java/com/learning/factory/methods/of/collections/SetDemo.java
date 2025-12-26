package com.learning.factory.methods.of.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		// This is mutable Set.
		Set<String> mutableSet = new HashSet<>();
		mutableSet.add("APPLE");
		mutableSet.add("APPLE");
		mutableSet.add("BANANA");
		mutableSet.add("COCONUT");
		mutableSet.add("");
		mutableSet.add("");
		mutableSet.add(null);
		mutableSet.add(null);

		System.out.println("mutableSet: " + mutableSet);

		Set<String> unmodifiableSet = Collections.unmodifiableSet(mutableSet);
		try {
			unmodifiableSet.add("MANGO");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify unmodifiable set.");
		}

		try {
			unmodifiableSet.add(null);
		} catch (UnsupportedOperationException e) {
			System.out.println("null insertion is not allowed in unmodifiable set.");
		}

		System.out.println(
				"\n============== In JDK-9, We can use of() method to create immutable Set. Returned Set is not HashSet. =================");

		Set<String> immutableEmptySet = Set.of();
		System.out.println("immutableEmptySet: " + immutableEmptySet);

		Set<String> immutableSet = Set.of("APPLE", "BANANA", "COCONUT", "");
		// In Set.of() method, duplicate element gives java.lang.IllegalArgumentException. 
		// null gives java.lang.NullPointerException.

		System.out.println("immutableSet: " + immutableSet);

		try {
			immutableSet.add("MANGO");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify immutable set.");
		}

		try {
			immutableSet.add(null);
		} catch (UnsupportedOperationException e) {
			System.out.println("null insertion is not allowed in immutable set.");
		}

	}

}
