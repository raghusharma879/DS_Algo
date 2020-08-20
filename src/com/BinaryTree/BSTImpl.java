package com.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTImpl {
	private BinaryNode root;

	public BSTImpl() {
		this.root = null;
	}
	
	public void insert(int value) {
		root = insert(root, value);
	}
	
	private BinaryNode insert(BinaryNode node, int value) {
		if(node == null) {
			return new BinaryNode(value);
		}else if(value<node.getValue()){
			node.setLeftChild(insert(node.getLeftChild(),value));
		}else {
			node.setRightChild(insert(node.getRightChild(),value));
		}
		return node;
	}
	
	public void delete(int value) {
		delete(root,value);
	}
	
	private BinaryNode delete(BinaryNode node,int value) {
		if(node==null) {
			return null;
		}
		if(value<node.getValue()) {
			node.setLeftChild(delete(node.getLeftChild(),value));
		}else if(value>node.getValue()) {
			node.setRightChild(delete(node.getRightChild(),value));
		}else {
			if(node.getLeftChild()!=null && node.getRightChild()!=null) {
				node.setValue(getMinimumElement(node.getRightChild()).getValue());
				root.setRightChild(delete(node.getRightChild(),node.getValue()));
			}else if(node.getLeftChild()!=null) {
				node=node.getLeftChild();
			}else if(node.getRightChild()!=null) {
				node = node.getRightChild();
			}else
				node = null;
		}
		return node;
	}
	
	public BinaryNode getMinimumElement(BinaryNode node) {
		if(node==null) {
			return node;
		}else {
			return getMinimumElement(node.getLeftChild());
		}
		
	}
	public void levelOrder() {
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryNode currNode = q.poll();
			if (currNode != null) {
				System.out.print(currNode.getValue() + " ");
				if (currNode.getLeftChild() != null) {
					q.add(currNode.getLeftChild());
				}
				if (currNode.getRightChild() != null) {
					q.add(currNode.getRightChild());
				}
			}
		}
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(BinaryNode node) {
		if(node==null) {
			return;
		}
		inOrder(node.getLeftChild());
		System.out.print(node.getValue()+" ");
		inOrder(node.getRightChild());
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.getValue()+" ");
		preOrder(node.getLeftChild());
		preOrder(node.getRightChild());
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		postOrder(node.getLeftChild());
		postOrder(node.getRightChild());
		System.out.print(node.getValue()+" ");
	}
	
}
