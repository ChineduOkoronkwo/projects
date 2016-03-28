package com.learning.datastructures;

public class LinkStack {
	
	Link first;
	
	public LinkStack(){
		first = null;
	}
	
	public void push(int id, double dd){
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;
	}
	
	public Link pop(){
		Link temp = first;
		if (!isEmpty())
			first = first.next;
		return temp;
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void displayStack(){
		Link current = first;
		while (current != null){
			current.displayLink();
			current = current.next;
		}
		
		System.out.println("");
	}

}
