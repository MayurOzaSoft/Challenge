package com.study.may.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Majority Element
 * 
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than [ n/2 ] times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example :
 * 
 * Input: [3,2,3] Output: 3
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution6 {

	public int majorityElement_1ms(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public int majorityElement_8ms(int[] nums) {
		int mid = nums.length / 2;

		Map<Integer, Integer> numMap = new HashMap<>();

		for (int num : nums) {
			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
		}

		for (int num : numMap.keySet()) {
			if (numMap.get(num) > mid)
				return num;
		}

		return -1;
	}
	
	public int majorityElement_2ms(int[] nums) {
        Integer candidate = null;
        int count = 0;
        
        for(int num : nums){
            if(count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        
        return candidate;
    }

}
