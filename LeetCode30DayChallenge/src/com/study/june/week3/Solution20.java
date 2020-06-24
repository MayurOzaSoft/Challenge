package com.study.june.week3;

import java.util.ArrayList;

/**
 * Permutation Sequence
 * 
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note:
 * 
 * Given n will be between 1 and 9 inclusive. Given k will be between 1 and n!
 * inclusive.
 * 
 * Input: n = 3, k = 3 Output: "213"
 * 
 * Input: n = 4, k = 9 Output: "2314"
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution20 {
	public String getPermutation(int n, int k) {
		// initialize all numbers
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}

		// change k to be index
		k--;

		// set factorial of n
		int mod = 1;
		for (int i = 1; i <= n; i++) {
			mod = mod * i;
		}

		String result = "";

		// find sequence
		for (int i = 0; i < n; i++) {
			mod = mod / (n - i);
			// find the right number(curIndex) of
			int curIndex = k / mod;
			// update k
			k = k % mod;

			// get number according to curIndex
			result += numberList.get(curIndex);
			// remove from list
			numberList.remove(curIndex);
		}

		return result.toString();
	}

}
