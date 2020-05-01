package com.study.april.week4;

/**
 * Bitwise AND of Numbers Range
 * 
 * 
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * Example 1:
 * 
 * Input: [5,7] Output: 4 Example 2:
 * 
 * Input: [0,1] Output: 0
 *
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution23 {
	public int rangeBitwiseAnd(int m, int n) {

		if (m == 0)
			return 0;

		int count = 0;

		while (m != n) {
			m >>= 1;
			n >>= 1;
			count++;
		}

		return m << count;

	}
}
