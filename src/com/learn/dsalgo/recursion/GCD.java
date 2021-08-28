package com.learn.dsalgo.recursion;

public class GCD {
	public static void main(String[] args) {
		System.out.println(getGcd(48, 18));
	}

	public static int getGcd(int a, int b) {
		if (a < 0 || b < 0) {
			return -1;
		}
		if (b == 0) {
			return a;
		}
		return getGcd(b, a % b);
	}

}
