package com.study.april.week1;

/**
 * Maximum Subarray
 * 
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6
 * 
 * Explanation:
 * 
 * [4,-1,2,1] has the largest sum = 6.
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution3 {

	public int maxSubArray(int[] nums) {
		int max_sum = nums[0];
		int current_sum = max_sum;

		for (int i = 1; i < nums.length; i++) {
			current_sum = Math.max(nums[i] + current_sum, nums[i]);
			max_sum = Math.max(current_sum, max_sum);
		}

		return max_sum;
	}

}
