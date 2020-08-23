package com.problems;

import java.util.HashMap;

import com.LinkedList.SingleNode;
import com.LinkedList.SinglyLinkedList;

/*Program to check is there any loop present in linkedlist?
using HashMap*/
public class LoopInLL3 {

	static SinglyLinkedList list = new SinglyLinkedList();

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++)
			list.addLast(i);
		list.get(5).setNext(list.get(2));
		list.traverseList();
		SingleNode node = ifLoopExist(list.get(1));
		if (node == null) {
			System.out.println("No Loop Found");
		} else {
			System.out.println("Loop found with starting point_" + node.getValue());
		}
	}

	public static SingleNode ifLoopExist(SingleNode head) {
		SingleNode temp = head;
		HashMap<SingleNode, Integer> map = new HashMap<>();
		while (temp != null && temp.getNext() != null) {
			if (!map.containsKey(temp)) {
				map.put(temp, temp.getValue());
			} else {
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}

}
