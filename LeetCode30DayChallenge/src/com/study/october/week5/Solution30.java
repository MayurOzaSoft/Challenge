package com.study.october.week5;

import java.util.Arrays;

/**
 * Number of Longest Increasing Subsequence
 * <p>
 * Given an integer array nums, return the number of longest increasing subsequences.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 2000
 * -106 <= nums[i] <= 106
 */
public class Solution30 {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;

        int[] lengths = new int[N];

        int[] counts = new int[N];
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i)
                if (nums[i] < nums[j]) {
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    } else if (lengths[i] + 1 == lengths[j]) {
                        counts[j] += counts[i];
                    }
                }
        }

        int longest = 0, ans = 0;
        for (int length : lengths) {
            longest = Math.max(longest, length);
        }

        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }

        return ans;
    }
}
