package com.study.september.week4;

import java.util.Arrays;

/**
 * Largest Number
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 *
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 */
public class Solution25 {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        for(int i = 0; i < nums.length; i ++){
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (a + b).compareTo(b + a));

        StringBuilder sb = new StringBuilder();

        for (String str : arr) {
            sb.append(str);
        }

        if(sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}
