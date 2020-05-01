package com.study.april.week1;

import java.util.HashSet;

/**
 * Counting Elements
 *
 * 
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * 
 * If there're duplicates in arr, count them seperately.
 *
 * 
 * Input: arr = [1,2,3] Output: 2
 * 
 * Explanation:
 * 
 * 1 and 2 are counted cause 2 and 3 are in arr.
 * 
 * Input: arr = [1,1,3,3,5,5,7,7] Output: 0
 * 
 * Explanation:
 * 
 * No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 1000
 * 
 * 0 <= arr[i] <= 1000
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution7 {

	public int countElements(int[] arr) {
		HashSet<Integer> numberSet = new HashSet<>();
		int addCounter = 0;

		for (int i = 0; i < arr.length; i++) {
			if (!numberSet.contains(arr[i])) {
				numberSet.add(arr[i]);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (numberSet.contains(arr[i] + 1)) {
				addCounter++;
			}
		}

		return addCounter;
	}

}
