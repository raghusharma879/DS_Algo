package com.LinkedList;

public class SinglyLinkedList {

	private SingleNode head;
	private SingleNode tail;
	private int size;
	
	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}

	public void addFront(int value) {
		SingleNode node = new SingleNode(value);
		node.setNext(head);
		head = node;
		if(tail==null) {
			tail = node;
		}
		size++;
		System.out.println("Success! Add");
	}
	
	public void addLast(int value) {
		SingleNode node = new SingleNode(value);
		if(tail==null) {
			tail=node;
		}else {
			tail.setNext(node);
			tail=node;
		}
		
		if(head==null) {
			head=node;
		}
		size++;
		System.out.println("Success! Add");
	}
	
	public void add(int value, int location) {
		if(location < 0) {
			System.out.println("Error! Invalid position");
			return;
		}
		if(location == 0) {
			addFront(value);
		}else if(location >= size) {
			addLast(value);
		}else {
			SingleNode node = new SingleNode(value);
			SingleNode temp = head;
			for(int i=0;i<location-1;i++) {
				temp=temp.getNext();
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
			size++;
			System.out.println("Success! Add");
		}
	}
	
	public void traverseList() {
		if(head == null) {
			System.out.println("Err! List is empty");
			return;
		}
		SingleNode temp = head;
		System.out.print(temp.getValue());
		for(int i=0;i<getSize()-1;i++) {
			temp=temp.getNext();
			System.out.print(" --> "+temp.getValue());
			
		}
	}
	
	public void deleteFirst() {
		if(head==null) {
			System.out.println("Failed! List is Empty");
			return;
		}
		head=head.getNext();
		size--;
		System.out.println("Success! Delete");
	}
	
	public void deleteLast() {
		if(head==null) {
			System.out.println("Failed! List is Empty");
			return;
		}
		tail=null;
		size--;
		System.out.println("Success! Delete");
	}
	
	public void delete(int location) {
		if(head==null) {
			System.out.println("Failed! List is Empty");
			return;
		}
		if(location < 0) {
			System.out.println("Failed! Invalid Location");
			return;
		}
		SingleNode temp = head;
		if(location == 0) {
			deleteFirst();
		}else if(location>=getSize()) {
			deleteLast();
		}else {
			SingleNode prevNode = head;
			SingleNode nodeToBedeleted = head.getNext();
			for(int i=0;i<location-2;i++) {
				prevNode=prevNode.getNext();
				nodeToBedeleted = nodeToBedeleted.getNext();
			}
			prevNode.setNext(nodeToBedeleted.getNext());
			size--;
			System.out.println("Success! deleted");
		}
	}
	
	public void search(int value) {
		if(head==null) {
			System.out.println("Failed! List is Empty");
			return;
		}
		SingleNode temp = head;
		for(int i=0;i<getSize();i++) {
			if(temp.getValue()==value) {
				System.out.println("Success! Found at location_"+i);
				return;
			}
			temp=temp.getNext();
		}
		System.out.println("Failed! Could not find");
	}
}
