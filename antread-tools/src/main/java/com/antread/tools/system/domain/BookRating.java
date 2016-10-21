package com.antread.tools.system.domain;
public class BookRating{
	private int max;
	private int min;
	private int numRaters;
	private String average; 
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getNumRaters() {
		return numRaters;
	}
	public void setNumRaters(int numRaters) {
		this.numRaters = numRaters;
	}
	public String getAverage() {
		return average;
	}
	public void setAverage(String average) {
		this.average = average;
	}
}