package com.study.aug.week4;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;
import java.util.HashMap;

public class Solution27 {
    public int[] findRightInterval(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] < min) min = interval[0];
            if (interval[1] > max) max = interval[1];
        }

        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, -1);

        for (int i = 0; i < intervals.length; i++) {
            bucket[intervals[i][0] - min] = i;
        }

        for (int i = bucket.length - 2; i >= 0; i--) {
            if(bucket[i] == - 1) bucket[i] = bucket[i + 1];
        }

        int[] result = new int[intervals.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = bucket[intervals[i][1] - min];
        }

        return result;
    }

    public int[] findRightInterval_n(int[][] intervals) {
        int[] ans = new int[intervals.length];

        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();

        int N = intervals.length;

        for(int i = 0; i < N; i++)
            map.put(new Pair<>(intervals[i][0], intervals[i][1]), i);

        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for(int i = 0; i < N; i++){
            int index = -1;
            int b = intervals[i][1];

            for(int j = i + 1; j < N; j++){
                if(b <= intervals[j][0]){
                    index = map.get(new Pair<>(intervals[j][0], intervals[j][1]));
                    break;
                }
            }

            ans[map.get(new Pair<>(intervals[i][0], b))] = index;
        }

        return ans;
    }
}
