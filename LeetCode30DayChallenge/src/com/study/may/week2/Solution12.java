package com.study.may.week2;

/**
 * Single Element in a Sorted Array
 * 
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * Find this single element that appears only once.
 * 
 * Input: [1,1,2,3,3,4,4,8,8] Output: 2
 * 
 * Input: [3,3,7,7,10,11,11] Output: 10
 * 
 * Note: Your solution should run in O(log n) time and O(1) space.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution12 {

	public int singleNonDuplicate(int[] nums) {
		int num = nums[0];

		for (int i = 1; i < nums.length; i++) {
			num ^= nums[i];
		}

		return num;
	}

	public int singleNonDuplicate_logN(int[] nums) {
		int lo = 0, len = nums.length, hi = len / 2;

		while (lo < hi) {
			int mid = lo + ((hi - lo) >> 1);
			if (nums[2 * mid] == nums[2 * mid + 1]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return nums[2 * lo];

	}

}
