package com.study.may.week1;

/**
 * 
 * Number Complement
 * 
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 * 
 * Input: 5 Output: 2
 * 
 * Explanation:
 * 
 * The binary representation of 5 is 101 (no leading zero bits), and its
 * complement is 010. So you need to output 2.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution4 {
	public int findComplement(int num) {
		int mask = (Integer.highestOneBit(num) << 1) - 1;
		return num ^ mask;
	}

	public int bitwiseComplement(int num) {
		if (num == 0)
			return 1;
		int x = (int) (Math.log(num) / Math.log(2));
		int k = (int) (Math.pow(2, x + 1) - 1);
		
		return k - num; // return num ^ k is also valid
	}
}
