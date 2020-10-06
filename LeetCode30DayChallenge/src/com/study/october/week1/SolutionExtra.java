package com.study.october.week1;

import java.util.List;

/**
 * Maximum Distance in Arrays
 * You are given m arrays, where each array is sorted in ascending order.
 * Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance.
 * We define the distance between two integers a and b to be their absolute difference |a - b|.
 * Your task is to find the maximum distance.
 *
 * Example 1:
 *
 * Input: arrays = [[1,2,3],[4,5],[1,2,3]]
 * Output: 4
 * Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 *
 * Example 2:
 *
 * Input: arrays = [[1],[1]]
 * Output: 0
 *
 * Example 3:
 *
 * Input: arrays = [[1],[2]]
 * Output: 1
 *
 * Example 4:
 *
 * Input: arrays = [[1,4],[0,5]]
 * Output: 4
 *
 * Constraints:
 *
 * m == arrays.length
 * 2 <= m <= 104
 * 1 <= arrays[i].length <= 500
 * -104 <= arrays[i][j] <= 104
 * arrays[i] is sorted in ascending order.
 * There will be at most 105 integers in all the arrays.
 *
 */
public class SolutionExtra {
    public int maxDistance_n2(List<List<Integer>> list) {
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                res =
                        Math.max(res, Math.abs(list.get(i).get(0) - list.get(j).get(list.get(j).size() - 1)));
                res =
                        Math.max(res, Math.abs(list.get(j).get(0) - list.get(i).get(list.get(i).size() - 1)));
            }
        }
        return res;
    }

    public int maxDistance_n(List<List<Integer>> list){

        int result = 0, max_value = list.get(0).get(list.get(0).size() - 1), min_value = list.get(0).get(0);


        for(int i = 1; i < list.size(); i ++){
            int currentMax_1 = Math.abs(list.get(i).get(list.get(i).size() - 1) - min_value);
            int currentMax_2 = Math.abs(max_value - list.get(i).get(0));

            int maxTemp = Math.max(currentMax_1, currentMax_2);

            result = Math.max(result, maxTemp);

            min_value = Math.min(min_value, list.get(i).get(0));
            max_value = Math.max(max_value, list.get(i).get(list.get(i).size() - 1));
        }

        return result;
    }

    public int maxDistance_1ms(List<List<Integer>> list){

        int result = 0;
        Integer prevMin = null;
        Integer prevMax = null;

        for (List<Integer> array : list) {
            int currentMin = Integer.MAX_VALUE;
            int currentMax = Integer.MIN_VALUE;

            for (int num : array) {
                currentMin = Math.min(currentMin, num);
                currentMax = Math.max(currentMax, num);
            }

            if (prevMin != null) result = Math.max(result, Math.abs(currentMax - prevMin));
            if (prevMax != null) result = Math.max(result, Math.abs(prevMax - currentMin));

            if (prevMin == null || currentMin < prevMin) prevMin = currentMin;
            if (prevMax == null || currentMax > prevMax) prevMax = currentMax;
        }

        return result;
    }

    public int maxDistance_2ms(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int ans = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int curMin = array.get(0);
            int curMax = array.get(array.size() - 1);

            ans = Math.max(ans, curMax - min);
            ans = Math.max(ans, max - curMin);

            min = Math.min(curMin, min);
            max = Math.max(curMax, max);
        }

        return ans;
    }
}
