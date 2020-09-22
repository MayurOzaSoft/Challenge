package com.study.september.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution22 {

    /**
     * Brute Force
     */
    public List<Integer> majorityElement_11ms(int[] nums) {

        int n = nums.length;
        int limit = n/3;

        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            if(entry.getValue() > limit){
                result.add(entry.getKey());
            }
        }

        return result;
    }

    /**
     * Optimised
     */
    public List<Integer> majorityElement_2ms(int[] nums) {

        // 1st Pass
        int count_1 = 0;
        int count_2 = 0;

        Integer candidate_1 = null;
        Integer candidate_2 = null;

        for(int num : nums){
            if(candidate_1 != null && candidate_1 == num){
                count_1 ++;
            } else if(candidate_2 != null && candidate_2 == num){
                count_2 ++;
            } else if(count_1 == 0){
                count_1 ++;
                candidate_1 = num;
            } else if(count_2 == 0){
                count_2 ++;
                candidate_2 = num;
            } else {
                count_1 --;
                count_2 --;
            }
        }

        // 2nd Pass
        List<Integer> result = new ArrayList<>();
        count_1 = 0;
        count_2 = 0;

        for(int num : nums){
            if(candidate_1 == num) count_1 ++;
            if(candidate_2 != null && candidate_2 == num) count_2 ++;
        }

        int limit = nums.length/3;
        if(count_1 > limit) result.add(candidate_1);
        if(count_2 > limit) result.add(candidate_2);

        return result;
    }
}
