package com.learning.datastructures;

public class SortedLinkListApp {
	
	public static void main(String[] args){
		SortedLinkList theSortedLinkList = new SortedLinkList();
		theSortedLinkList.insert(20, 2.29);
		theSortedLinkList.insert(40, 2.29);
		theSortedLinkList.insert(10, 2.29);
		theSortedLinkList.insert(50, 2.29);
		theSortedLinkList.insert(30, 3.29);
		
		theSortedLinkList.displayList();
		
		theSortedLinkList.remove();
		
		theSortedLinkList.displayList();
	}

}
