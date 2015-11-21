package com.justin.simonelli.pairfinder;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.justin.simonelli.pairfinder.model.Pair;

public class PairFinder {
	private Integer pairStartingIndex = null;
	private Integer pairEndingIndex = null;
	private Set<Pair> pairs = Collections.emptySet();
	private Integer previousValue = null;
	private boolean noisyLogging = false;
	
	
	public PairFinder(){
		//default constructor
	}
	
	/**
	 * Constructor to enable or disable noisy logging.
	 * 
	 * @param noisyLogging
	 */
	public PairFinder(boolean noisyLogging){
		this.noisyLogging = noisyLogging;
	}
		
	/**
	 * Given the inbound int array, find the (index) ranges
	 * where the values are increasing. 
	 * <br/>
	 * <br/>
	 * Ex: 3,4,5,1 -> (0, 2) | since 1 < 5, the pair is not increasing
	 * 
	 * @param inboundHaystack
	 * @return - this method will return an empty
	 */
	public Set<Pair> findIncreasingRagePairs(int[] inbound){
		
		//let's short circuit right here if what was provided was invalid
		if( inbound == null || inbound.length == 0 ){
			//Substitute an actual logger here like log4j, but that's not what we're after today, is it!
			Logger.getAnonymousLogger().log(Level.WARNING, "findIncreasingRagePairs(): inbound is null or empty! Unable to find any pair ranges.");
			return null;
		}
		
		//initialize our set
		pairs = new HashSet<>(inbound.length);
		
		for( int i = 0; i < inbound.length; i++ ){
			int current = inbound[i];
			boolean isLastEntry = (i == inbound.length - 1);
			
			//first entry in the array
			previousValue = ( i - 1 < 0 ) ? current: inbound[ i - 1];
			
			if( ( current > previousValue ) ){
				if( pairStartingIndex == null  ){
					pairStartingIndex = ( i - 1 );
					if( isLastEntry == true ){
						pairEndingIndex = i;
						createPairAndAddToSet(pairStartingIndex, pairEndingIndex, pairs);
					}
					
				}else{
					continue;
				}
				
			}else{
				if( pairStartingIndex != null && pairEndingIndex == null ){
					pairEndingIndex =  ( i - 1 );
					createPairAndAddToSet(pairStartingIndex, pairEndingIndex, pairs);					
				}
			}
			
		}

		return pairs;
	}
	
	/**
	 * Create a new pair object, and add it to the given set.
	 * @param startingIndex
	 * @param endingIndex
	 * @param pairs
	 */
	private void createPairAndAddToSet(int startingIndex, int endingIndex, Set<Pair> pairs){
		Pair p = new Pair(startingIndex, endingIndex);
		pairs.add(p);
		resetIndexes();
		if( noisyLogging == true ){
			Logger.getAnonymousLogger().log(Level.INFO, "adding pair to set: " + p);
		}
		
	}
	
	/**
	 * Reset the indexes to null so we can move on to the next set
	 * with clean indexes.
	 */
	private void resetIndexes(){
		this.pairStartingIndex = null;
		this.pairEndingIndex = null;
	}
	
	
	
}
