package com.Stack;

public class StackArrImpl {
	
	private int[] arr;
	private int topOfStack;
	
	public StackArrImpl(int size) {
		this.arr=new int[size];
		this.topOfStack = -1;
	}
	
	public void push(int value) {
		if(topOfStack == arr.length-1) {
			System.out.println("Error! StackOverflow");
			return;
		}
		arr[++topOfStack] = value;
		System.out.println("Success! Value added to stack");
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("Error! Stack is empty");
			return;
		}
		System.out.println("Success! "+arr[topOfStack--]+" removed successfully from stack");
	}
	
	public void peek() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println(arr[topOfStack]);
	}
	
	public boolean isEmpty() {
		if(topOfStack == -1) {
			return true;
		}
		return false;
	}

}
