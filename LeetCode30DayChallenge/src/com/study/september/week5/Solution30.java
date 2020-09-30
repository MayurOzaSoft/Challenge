package com.study.september.week5;

/**
 * First Missing Positive
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 *
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Follow up:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 */
public class Solution30 {
    public int firstMissingPositive(int[] A) {

        int n = A.length;

        for (int i = 0; i < n; i++) {

            while (A[i] != i + 1) {
                if (A[i] <= 0 || A[i] >= n)
                    break;

                if(A[i] == A[A[i]-1])
                    break;

                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;

            }

        }

        for (int i = 0; i < n; i++){
            if (A[i] != i + 1){
                return i + 1;
            }
        }

        return n + 1;
    }
}
