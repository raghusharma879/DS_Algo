package com.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLinkedList {

	private BinaryNode root;

	public BinaryTreeLinkedList() {
		this.root = null;
	}

	public BinaryNode getRoot() {
		return root;
	}

	public void insert(int value) {
		BinaryNode valueToAdd = new BinaryNode(value);
		if (root == null) {
			root = valueToAdd;
			return;
		}
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryNode presentNode = q.poll();
			if (presentNode.getLeftChild() == null) {
				presentNode.setLeftChild(valueToAdd);
				break;
			} else if (presentNode.getRightChild() == null) {
				presentNode.setRightChild(valueToAdd);
				break;
			} else {
				q.add(presentNode.getLeftChild());
				q.add(presentNode.getRightChild());
			}
		}
	}

	public void search(int value) {
		boolean isValueFound = false;
		if (root == null) {
			System.out.println("Error! Tree is Empty");
			return;
		}
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryNode presentNode = q.remove();
			if (presentNode.getValue() == value) {
				isValueFound = true;
				System.out.println("Success! " + value + " is present in tree");
				break;
			} else {
				if (presentNode.getLeftChild() != null) {
					q.add(presentNode.getLeftChild());
				}
				if (presentNode.getRightChild() != null) {
					q.add(presentNode.getRightChild());
				}
			}
		}
		if (!isValueFound) {
			System.out.println("Failure! " + value + " is not present in tree");
			return;
		}
	}

	// delete node from binary tree
	void deleteNodeOfBinaryTree(int value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			// if node is found then copy deepest node here and delete deepest node.
			if (presentNode.getValue() == value) {
				presentNode.setValue(getDeepestNode().getValue());
				DeleteDeepestNode();
				System.out.println("Deleted the node !!");
				return;
			} else {
				if (presentNode.getLeftChild() != null)
					queue.add(presentNode.getLeftChild());
				if (presentNode.getRightChild() != null)
					queue.add(presentNode.getRightChild());
			}
		}
		System.out.println("Did not find the node!!");
	}

	public void DeleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.getLeftChild() == null) {
				previousNode.setRightChild(null);
				return;
			} else if ((presentNode.getRightChild() == null)) {
				presentNode.setLeftChild(null);
				return;
			}
			queue.add(presentNode.getLeftChild());
			queue.add(presentNode.getRightChild());
		}
	}

	private BinaryNode getDeepestNode() {
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(root);
		BinaryNode presentNode = null;
		while (!q.isEmpty()) {
			presentNode = q.poll();
			if (presentNode.getLeftChild() != null) {
				q.add(presentNode.getLeftChild());
			}
			if (presentNode.getRightChild() != null) {
				q.add(presentNode.getRightChild());
			}
		}
		return presentNode;
	}

	public void levelOrder() {
		if (root == null) {
			System.out.println("Tree is Empty");
			return;
		}
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryNode presentNode = q.poll();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeftChild() != null) {
				q.add(presentNode.getLeftChild());
			}
			if (presentNode.getRightChild() != null) {
				q.add(presentNode.getRightChild());
			}
		}
	}

	public void inOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeftChild());
		System.out.print(node.getValue() + " ");
		inOrder(node.getRightChild());
	}

	public void preOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.getValue());
		preOrder(node.getLeftChild());
		preOrder(node.getRightChild());
	}

	public void postOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.getLeftChild());
		postOrder(node.getRightChild());
		System.out.println(node.getValue());
	}

	public void deleteTree() {
		this.root = null;
		System.out.println("Deleted Tree successfully!");
	}

}
