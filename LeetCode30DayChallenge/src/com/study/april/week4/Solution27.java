package com.study.april.week4;

/**
 * Maximal Square
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's 
 * and return its area.
 * 
 * Input: 

	1 0 1 0 0
	1 0 1 1 1
	1 1 1 1 1
	1 0 0 1 0

	Output: 4
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution27 {
	public int maximalSquare(char[][] matrix) {

		if(null == matrix || matrix.length == 0) return 0;

		int[][] dummyArray = new int[matrix.length][matrix[0].length];

		int max = 0;

		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				dummyArray[i][j] = Character.getNumericValue(matrix[i][j]);

				if (i > 0 && j > 0 && Character.getNumericValue(matrix[i][j]) == 1)
				{
					dummyArray[i][j] = getMinimum(dummyArray[i][j - 1], 
							dummyArray[i - 1][j], 
							dummyArray[i - 1][j - 1]) + 1;
				}

				// add size
				if (max < dummyArray[i][j]) {
					max = dummyArray[i][j];
				}
			}
		}

		// return size of largest square matrix
		return max * max;
	}

	public static int getMinimum(int i, int j, int k) {
		return Integer.min(Integer.min(i, j), k);
	}
}
