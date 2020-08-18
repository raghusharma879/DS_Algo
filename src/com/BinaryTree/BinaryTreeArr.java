package com.BinaryTree;

public class BinaryTreeArr {
	private int arr[];
	private int lastUsedIndex;

	public BinaryTreeArr(int size) {
		this.arr = new int[size + 1];
		this.lastUsedIndex = 0;
	}

	public void insert(int value) {
		if (arr.length - 1 > lastUsedIndex) {
			arr[++lastUsedIndex] = value;
		} else {
			System.out.println("Insertion Failed! tree capacity full");
		}
	}

	public int search(int value) {
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (arr[i] == value) {
				System.out.println("Success! value found at index " + i);
				return i;
			}
		}
		System.out.println("Failure! Value not found");
		return -1;
	}

	public void delete(int value) {
		int valueIndex = search(value);
		if (valueIndex == -1) {
			System.out.println("Failure! Value not present in tree");
			return;
		}
		arr[valueIndex] = arr[lastUsedIndex];
		lastUsedIndex--;
	}

	public void inOrder(int index) {
		if(arr==null) {
			System.out.println("Faiure! Tree is empty");
			return;
		}
		if (index > lastUsedIndex) {
			return;
		}
		inOrder(index * 2);
		System.out.print(arr[index]+" ");
		inOrder((index * 2) + 1);
	}

	public void preOrder(int index) {
		if(arr==null) {
			System.out.println("Faiure! Tree is empty");
			return;
		}
		if (index > lastUsedIndex) {
			return;
		}
		System.out.print(arr[index]+" ");
		inOrder(index * 2);
		inOrder((index * 2) + 1);
	}

	public void postOrder(int index) {
		if(arr==null) {
			System.out.println("Faiure! Tree is empty");
			return;
		}
		if (index > lastUsedIndex) {
			return;
		}
		inOrder(index * 2);
		inOrder((index * 2) + 1);
		System.out.print(arr[index]+" ");
	}

	public void levelOrder(int index) {
		if(arr==null) {
			System.out.println("Faiure! Tree is empty");
			return;
		}
		for (int i = 1; i <= lastUsedIndex; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public void deleteTree() {
		try {
			arr = null;
			System.out.println("Success! Tree deleted successfully");
		} catch (Exception e) {
			System.out.println("Error! Something went wrong, Tree deletion failed");
		}
	}

}
