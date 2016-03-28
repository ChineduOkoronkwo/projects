package com.learning.datastructures;

public class DoubleLink {
	
	private long dData;
	public DoubleLink next;
	public DoubleLink previous;
	
	public DoubleLink(long dd){
		dData = dd;
	}
	
	public void displayLink(){
		System.out.print(dData + " ");
	}
}
