package com.study.june.week2;

/**
 * Power of Two
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Input: 1 Output: true
 * 
 * Explanation: 2^0 = 1
 * 
 * Input: 16 Output: true
 * 
 * Explanation: 2^4 = 16
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution8 {

	public boolean isPowerOfTwo(int n) {
		if (n == 0)
			return false;

		while (n != 1) {
			int remainder = n % 2;
			if (remainder != 0)
				return false;
			n = n / 2;
		}

		return true;
	}

}
