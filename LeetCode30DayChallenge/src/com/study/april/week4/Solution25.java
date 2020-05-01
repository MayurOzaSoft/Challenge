package com.study.april.week4;

/**
 * Jump Game
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example :
 * 
 * Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0
 * to 1, then 3 steps to the last index.
 *
 * @author mayur.p.ozardekar
 *
 */
public class Solution25 {

	public boolean canJump(int[] nums) {

		int max_range = 0;

		for (int i = 0; i < nums.length; i++) {
			int jump = nums[i] + i;
			if (max_range < jump)
				max_range = jump;
			if (max_range == i)
				break;
		}

		return max_range >= nums.length - 1;

	}

}
