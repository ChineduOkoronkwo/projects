package com.learning.datastructures;

public class LinkListApp {
	
	public static void find(LinkList theList, int key){
		Link f = theList.find(key);
		if (f != null)
			System.out.println("found link with key " + f.iData);
		else
			System.out.println("Can't find link with key " + key);
	}
	
	public static void delete(LinkList theList, int key){
		Link f = theList.delete(key);
		if (f != null)
			System.out.println("Deleted link with key " + f.iData);
		else
			System.out.println("Can't delete link; link does not exist");
	}
	
	public static void main(String[] args){
		LinkList theList = new LinkList();
		theList.insertFirst(22, 2.99);
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		
		theList.displayList();
		
		while (!theList.isEmpty()){
			Link aLink = theList.deleteFirst();
			System.out.print("Deleted ");
			aLink.displayLink();
			System.out.println();
		}
		
		theList.displayList();
		
		theList.insertFirst(22, 2.99);
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		
		theList.displayList();
		
		find(theList, 44);
		find(theList, 99);
		
		delete(theList, 99);
		delete(theList, 44);
		
		theList.displayList();
	}

}
