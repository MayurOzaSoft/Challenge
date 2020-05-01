package com.study.april.week3;

/**
 * Number of Islands
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * 	Input:
 * 
	11110
	11010
	11000
	00000

	Output: 1
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution17 {
	public void dfs(char[][] grid, int row, int col) {
		if (grid[row][col] == '0') {
			return;
		}

		grid[row][col] = '0';

		if (row + 1 < grid.length) {
			dfs(grid, row+1, col);
		}

		if (row - 1 >= 0) {
			dfs(grid, row-1, col);
		}

		if (col + 1 < grid[0].length) {
			dfs(grid, row, col+1);
		}

		if (col - 1 >= 0) {
			dfs(grid, row, col-1);
		}
	}

	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid,i,j);
					count++;
				}
			}
		}
		return count;
	}
}
