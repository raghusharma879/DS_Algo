package com.Queue;

public class QueueByArr {
	
	private int[] arr;
	private int endOfQueue;
	private int startOfQueue;
	
	public QueueByArr(int size) {
		this.arr = new int[size];
		this.endOfQueue = -1;
		this.startOfQueue = -1;
	}
	
	public void enqueue(int value) {
		if(isFull()) {
			System.out.println("Error! Queue is Full");
			return;
		}else if(isEmpty()) {
			startOfQueue = 0;
			arr[++endOfQueue] = value;
			System.out.println("Success! "+value+" enqueued");
		}else {
			arr[++endOfQueue] = value;
			System.out.println("Success! "+value+" enqueued");
		}
		
	}
	
	public void dequeue() {
		if(isEmpty()) {
			System.out.println("Error! Queue is Empty");
			return;
		}
		int retrivedValue = arr[startOfQueue++];
		if(startOfQueue > endOfQueue) {
			startOfQueue = endOfQueue = -1;
		}
		System.out.println("Success "+retrivedValue+" retrived from queue");
	}
	
	public void printQueue() {
		if(isEmpty()) {
			System.out.println("Error! queue is empty");
			return;
		}
		for(int i=startOfQueue;i<=endOfQueue;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public void peek() {
		if(isEmpty()) {
			System.out.println("Error! Queue is Empty");
			return;
		}
		System.out.println(arr[startOfQueue]);
	}

	public boolean isEmpty() {
		if(startOfQueue == -1 || startOfQueue == arr.length-1) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(endOfQueue==arr.length-1) {
			return true;
		}
		return false;
	}
}
