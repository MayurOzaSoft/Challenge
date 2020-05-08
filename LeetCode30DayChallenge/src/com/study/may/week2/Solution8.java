package com.study.may.week2;

/**
 * Check If It Is a Straight Line
 * 
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 * represents the coordinate of a point. Check if these points make a straight
 * line in the XY plane.
 * 
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]] Output: true
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution8 {
	public boolean checkStraightLine(int[][] coordinates) {
		if (coordinates[1][0] == coordinates[0][0])
			return false;

		int rows = coordinates.length;

		// y = mx + b
		int slope = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);

		int yIntercept = coordinates[0][1] - slope * coordinates[0][0];

		for (int row = 2; row < rows; row++)
			if (coordinates[row][1] != slope * coordinates[row][0] + yIntercept)
				return false;

		return true;
	}
}
