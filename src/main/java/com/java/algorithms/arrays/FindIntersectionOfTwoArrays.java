package com.java.algorithms.arrays;
/*Given two arrays a[] and b[] of size n and n respectively. The task is to find intersection between these two arrays.

Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in union.

Example 1:

Input:
5 3
1 2 3 4 5
1 2 3

Output: 
1 2 3
*/

public class FindIntersectionOfTwoArrays {
	static int c_counter = 0;

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 3, 4, 4};
		int[] b = { 2, 2, 2, 4, 6, 7, 8 };
		int res[]= getIntersectionOfArrays(a, b);
		for(int val:res) {
			System.out.print(val+ " ");
		}
	}

	private static int[] getIntersectionOfArrays(int[] a, int[] b) {
		int len_a = a.length;
		int len_b = b.length;
		
		int min = len_a<len_b?len_a:len_b;
		
		int[] c = new int[min];
		
		int a_counter=0, b_counter=0;
		
		while(a_counter< len_a && b_counter<len_b) {
			if(a[a_counter]<b[b_counter]) {
				a_counter++;
			} else if(b[b_counter]<a[a_counter]) {
				b_counter++;
			} else {
				if(c_counter==0) {
					c[c_counter]=a[a_counter];
					a_counter++;
					b_counter++;
					c_counter++;					
				}
				else if(c[c_counter-1]!=a[a_counter]) {
					c[c_counter]=a[a_counter];
					a_counter++;
					b_counter++;
					c_counter++;					
				}else {
					a_counter++;
					b_counter++;
				}
			}
		}
		
		return c;
	}
}
