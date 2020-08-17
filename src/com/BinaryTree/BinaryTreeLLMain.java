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
		System.out.print("InOrder: ");
		bt.inOrder(bt.getRoot());
		
		bt.deleteNodeOfBinaryTree(40);
		System.out.print("levelOrder: ");
		bt.levelOrder();
		System.out.print("InOrder: ");
		bt.inOrder(bt.getRoot());

	}
}