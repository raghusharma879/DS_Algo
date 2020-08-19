package com.BinaryTree;

public class BinaryTreeLLMain {

	public static void main(String[] args) {
		BinaryTreeLinkedList bt = new BinaryTreeLinkedList();
		bt.insert(10);
		bt.getRoot().setLeftChild(new BinaryNode(20));
		bt.getRoot().setRightChild(new BinaryNode(30));
		bt.getRoot().getLeftChild().setLeftChild(new BinaryNode(40));
		System.out.print("levelOrder: ");
		bt.levelOrder();
		System.out.print("InOrderR: ");
		bt.inOrderRecursive(bt.getRoot());
		System.out.print("InOrder: ");
		bt.inOrder();
		System.out.print("InOrder2: ");
		bt.inOrder2();
		System.out.print("preOrderR: ");
		bt.preOrderRecursive(bt.getRoot());
		System.out.print("preOrder: ");
		bt.preOrder();
		System.out.print("postOrderR: ");
		bt.postOrderRecursive(bt.getRoot());
		System.out.print("postOrder: ");
		bt.postOrder();
		
	

	}
}