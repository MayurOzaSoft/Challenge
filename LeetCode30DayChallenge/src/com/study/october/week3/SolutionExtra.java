package com.study.october.week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * Meeting Rooms II
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 *
 */
public class SolutionExtra {
    public int minMeetingRooms_I(int[][] intervals){
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int meetingRooms = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if(priorityQueue.isEmpty()){
                meetingRooms ++;
                priorityQueue.add(interval[1]);
            } else {
                int end = priorityQueue.peek();
                int start = interval[0];

                if(start >= end) {
                    priorityQueue.poll();
                } else {
                    meetingRooms ++;
                }

                priorityQueue.add(interval[1]);
            }
        }

        return meetingRooms;
    }

    public int minMeetingRooms_II(int[][] intervals){
        if(intervals.length == 0) return 0;

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0, endMeeting = 0;

        for(int i = 0; i < intervals.length; i ++){
            if(start[i] < end[endMeeting]){
                rooms ++;
            } else {
                endMeeting ++;
            }
        }

        return rooms;
    }
}
