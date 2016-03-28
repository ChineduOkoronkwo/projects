package com.learning.datastructures;

public class LinkStackApp {
	
	public static void main(String[] args){
		LinkStack theStack = new LinkStack();
		theStack.first = null;
		theStack.push(20, 2.00);
		theStack.push(40, 4.00);
		theStack.push(60, 6.66);
		
		theStack.displayStack();
		
		theStack.pop();
		theStack.pop();
		
		theStack.displayStack();
	}

}
