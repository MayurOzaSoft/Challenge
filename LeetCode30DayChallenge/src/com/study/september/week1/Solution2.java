package com.study.september.week1;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Contains Duplicate III
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 *
 * Example 3:
 *
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 *
 */
public class Solution2 {

    public boolean containsNearbyAlmostDuplicate_24ms(int[] nums, int k, int t) {

        if(nums == null || nums.length < 2 || k < 0 || t < 0)
            return false;

        TreeSet<Long> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i ++){

            long curr = nums[i];

            long leftBoundary = curr -t;
            long rightBoundary = curr +t+1; //right boundary is exclusive, so +1


            SortedSet<Long> sub = set.subSet(leftBoundary, rightBoundary);

            if(sub.size() > 0)
                return true;

            set.add(curr);

            if(i >= k){ // or if(set.size()>=k+1)
                set.remove((long)nums[i-k]);
            }
        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicate_0ms(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        if(k >= 10000 && t == 0) {
            return false;
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j <= i+k; j++) {
                if(j >= nums.length) {
                    break;
                }
                if((long)nums[i] - (long) nums[j] > (long)Integer.MAX_VALUE ||(long) nums[j] - (long)nums[i] > (long)Integer.MAX_VALUE) {
                    continue;
                }
                if(Math.abs(nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}
