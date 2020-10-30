package com.study.october.week5;

/**
 * Maximize Distance to Closest Person
 *
 * You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).
 *
 * There is at least one empty seat, and at least one person sitting.
 *
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 *
 * Return that maximum distance to the closest person.
 *
 * Example 1:
 *
 * Input: seats = [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 *
 * Example 2:
 *
 * Input: seats = [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 *
 * Example 3:
 *
 * Input: seats = [0,1]
 * Output: 1
 *
 * Constraints:
 *
 * 2 <= seats.length <= 2 * 104
 * seats[i] is 0 or 1.
 * At least one seat is empty.
 * At least one seat is occupied.
 *
 */
public class Solution29 {
    public int maxDistToClosest_2ms(int[] seats) {
        int distance = -1, length = seats.length, maxDistance = 0;

        for(int i = 0; i < length; i ++){
            if(seats[i] == 1){
                if(distance == -1)
                    maxDistance = i;
                else
                    maxDistance = Math.max(maxDistance, (i - distance)/2);

                distance = i;
            }
        }

        if(seats[length - 1] == 0)
            maxDistance = Math.max(maxDistance, length - 1 - distance);

        return maxDistance;
    }

    public int maxDistToClosest_1ms(int[] seats) {
        int i = 0;
        int edge = -1;
        int count = 0;
        int middle = 0;

        while(i < seats.length){
            if(seats[i] == 0){
                i++;
                count++;
                if(i == seats.length){
                    edge = Math.max(edge, count);
                }
            }
            else{
                if(edge == -1)
                    edge = count;
                else{
                    middle = Math.max(middle, count);
                }
                count = 0;
                i++;
            }
        }
        return Math.max((middle + 1) / 2, edge);
    }
}
