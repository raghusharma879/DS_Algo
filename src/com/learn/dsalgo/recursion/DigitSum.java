package com.learn.dsalgo.recursion;

public class DigitSum {
	
	public static void main(String[] args) {
		System.out.println(getSumOfDigits(-111));
	}
	
	public static int getSumOfDigits(int n) {
		if(n<0) {
			return -1;
		}
		if(n==0) {
			return 0;
		}
		return n%10+getSumOfDigits(n/10);
	}

}
