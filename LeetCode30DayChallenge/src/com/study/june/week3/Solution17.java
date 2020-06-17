package com.study.june.week3;

/**
 * Surrounded Regions
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * Input :
 * [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 
 * Output :
 * [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution17 {
	public void solve(char[][] board) {

		int rows = board.length;
		if (rows <= 2)
			return;

		int cols = board[0].length;
		if (cols <= 2)
			return;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (board[row][col] == 'O' && (row == 0 || row == rows - 1 || col == cols - 1 || col == 0)) {
					dfs(board, rows, cols, row, col);
				}
			}
		}

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (board[row][col] == 'O') {
					board[row][col] = 'X';
				} else if (board[row][col] == '#') {
					board[row][col] = 'O';
				}
			}
		}
	}

	private void dfs(char[][] board, int rows, int cols, int row, int col) {

		if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == 'O') {

			board[row][col] = '#';

			// Move RIGHT
			dfs(board, rows, cols, row, col + 1);

			// MOVE LEFT
			dfs(board, rows, cols, row, col - 1);

			// MOVE TOP
			dfs(board, rows, cols, row - 1, col);

			// MOVE BOTTOM
			dfs(board, rows, cols, row + 1, col);

		}

	}
}
