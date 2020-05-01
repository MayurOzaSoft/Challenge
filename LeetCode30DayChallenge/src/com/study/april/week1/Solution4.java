package com.study.april.week1;

/**
 * Move Zeroes
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution4 {

	public void moveZeroes(int[] nums) {

		int pointer_fast = 0;
		int pointer_slow = 0;

		while (pointer_fast < nums.length) {

			if (nums[pointer_fast] != 0) {
				int temp = nums[pointer_slow];
				nums[pointer_slow] = nums[pointer_fast];
				nums[pointer_fast] = temp;

				pointer_slow++;
			}

			pointer_fast++;

		}

	}

}
