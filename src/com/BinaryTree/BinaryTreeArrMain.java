package com.BinaryTree;

public class BinaryTreeArrMain {

	public static void main(String[] args) {
		BinaryTreeArr bt = new BinaryTreeArr(5);
		bt.insert(2);
		bt.insert(3);
		bt.insert(4);
		bt.insert(5);
		bt.insert(1);
		bt.insert(2);
		bt.search(2);
		bt.levelOrder(1);
		System.out.println();
		bt.preOrder(1);
		System.out.println();
		bt.inOrder(1);
		System.out.println();
		bt.postOrder(1);
		
		bt.delete(2);
		
		bt.levelOrder(1);
		System.out.println();
		bt.preOrder(1);
		System.out.println();
		bt.inOrder(1);
		System.out.println();
		bt.postOrder(1);
		
		bt.deleteTree();
		bt.levelOrder(1);
		System.out.println();
		bt.preOrder(1);
		System.out.println();
		bt.inOrder(1);
		System.out.println();
		bt.postOrder(1);

	}

}
