package com.Stack;

import java.util.LinkedList;

public class StackLLImpl {
	
	private LinkedList<Integer> list;
	
	public StackLLImpl() {
		this.list = new LinkedList<>();
	}
	
	public void push(int value) {
		list.addFirst(value);
		System.out.println("Success! push for "+value);
	}
	
	public void pop() {
		if(list.peekFirst()==null) {
			System.out.println("Error! Stack is Empty");
			return;
		}
		System.out.println(list.removeFirst()+" Removed Successfully");
	}
	
	public void peek() {
		System.out.println(list.peekFirst());
	}

}
