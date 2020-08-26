package com.LinkedList;

public class SinglyLinkedListMain {

	public static void main(String[] args) {
		SinglyLinkedList sll=new SinglyLinkedList();
		sll.addLast(2);
		sll.addLast(3);
		sll.addLast(4);
		sll.addLast(5);
		sll.addLast(6);
		sll.add(12, 1);
		sll.traverseList();
		//SingleNode n = sll.reverse(sll.get(2));
		//sll.reverseRecursively();
		sll.reverse();
		sll.traverseList();
//		sll.delete(1);
//		sll.traverseList();
//		sll.deleteFirst();
//		sll.traverseList();
//		sll.deleteLast();
//		sll.traverseList();
//		sll.search(8);
	}
}
