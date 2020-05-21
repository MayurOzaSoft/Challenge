package com.study.may.week3;

/**
 * Count Square Submatrices with All Ones
 * 
 * Given a m * n matrix of ones and zeros, return how many square submatrices
 * have all ones.
 * 
 * Input: matrix = [ [0,1,1,1], [1,1,1,1], [0,1,1,1] ]
 * 
 * Output: 15
 * 
 * Explanation:
 * 
 * There are 10 squares of side 1.
 * 
 * There are 4 squares of side 2.
 * 
 * There is 1 square of side 3.
 * 
 * Total number of squares = 10 + 4 + 1 = 15.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution21 {

	public int countSquares_7ms(int[][] matrix) {

		int rows = matrix.length;
		int cols = matrix[0].length;
		int[] dp = new int[matrix[0].length];

		int subMatrixCount = 0;
		int topLeft = 0;

		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {

				if (matrix[row][col] == 1) {

					int top = row == 0 ? 0 : dp[col];
					int left = col == 0 ? 0 : dp[col - 1];

					dp[col] = 1 + Integer.min(Integer.min(left, top), topLeft);

					subMatrixCount += dp[col];

					topLeft = (col == cols - 1) ? 0 : top;

				} else
					dp[col] = 0;

			}
		}

		return subMatrixCount;

	}

	public int countSquares_4ms(int[][] matrix) {

		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] dp = new int[rows][cols];

		for (int i = 0; i < rows; ++i) {
			dp[i][0] = matrix[i][0] == 1 ? 1 : 0;
		}

		for (int i = 0; i < cols; ++i) {
			dp[0][i] = matrix[0][i] == 1 ? 1 : 0;
		}

		for (int row = 1; row < rows; ++row) {
			for (int col = 1; col < cols; ++col) {

				if (matrix[row][col] == 1) {
					int min = 1 + Integer.min(Integer.min(dp[row][col - 1], dp[row - 1][col]), dp[row - 1][col - 1]);

					dp[row][col] = min;
				}

			}
		}

		int subMatrixCount = 0;
		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				subMatrixCount += dp[row][col];
			}
		}

		return subMatrixCount;

	}

}
