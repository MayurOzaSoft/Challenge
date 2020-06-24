package com.study.june.week4;

/**
 * Single Number II
 * 
 * Given a non-empty array of integers, every element appears three times except
 * for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Input: [2,2,3,2] Output: 3
 * 
 * Input: [0,1,0,1,0,1,99] Output: 99
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution22 {
	public int singleNumber(int[] nums) {
		int one = 0, two = 0;

		for (int i = 0; i < nums.length; i++) {
			one = (one ^ nums[i]) & ~two;
			two = (two ^ nums[i]) & ~one;
		}

		return one;
	}
}
