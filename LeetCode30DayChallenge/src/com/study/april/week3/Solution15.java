package com.study.april.week3;

/**
 * Product of Array Except Self
 * 
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Input: [1,2,3,4] Output: [24,12,8,6]
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution15 {

	public int[] productExceptSelf(int[] nums) {
		int[] numArray = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {

			int multiply = 1;
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					multiply *= nums[j];
				}
			}

			numArray[i] = multiply;
		}

		return numArray;
	}

	public int[] productExceptSelf_n(int[] nums) {
		// Optimized Approach
		int[] res = new int[nums.length];
		for (int i = 0; i < res.length; i++) {
			if (i == 0)
				res[i] = 1;
			else {
				res[i] = res[i - 1] * nums[i - 1];
			}
		}
		int temp = 1;
		for (int i = nums.length - 2; i > -1; i--) {
			temp *= nums[i + 1];
			res[i] = res[i] * temp;
		}
		return res;
	}

}
