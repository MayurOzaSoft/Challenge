package com.study.september.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Insert Interval
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 */
public class Solution13 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];

        for (int[] rows : intervals) {
            if (rows[1] < newInterval[0]) {
                result.add(rows);
            } else if (rows[0] > newInterval[1]) {
                result.add(rows);
            } else {
                start = Math.min(start, rows[0]);
                end = Math.max(end, rows[1]);
            }
        }

        result.add(new int[]{start, end});

        int[][] resultArray = result.toArray(new int[0][0]);
        Arrays.sort(resultArray, Comparator.comparingInt(a -> a[0]));

        return resultArray;

    }
}
