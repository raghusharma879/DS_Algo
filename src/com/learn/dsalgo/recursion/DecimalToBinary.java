package com.learn.dsalgo.recursion;

public class DecimalToBinary {

	public static void main(String[] args) {
		System.out.println(getBinary(10));

	}
	
	public static int getBinary(int n) {
		if(n==0) {
			return 0;
		}
		return (n%2)+10*getBinary(n/2);
	}

}
