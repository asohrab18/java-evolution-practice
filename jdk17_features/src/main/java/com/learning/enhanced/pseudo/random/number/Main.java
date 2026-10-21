/**Enhanced Pseudo-Random Number Generators:
JEP 356 introduced new interfaces and implementations for Pseudo-Random Number Generators (PRNGs). 
It provides a common API for using different random number generation algorithms.
* Introduces the RandomGenerator interface.
* Provides access to multiple PRNG algorithms.
* Supports stream-based random number generation.
* */
package com.learning.enhanced.pseudo.random.number;

import java.util.random.RandomGenerator;

public class Main {

	final static RandomGenerator RANDOM = RandomGenerator.getDefault();

	/** Returns a pseudorandomly chosen int value. 
	 * The default implementation uses the 32 high-order bits from a call to nextLong(). */
	public static int getRandomIntegerNumberV1() {
		return RANDOM.nextInt();
	}

	/** Returns a pseudorandomly chosen int value between zero (inclusive) and 
	 * the specified bound (exclusive).
	 */
	public static int getRandomIntegerNumberV2(int bound) {
		return RANDOM.nextInt(bound);
	}
	
	/** Returns a pseudorandomly chosen int value between the specified origin (inclusive) and 
	 * the specified bound (exclusive).
	 */
	public static int getRandomIntegerNumberV3(int origin, int bound) {
		return RANDOM.nextInt(origin, bound);
	}

	public static void main(String[] args) {
		System.out.println(getRandomIntegerNumberV1());
		System.out.println(getRandomIntegerNumberV2(100));
		System.out.println(getRandomIntegerNumberV3(500, 1000));
	}

}
