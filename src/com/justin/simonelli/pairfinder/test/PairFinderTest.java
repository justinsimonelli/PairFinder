package com.justin.simonelli.pairfinder.test;

import java.util.Set;

import com.justin.simonelli.pairfinder.PairFinder;
import com.justin.simonelli.pairfinder.model.Pair;

/**
 * Test the {@link PairFinder} class. Not using jUnit or anything here for sake
 * of time!
 * 
 * @author Justin Simonelli
 *
 */
public class PairFinderTest {
	public static void main(String[] args) {
		runTests();
	}
	
	/**
	 * Run all the tests in the test class.
	 */
	public static void runTests(){
		
		printHeader();
		testPairFinderWithNullInput();
		testPairFinderWithChallengeInput();
		testPairFinderWithRandomValues();
		testPairFinderWithNoPairs();
		testPairFinderWithOneNegativeNumber();
		testPairFinderWithMultipleNegativeNumbers();
		printFooter();
	}
	
	/**
	 * Test null input.
	 */
	private static void testPairFinderWithNullInput() {
		PairFinder finder = new PairFinder();

		prettyPrintPairs("testPairFinderWithNullInput", 
				finder.findIncreasingRagePairs(null));

	}

	/**
	 * Test the input from the challenge itself.
	 */
	private static void testPairFinderWithChallengeInput() {
		int[] intArray = { 1, 2, 3, 4, 5, 6, 3, 6, 8, 5, 8, 9, 4, 3, 5 };
		PairFinder finder = new PairFinder();

		prettyPrintPairs("testPairFinderWithChallengeInput", 
				finder.findIncreasingRagePairs(intArray));

	}

	/**
	 * Test randomly chosen values
	 */
	private static void testPairFinderWithRandomValues() {
		int[] intArray = { 7, 3, 1, 4, 6, 7, 8, 9, 3, 1, 4, 5, 7, 9, 1 };
		PairFinder finder = new PairFinder();

		prettyPrintPairs("testPairFinderWithRandomValues",
				finder.findIncreasingRagePairs(intArray));
	}

	/**
	 * Test no pairs in the set
	 */
	private static void testPairFinderWithNoPairs() {
		int[] intArray = { 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		PairFinder finder = new PairFinder();

		Set<Pair> emptyPairSet = finder.findIncreasingRagePairs(intArray);
		if (emptyPairSet != null && emptyPairSet.size() == 0) {
			System.out
					.println("testPairFinderWithRandomValues(): No pairs found. SUCCESS");
		}
	}

	/**
	 * Test with one negative number
	 */
	private static void testPairFinderWithOneNegativeNumber() {
		int[] intArray = { 7, 3, -1, 4, 6, 5, 8, 9, 3, 1, 4, 5, 7, 9, 1 };
		PairFinder finder = new PairFinder();

		prettyPrintPairs("testPairFinderWithNegativeNumber",
				finder.findIncreasingRagePairs(intArray));
	}
	
	/**
	 * Test with negative numbers
	 */
	private static void testPairFinderWithMultipleNegativeNumbers() {
		int[] intArray = { -4, -3, 1, 4, 6, -5, -8, 9, 3, 1, 4, 5, 7, -9, 1 };
		PairFinder finder = new PairFinder();

		prettyPrintPairs("testPairFinderWithMultipleNegativeNumbers",
				finder.findIncreasingRagePairs(intArray));
	}
	
	private static void printHeader(){
		System.out.println("\n---- RUNNING PairFinder Tests ----\n");
	}
	
	private static void printFooter(){
		System.out.println("\n---- Ending PairFinder Tests ----\n");
	}

	/**
	 * Prints the pairs in a format as such: <code>(startIndex, endIndex)</code>
	 * 
	 * @param pairSet
	 */
	private static void prettyPrintPairs(String method, Set<Pair> pairSet) {
		if (pairSet == null || pairSet.size() == 0) {
			System.out
					.println( method + " - Null or empty set provided, no printing for you!");
			System.out.println("\n---------------\n");
			return;
		}

		for (Pair p : pairSet) {
			System.out.println (method + " - (" + p.getStartIndex() + ", "
					+ p.getEndIndex() + ")");
		}
		System.out.println("\n---------------\n");
		
		
	}
}
