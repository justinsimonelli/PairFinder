package com.justin.simonelli.pairfinder.model;

/**
 * This class represents an int pair 
 * where the <code>startIndex</code> field is the starting index of an increasing pair set,
 * while <code>endIndex</code> field is the ending index of the aforementioned pair set.
 * @author Justin Simonelli
 *
 */
public class Pair {

	private int startIndex;
	private int endIndex;
	
	public Pair(){
		//default constructor
	}
	
	public Pair(int startIndex, int endIndex){
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Pair");
		sb.append("[");
		sb.append("startIndex:");
		sb.append(getStartIndex());
		sb.append(", endIndex:");
		sb.append(getEndIndex());
		sb.append("]");
		
		return sb.toString();
	}
	
	//leaving equals() and hashcode() out due to time constraints.
	
}
