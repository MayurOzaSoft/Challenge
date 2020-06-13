package com.study.june.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Largest Divisible Subset
 * 
 * Given a set of distinct positive integers, find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies:
 * 
 * Si % Sj = 0 or Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Input: [1,2,3] Output: [1,2] (of course, [1,3] will also be ok)
 * 
 * Input: [1,2,4,8] Output: [1,2,4,8]
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution13 {

	public List<Integer> largestDivisibleSubset(int[] arr) {

		List<Integer> result = new ArrayList<>();

		if (arr.length == 0)
			return result;

		Arrays.sort(arr);

		// array that maintains the maximum index
		// till which the condition is satisfied
		int divCount[] = new int[arr.length];

		// we will always have atleast one
		// element divisible by itself
		Arrays.fill(divCount, 1);

		// maintain the index of the last increment
		int prev[] = new int[arr.length];
		Arrays.fill(prev, -1);

		// index at which last increment happened
		int max_ind = 0;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {

				// only increment the maximum index if
				// this iteration will increase it
				if (arr[i] % arr[j] == 0 && divCount[i] < divCount[j] + 1) {
					prev[i] = j;
					divCount[i] = divCount[j] + 1;

				}

			}
			// Update last index of largest subset if size
			// of current subset is more.
			if (divCount[i] > divCount[max_ind])
				max_ind = i;
		}

		// Print result
		int k = max_ind;
		while (k >= 0) {
			result.add(arr[k]);
			k = prev[k];
		}

		return result;
	}

}
