package com.java.algorithms.arrays;

/*Given two arrays a[] and b[] of size n and n respectively. The task is to find union between these two arrays.

Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in union.

Example 1:

Input:
5 3
1 2 3 4 5
1 2 3

Output: 
1 2 3 4 5
*/
public class FindUnionOfTwoArrays {
	static int c_counter = 0;

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 1, 1, 2, 2, 9 };

		for (int val : returnUnionOfArrays(a, b)) {
			System.out.print(val);
		}
	}

	private static int[] returnUnionOfArrays(int[] a, int[] b) {
		int len_a = a.length;
		int len_b = b.length;
		// find max number
		int max = a[len_a - 1] > b[len_b - 1] ? a[len_a - 1] : b[len_b - 1];

		// creating new array with length max+1 as this is a sorted array
		int[] c = new int[max + 1];

		int a_counter = 0, b_counter = 0;

		while (a_counter < len_a && b_counter < len_b) {
			if (a[a_counter] < b[b_counter]) {
				enterValueInArray(c, a[a_counter]);
				a_counter++;
			} else if (a[a_counter] > b[b_counter]) {
				enterValueInArray(c, b[b_counter]);
				b_counter++;
			} else {
				enterValueInArray(c, a[a_counter]);
				a_counter++;
				b_counter++;
			}
		}

		// once all elements in one of the arrays is exhausted, enter rest of the
		// elements from other array
		if (a_counter < len_a) {
			for (int i = a_counter; i < len_a; i++) {
				enterValueInArray(c, a[i]);
			}
		}
		if (b_counter < len_b) {
			for (int i = b_counter; i < len_b; i++) {
				enterValueInArray(c, b[i]);
			}
		}
		return c;

	}

	private static void enterValueInArray(int[] c, int val) {
		if (c_counter == 0) {
			c[c_counter] = val;
			c_counter++;
		} else {
			// check if value is already present is array. If yes, we'll skip entry
			if (c[c_counter - 1] != val) {
				c[c_counter] = val;
				c_counter++;
			}
		}
	}
}
