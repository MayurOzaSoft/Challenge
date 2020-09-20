package com.study.september.week3;

/**
 * Unique Paths III
 *
 * On a 2-dimensional grid, there are 4 types of squares:
 *
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 * Example 1:
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 *
 * Example 2:
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 *
 * Example 3:
 *
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation:
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 *
 * Note:
 *
 * 1 <= grid.length * grid[0].length <= 20
 *
 */
public class Solution20 {
    int totalPath = 0;
    public int uniquePathsIII(int[][] grid) {
        int totalZeros = 0;

        // count zeros to track
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 0) totalZeros++;
            }
        }

        // trace path
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1)
                    dfs(grid, i, j, totalZeros);
            }
        }

        return totalPath;
    }

    public void dfs(int[][] grid, int start, int end, int totalZeros){

        // base condition
        if(start < 0 || end < 0
                || start > grid.length - 1
                || end > grid[0].length - 1
                || grid[start][end] == -1
                || (grid[start][end] == 2 && totalZeros != 0)
                || grid[start][end] == 99)
            return;

        // count path
        if(grid[start][end] == 2 && totalZeros == 0) totalPath ++;
        // track zeros
        if(grid[start][end] == 0) totalZeros --;

        // any Temp variable making sure location is traced
        int temp = grid[start][end];
        grid[start][end] = 99;

        // down
        dfs(grid, start + 1, end, totalZeros);
        // up
        dfs(grid, start - 1, end, totalZeros);
        // right
        dfs(grid, start, end + 1, totalZeros);
        // left
        dfs(grid, start, end - 1, totalZeros);

        // backtracking
        grid[start][end] = temp;
    }
}
