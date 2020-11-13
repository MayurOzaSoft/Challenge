package com.study.november.week2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Permutations II
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [
 *  [1,1,2],
 *  [1,2,1],
 *  [2,1,1]
 * ]
 *
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 */
public class Solution12 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        returnList.add(new ArrayList<>());

        for (int num : nums) {
            Set<List<Integer>> currentSet = new HashSet<>();
            for (List<Integer> l : returnList) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, num);
                    ArrayList<Integer> temp = new ArrayList<>(l);
                    l.remove(j); // BackTrack - Reset
                    currentSet.add(temp);
                }
            }
            returnList = new ArrayList<>(currentSet);
        }

        return returnList;
    }
}
