package com.study.april.week1;

/**
 * Happy Number
 * 
 * Write an algorithm to determine if a number n is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Return True if n is a happy number, and False if not.
 * 
 * Input: 19 Output: true
 * 
 * Explanation:
 * 
 * 12 + 92 = 82
 * 
 * 82 + 22 = 68
 * 
 * 62 + 82 = 100
 * 
 * 12 + 02 + 02 = 1
 * 
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution2 {

	public boolean isHappy(int n) {

		return isHappyNumber(n, 0);
	}

	static boolean isHappyNumber(int n, int count) {
		if (n == 1)
			return true;
		if (count > 8)
			return false;

		int sum = 0;
		int remainder = 0;

		while (n != 0) {
			remainder = n % 10;
			n /= 10;
			sum += Math.multiplyExact(remainder, remainder);
		}

		count += 1;
		return isHappyNumber(sum, count);
	}

}
