package com.study.april.week3;

/**
 * Search in Rotated Sorted Array
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution19 {
	
	public int search(int[] nums, int target) {
        if(null == nums || nums.length == 0) return -1;
        if(nums.length == 1) 
            return nums[0] == target ? 0 : -1;
        
        int initial_pointer = 0;
        int end_pointer = nums.length - 1;
        
        while(initial_pointer <= end_pointer){
            if(nums[initial_pointer] == target) return initial_pointer;
            else if(nums[end_pointer] == target) return end_pointer;
            
            initial_pointer ++;
            end_pointer --;
            
        }
        
        return -1;
        
    }

}
