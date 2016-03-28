package com.learning.datastructures;

public class SortedLinkList {
	
	private Link first;
	
	public SortedLinkList(){
		first = null;
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void insert(int id, double dd){
		Link newLink = new Link(id, dd);
		Link previous = null;
		Link current = first;
		
		while (current != null && id > current.iData){
			previous = current;
			current = current.next;
		}
		
		if (previous == null)
			first = newLink;
		else
			previous.next = newLink;
		newLink.next = current;
	}
	
	public Link remove(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		System.out.print("List (first --> last): ");
		Link current = first;
		while (current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}

}
