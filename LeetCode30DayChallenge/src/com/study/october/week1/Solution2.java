package com.study.october.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 *
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 * Example 4:
 *
 * Input: candidates = [1], target = 1
 * Output: [[1]]
 *
 * Example 5:
 *
 * Input: candidates = [1], target = 2
 * Output: [[1,1]]
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 * 1 <= target <= 500
 *
 */
public class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> combinationList = new ArrayList<>();

        dfs(combinationList, 0, candidates, new ArrayList<>(), target);

        return combinationList;

    }

    public void dfs(List<List<Integer>> combinationList, int index, int[] candidates, List<Integer> current, int target){
        if(target == 0){
            if(current.size() > 0)
                combinationList.add(new ArrayList<>(current));

            return;
        }

        for(int i = index; i < candidates.length; i ++){
            if(target - candidates[i] >= 0){
                current.add(candidates[i]);
                dfs(combinationList, i, candidates, current, target - candidates[i]);
                current.remove(current.size() - 1);
            }
        }
    }
}
