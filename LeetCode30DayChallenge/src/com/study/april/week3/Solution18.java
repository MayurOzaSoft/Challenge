package com.study.april.week3;

/**
 * Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * 	Input:
 * 
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	Output: 7
	Explanation: Because the path 1 - 3 - 1 - 1 - 1 minimizes the sum.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution18 {
	
	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];
        
        for(int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] + grid[0][j - 1];
        }
        
        
        dp[0] = Integer.MAX_VALUE;
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j - 1];
            }
        }
        
        return dp[n];
    }

}
