package com.study.april.week2;

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
public class Solution8 {
	
	public int findMaxLength(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return 0; 
        
        int maxLength = 0;
        int[] arr = new int[2*nums.length+1];
        
        for( int i = 0; i < arr.length; i++) arr[i] = -2;
        
        arr[nums.length] = -1;
        int counter = nums.length;
        
        for(int i = 0; i < nums.length; i++){
            counter += nums[i]*2 - 1;
            if(arr[counter] == -2){
                arr[counter] = i;
            }else{
                maxLength = Math.max(maxLength, i - arr[counter]);
            }                
        }
        
        return maxLength;
    }
	
	public int findMaxLength_slow(int[] arr) {
	       
        int n = arr.length;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 

        int sum = 0; // Initialize sum of elements 
        int max_len = 0; // Initialize result 
        int ending_index = -1; 

        for (int i = 0; i < n; i++) { 
            arr[i] = (arr[i] == 0) ? -1 : 1; 
        } 

        // Traverse through the given array  
        for (int i = 0; i < n; i++) { 
            // Add current element to sum 
            sum += arr[i]; 
            // To handle sum = 0 at last index 
            if (sum == 0) { 
                max_len = i + 1; 
                ending_index = i; 
            }

            // If this sum is seen before, then update max_len 
            // if required 
            if (map.containsKey(sum + n)) { 
                if (max_len < i - map.get(sum + n)) { 
                    max_len = i - map.get(sum + n); 
                    ending_index = i; 
                } 
            } 

            else // Else put this sum in hash table 
                map.put(sum + n, i); 

        } 

        for (int i = 0; i < n; i++) { 
            arr[i] = (arr[i] == -1) ? 0 : 1; 
        } 

        @SuppressWarnings("unused")
		int end = ending_index - max_len + 1; 

        return max_len; 

    }
	
	public int findMaxLength_n2(int[] nums) {
        int maxlen = 0;
        for (int start = 0; start < nums.length; start++) {
            int zeroes = 0, ones = 0;
            for (int end = start; end < nums.length; end++) {
                if (nums[end] == 0) {
                    zeroes++;
                } else {
                    ones++;
                }
                if (zeroes == ones) {
                    maxlen = Math.max(maxlen, end - start + 1);
                }
            }
        }
        return maxlen;
    }
	
	public int findMaxLength_n_n(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

}
