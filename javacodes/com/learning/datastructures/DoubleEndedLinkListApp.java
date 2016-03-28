package com.learning.datastructures;

public class DoubleEndedLinkListApp {
	
	public static void main(String[] args){
		DoubleEndedLinkList theList = new DoubleEndedLinkList();
		theList.insertFirst(22, 2.22);
		theList.insertFirst(44, 4.44);
		theList.insertFirst(66, 6.66);
		
		theList.insertLast(11, 1.11);
		theList.insertLast(33, 3.33);
		theList.insertLast(55, 5.55);
		theList.displayList();
		
		theList.deleteFirst();
		theList.deleteFirst();
		
		theList.displayList();
	}

}
