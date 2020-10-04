package com.study.october.week1;

import java.util.Arrays;

/**
 * Remove Covered Intervals
 *
 * Given a list of intervals, remove all intervals that are covered by another interval in the list.
 *
 * Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
 *
 * After doing so, return the number of remaining intervals.
 *
 * Example 1:
 *
 * Input: intervals = [[1,4],[3,6],[2,8]]
 * Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 *
 * Example 2:
 *
 * Input: intervals = [[1,4],[2,3]]
 * Output: 1
 *
 * Example 3:
 *
 * Input: intervals = [[0,10],[5,12]]
 * Output: 2
 *
 * Example 4:
 *
 * Input: intervals = [[3,10],[4,10],[5,11]]
 * Output: 2
 *
 * Example 5:
 *
 * Input: intervals = [[1,2],[1,4],[3,4]]
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 1000
 * intervals[i].length == 2
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * All the intervals are unique.
 *
 */
public class Solution4 {
    private static int compare(int[] a, int[] b) {
        if (a[0] > b[0]) {
            return 1;
        } else
            return -1;
    }

    public int removeCoveredIntervals_5ms(int[][] intervals) {
        Arrays.sort(intervals, Solution4::compare);

        int start = 0, end = 1, count = 0;

        while(start < intervals.length && end < intervals.length){
            if(start == end){
                end ++;
                continue;
            }

            if(intervals[start][0] <= intervals[end][0]
                    && intervals[start][1] >= intervals[end][1]){
                count ++;
                end ++;
            } else if(intervals[start][0] <= intervals[end][0]){
                start ++;
            } else if(intervals[start][1] >= intervals[end][1]){
                end ++;
            }
        }

        return intervals.length - count;
    }

    public int removeCoveredIntervals_3ms(int[][] intervals) {
        int count = 0;
        for(int i = 0; i < intervals.length; i ++){
            for(int j = 0; j < intervals.length; j ++){

                if(i == j) continue;

                if(isCovered(intervals[i], intervals[j])) {
                    count ++;
                    break;
                }
            }
        }

        return intervals.length - count;

    }

    public boolean isCovered(int[] a, int[] b){
        return (a[0] >= b[0] && a[1] <= b[1]);
    }
}