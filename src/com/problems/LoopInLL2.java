package com.problems;

import com.LinkedList.SingleNode;
import com.LinkedList.SinglyLinkedList;
/*Program to find starting point of loop (if any exist) in linkedlist?
using floyd algo without using extra space*/

public class LoopInLL2 {
	static SinglyLinkedList list = new SinglyLinkedList();

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++)
			list.addLast(i);
		list.get(5).setNext(list.get(2));
		list.traverseList();
		SingleNode startingPoint = findStartingPoint();
		System.out.println(startingPoint.getValue());
	}

	static SingleNode getIntersect() {
		SingleNode head = list.get(1);
		SingleNode p = head, q = head;

		while (q != null && q.getNext() != null) {
			p = p.getNext();
			q = q.getNext().getNext();
			if (p == q)
				return p;
		}
		return null;
	}

	static SingleNode findStartingPoint() {
		SingleNode p = list.get(1); // pointer to head
		SingleNode intersect = getIntersect(); // pointer to intersect
		if (intersect == null) {
			return null;
		}
		while (p != intersect) {
			p = p.getNext();
			intersect = intersect.getNext();
		}
		return p;
	}

}
