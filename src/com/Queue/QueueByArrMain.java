package com.Queue;

public class QueueByArrMain {

	public static void main(String[] args) {
	QueueByArr q = new QueueByArr(5);
	q.enqueue(1);
	q.enqueue(2);
	q.printQueue();
	q.dequeue();
	q.printQueue();
	q.dequeue();
	q.printQueue();
	}

}
