package com.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

	public void inOrderRecursive(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrderRecursive(node.getLeftChild());
		System.out.print(node.getValue() + " ");
		inOrderRecursive(node.getRightChild());
	}
	
	public void inOrder() {
		Stack<BinaryNode> s = new Stack<>();
		BinaryNode currentNode = root;
		while(currentNode!=null || s.size()>0) {
			while(currentNode!=null) {
				s.push(currentNode);
				currentNode = currentNode.getLeftChild();
			} 
			
			currentNode = s.pop();
			System.out.print(currentNode.getValue()+" ");
			currentNode = currentNode.getRightChild();
		}
	}
	
	public void inOrder2() {
		Stack<BinaryNode> s = new Stack<>();
		BinaryNode leftTemp = root;
		BinaryNode rightTemp = root;
		
		while(rightTemp!=null) {
			s.push(rightTemp.getRightChild());
			rightTemp=rightTemp.getRightChild();
		}
		s.push(root);
		while(leftTemp!=null) {
			s.push(leftTemp.getLeftChild());
			leftTemp=leftTemp.getLeftChild();
		}
		while(s.size()>0) {
			BinaryNode node = s.pop();
			if(node!=null)
				System.out.print(node.getValue()+" ");
		}
		
	}
	
	

	public void preOrderRecursive(BinaryNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.getValue());
		preOrderRecursive(node.getLeftChild());
		preOrderRecursive(node.getRightChild());
	}

	public void preOrder() {
		Stack<BinaryNode> s = new Stack<>();
		s.push(root);
		while(s.size()>0) {
			BinaryNode temp = s.pop();
			if(temp !=null)
			System.out.print(temp.getValue());
			if(temp!=null) {
				s.push(temp.getRightChild());
				s.push(temp.getLeftChild());
			}
			
		}
	}
	public void postOrderRecursive(BinaryNode node) {
		if (node == null) {
			return;
		}
		postOrderRecursive(node.getLeftChild());
		postOrderRecursive(node.getRightChild());
		System.out.println(node.getValue());
	}
	
	public void postOrder() {
		Stack<BinaryNode> s = new Stack<>();
		BinaryNode rightTemp = root;
		BinaryNode leftTemp = root;
		while(rightTemp!=null) {
			s.push(rightTemp.getRightChild());
			rightTemp=rightTemp.getRightChild();
		}
		while(leftTemp!=null) {
			s.push(leftTemp.getLeftChild());
			leftTemp=leftTemp.getLeftChild();
		}
		while(s.size()>0) {
			BinaryNode node = s.pop();
			if(node!=null)
			System.out.print(node.getValue()+" ");
		}
		System.out.print(root.getValue());
	}

	public void deleteTree() {
		this.root = null;
		System.out.println("Deleted Tree successfully!");
	}

}
