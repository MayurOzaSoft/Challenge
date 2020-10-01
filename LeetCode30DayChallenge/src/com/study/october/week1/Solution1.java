package com.study.october.week1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Number of Recent Calls
 *
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
 *
 * Implement the RecentCounter class:
 *
 * RecentCounter() Initializes the counter with zero recent requests.
 * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
 * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
 *
 * Example 1:
 *
 * Input
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 *
 * Output
 * [null, 1, 2, 3, 3]
 *
 * Explanation
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
 * recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
 *
 * Constraints:
 *
 * 1 <= t <= 104
 * Each test case will call ping with strictly increasing values of t.
 * At most 104 calls will be made to ping.
 *
 */
public class Solution1 {
    class RecentCounter1 {
        Queue<Integer> queue;
        public RecentCounter1() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            while(queue.size() > 0 && queue.peek() < t - 3000) queue.poll();
            return queue.size();
        }
    }

    class RecentCounter2 {
        LinkedList<Integer> resultCounter;
        public RecentCounter2() {
            resultCounter = new LinkedList<>();
        }

        public int ping(int t) {
            resultCounter.addLast(t);

            while(resultCounter.size() > 0){
                if(resultCounter.getFirst() < t - 3000) resultCounter.removeFirst();
                else break;
            }

            return resultCounter.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
