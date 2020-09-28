package com.study.september.week4;

/**
 * Subarray Product Less Than K
 *
 * Your are given an array of positive integers nums.
 *
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 *
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 *
 * Output: 8
 *
 * Explanation:
 *
 * The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Note:
 *
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 *
 */
public class Solution28 {

    /**
     * TC >> O(N)
     * SC >> O(1)
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        if(k <= 1) return 0;

        int left = 0, right = 0, prod = 1, length = nums.length, count = 0;

        while (right < length){
            prod *= nums[right];

            while (prod >= k) prod /= nums[left ++];

            count += right - left + 1;

            right ++;
        }

        return count;
    }

    /**
     * TC >> O(N^2)
     * SC >> O(1)
     *
     */
    public static int numSubarrayProductLessThanK_n2(int[] nums, int k) {
        int count = 0;

        for(int i = 0; i < nums.length; i ++){
            if(nums[i] < k) count ++;
            int product = nums[i];
            for(int j = i + 1; j <  nums.length; j ++){
                product *= nums[j];
                if(product < k) count ++;
                else break;
            }
        }

        return count;
    }
}
