package com.study.november.week2;

import java.util.HashSet;
import java.util.Set;

/**
 * Valid Square
 *
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
 *
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 *
 * Example:
 *
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 *
 * Note:
 *
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 * Input points have no order.
 *
 */
public class Solution11 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> squareSet = new HashSet<>();
        squareSet.add(addSum(p1, p2));
        squareSet.add(addSum(p2, p3));
        squareSet.add(addSum(p3, p4));
        squareSet.add(addSum(p4, p1));
        squareSet.add(addSum(p1, p3));
        squareSet.add(addSum(p2, p4));

        return !squareSet.contains(0) && squareSet.size() == 2;
    }

    public int addSum(int[] c1, int[] c2){
        return (c2[0] - c1[0]) * (c2[0] - c1[0]) + (c2[1] - c1[1]) * (c2[1] - c1[1]);
    }

}
