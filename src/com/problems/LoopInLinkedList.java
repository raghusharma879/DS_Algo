package com.problems;

import com.LinkedList.SingleNode;
import com.LinkedList.SinglyLinkedList;

/*Program to check is there any loop present in linkedlist?
using floyd algo without using extra space*/

public class LoopInLinkedList {
	static SinglyLinkedList list = new SinglyLinkedList();

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++)
			list.addLast(i);
		list.get(5).setNext(list.get(2));
		list.traverseList();
		System.out.println(list.get(2));
		System.out.println(list.get(5).getNext());
		System.out.println(ifLoopExist());
	}

	static boolean ifLoopExist() {
		SingleNode head = list.get(1);
		SingleNode p = head, q = head;

		while (q != null && q.getNext() != null) {
			p = p.getNext();
			q = q.getNext().getNext();
			if (p == q) {
				return true;
			}
		}

		return false;
	}

}
