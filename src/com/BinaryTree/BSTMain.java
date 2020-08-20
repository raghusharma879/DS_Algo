package com.BinaryTree;

public class BSTMain {

	public static void main(String[] args) {
		BSTImpl bst=new BSTImpl();
		bst.insert(10);
		bst.insert(8);
		bst.insert(12);
		bst.insert(6);
		bst.insert(9);
		bst.insert(11);
		bst.insert(15);
		
		System.out.println("BST-Inorder");
		bst.inOrder();
		System.out.println("BST-levelorder");
		bst.levelOrder();
	}
 
}
