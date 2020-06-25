package com.study.june.week4;

import java.util.Arrays;

/**
 * Find the Duplicate Number
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Input: [1,3,4,2,2] Output: 2
 * 
 * Input: [3,1,3,4,2] Output: 3
 * 
 * Note:
 * 
 * You must not modify the array (assume the array is read only).
 * 
 * You must use only constant, O(1) extra space.
 * 
 * Your runtime complexity should be less than O(n2).
 * 
 * There is only one duplicate number in the array, but it could be repeated
 * more than once.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution25 {
	// Find Cycle
	// Find meeting point
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		int find = 0;

		while (find != slow) {
			slow = nums[slow];
			find = nums[find];
		}
		return find;
	}

	public int findDuplicate_n_sort(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				return nums[i];
			}
		}

		return -1;
	}

	// In case only one duplicate Number
	public int findDuplicate_n(int[] nums) {
		int sum = 0;

		for (int i : nums) {
			sum += i;
		}

		int n = nums.length;

		return sum - ((n - 1) * n) / 2;
	}

}
