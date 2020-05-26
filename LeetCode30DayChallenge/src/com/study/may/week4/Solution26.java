package com.study.may.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * Contiguous Array
 * 
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 * 
 * Input: [0,1] Output: 2
 * 
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0
 * and 1.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution26 {
	public int findMaxLength_n2(int[] nums) {

		if (nums.length == 0)
			return 0;

		int max = 0;

		for (int i = 0; i < nums.length; i++) {

			int zeros = 0;
			int ones = 0;

			if (nums[i] == 0)
				zeros++;
			if (nums[i] == 1)
				ones++;

			for (int j = i + 1; j < nums.length; j++) {

				if (nums[j] == 0)
					zeros++;
				if (nums[j] == 1)
					ones++;

				if (zeros == ones) {
					max = Math.max(max, zeros + ones);
				}
			}

		}

		return max;
	}

	public int findMaxLength(int[] nums) {

		if (nums.length == 0)
			return 0;

		Map<Integer, Integer> lengthMap = new HashMap<>();
		lengthMap.put(0, -1);

		int maxlen = 0, count = 0;

		for (int i = 0; i < nums.length; i++) {
			count = count + (nums[i] == 1 ? 1 : -1);
			if (lengthMap.containsKey(count)) {
				maxlen = Math.max(maxlen, i - lengthMap.get(count));
			} else {
				lengthMap.put(count, i);
			}
		}

		return maxlen;
	}
}
