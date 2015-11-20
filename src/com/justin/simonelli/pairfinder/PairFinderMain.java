package com.justin.simonelli.pairfinder;

import java.util.Set;

import com.justin.simonelli.pairfinder.model.Pair;
import com.justin.simonelli.pairfinder.test.PairFinderTest;

public class PairFinderMain {

	public static void main(String[] args) {
		int[] intArray = {1,2,3,4,5,6,3,6,8,5,8,9,4,3,5};
		PairFinder finder = new PairFinder();
		
		Set<Pair> pairs = finder.findIncreasingRagePairs(intArray);
		for( Pair p : pairs ){
			System.out.println("(" + p.getStartIndex() + ", " + p.getEndIndex() + ")" );
		}

		PairFinderTest.runTests();
	}
}
