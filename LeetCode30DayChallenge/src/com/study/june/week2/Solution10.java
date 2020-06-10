package com.study.june.week2;

import java.util.Arrays;

/**
 * Search Insert Position
 * 
 * 
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Input: [1,3,5,6], 5
 * 
 * Output: 2
 * 
 * Input: [1,3,5,6], 2
 * 
 * Output: 1
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution10 {
	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0 || target == 0)
			return 0;

		int index = Arrays.binarySearch(nums, target);

		if (index >= 0)
			return index;

		int start = 0;
		int end = nums.length;

		int mid = end / 2;

		if (nums[mid] > target)
			end = mid;
		else
			start = mid;

		while (start < end) {
			if (nums[start] > target)
				return start;
			else
				start++;
		}

		return end;
	}
}
