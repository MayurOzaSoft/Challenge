package com.study.september.week3;

/**
 * Robot Bounded In Circle
 *
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:
 *
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degress to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 *
 * Example 1:
 *
 * Input: "GGLLGG"
 * Output: true
 *
 * Explanation:
 * The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
 * When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
 *
 * Example 2:
 *
 * Input: "GG"
 * Output: false
 * Explanation:
 * The robot moves north indefinitely.
 *
 * Example 3:
 *
 * Input: "GL"
 * Output: true
 * Explanation:
 * The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 *
 *
 * Note:
 *
 * 1 <= instructions.length <= 100
 * instructions[i] is in {'G', 'L', 'R'}
 *
 */
public class Solution17 {

    public boolean isRobotBounded(String instructions) {

        int x = 0, y = 0, direction = 0;

        // north: 0, east: 1, south: 2, west: 3;
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);

            if (c == 'L') direction = Math.floorMod(--direction, 4);
            if (c == 'R') direction = Math.floorMod(++direction, 4);
            if (c == 'G') {
                if (direction == 0) y++;
                if (direction == 1) x++;
                if (direction == 2) y--;
                if (direction == 3) x--;
            }

        }

        return direction != 0 || (x == 0 && y == 0);


        /*int x = 0, y = 0, direction = 0;
        for (int i = 0; i < instructions.length(); i++) { {
            switch (instructions.charAt(i)) {
                case 'L': direction = (direction + 1) % 4; break;
                case 'R': direction = (direction + 3) % 4; break;
                case 'G':
                    switch (direction) {
                        case 0: y++; break;
                        case 1: x--; break;
                        case 2: y--; break;
                        case 3: x++; break;
                    } break;
            }
        }
        return direction != 0 || (x == 0 && y == 0);*/
    }
}
