package com.Stack;

public class StackLLImplMain {

	public static void main(String[] args) {

		StackLLImpl stack = new StackLLImpl();
		
		stack.push(1);
		stack.push(2);
		stack.peek();
		stack.pop();
		stack.peek();
		stack.pop();
	}

}
