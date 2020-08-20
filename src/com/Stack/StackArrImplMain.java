package com.Stack;

public class StackArrImplMain {

	public static void main(String[] args) {

		StackArrImpl stack = new StackArrImpl(5);
		stack.push(1);
		stack.peek();
		stack.push(2);
		stack.peek();
		stack.pop();
		stack.peek();
	}

}
