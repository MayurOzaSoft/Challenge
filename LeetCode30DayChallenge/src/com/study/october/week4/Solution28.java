package com.study.october.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * Summary Ranges
 * <p>
 * You are given a sorted unique integer array nums.
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b
 * "a" if a == b
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * <p>
 * Example 3:
 * <p>
 * Input: nums = []
 * Output: []
 * <p>
 * Example 4:
 * <p>
 * Input: nums = [-1]
 * Output: ["-1"]
 * <p>
 * Example 5:
 * <p>
 * Input: nums = [0]
 * Output: ["0"]
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * All the values of nums are unique.
 */
public class Solution28 {
    public List<String> summaryRanges_9ms(int[] nums) {
        List<String> summary = new ArrayList<>();

        for (int i, j = 0; j < nums.length; j++) {
            i = j;

            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                j++;

            if (i == j) summary.add(nums[i] + "");
            else summary.add(nums[i] + "->" + nums[j]);
        }

        return summary;
    }

    public List<String> summaryRanges_0ms(int[] nums) {
        List<String> list = new ArrayList<>();

        if (null == nums || nums.length == 0)
            return list;

        boolean arrowInserted = false;
        int prev = nums[0];

        StringBuilder str = new StringBuilder();
        str.append(prev);

        for (int i = 1; i < nums.length; i++) {

            if (prev + 1 == nums[i]) {
                if (!arrowInserted) {
                    str.append("->");
                    arrowInserted = true;
                }
            } else {
                if (arrowInserted)
                    str.append(prev);

                list.add(str.toString());

                str = new StringBuilder();
                str.append(nums[i]);

                arrowInserted = false;
            }
            prev = nums[i];
        }

        if (arrowInserted)
            str.append(prev);

        list.add(str.toString());

        return list;
    }
}
