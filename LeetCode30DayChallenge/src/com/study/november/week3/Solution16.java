package com.study.november.week3;

/**
 * Longest Mountain in Array
 *
 * You may recall that an array arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * Example 2:
 *
 * Input: arr = [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 *
 *
 * Follow up:
 *
 * Can you solve it using only one pass?
 * Can you solve it in O(1) space?
 *
 */
public class Solution16 {
    public int longestMountain(int[] A) {
        if(A == null || A.length < 3) return 0;

        int maxResult = 0;

        for(int i = 1; i < A.length; i ++){
            int left = 0;
            int right = 0;

            for(int j = i; j > 0; j --)
                if(A[j] > A[j - 1]) left ++;
                else break;

            for(int j = i; j < A.length - 1; j ++)
                if(A[j] > A[j + 1]) right ++;
                else break;

            if(left != 0 && right != 0)
                maxResult = Math.max(maxResult, left + right + 1);

        }

        return maxResult;
    }
}
