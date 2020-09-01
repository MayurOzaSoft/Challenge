package com.study.august.week3;

import java.util.Arrays;
import java.util.Comparator;

public class Solution15 {
    public int eraseOverlapIntervals_1ms(int[][] intervals) {

        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        int count = 0;
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i ++){
            if(end > intervals[i][0]){
                end = Math.min(end, intervals[i][1]);
                count ++;
            } else {
                end = intervals[i][1];
            }
        }

        return count;
    }

    public int eraseOverlapIntervals_0ms(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, new MyComparator());

        int end = intervals[intervals.length - 1][0];
        int count = 1;

        for(int i = intervals.length - 2; i >= 0; i --)
            if(end >= intervals[i][1]){
                end = intervals[i][0];
                count ++;
            }

        return intervals.length - count;
    }

    class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] x, int[] y) {
            return x[0] - y[0];
        }
    }
}
