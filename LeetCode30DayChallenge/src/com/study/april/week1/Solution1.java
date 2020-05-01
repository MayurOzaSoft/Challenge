package com.study.april.week1;

/**
 * Single Number
 * 
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Input: [2,2,1] Output: 1
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution1 {

	public int singleNumber(int[] nums) {

		int singleNumber = 0;

		for (int i = 0; i < nums.length; i++) {
			singleNumber ^= nums[i];
		}

		return singleNumber;
	}

}
