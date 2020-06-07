package com.study.june.week1;

/**
 * Coin Change 2
 * 
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that
 * amount. You may assume that you have infinite number of each kind of coin.
 * 
 * Input: amount = 5, coins = [1, 2, 5] Output: 4
 * 
 * Explanation:
 * 
 * there are four ways to make up the amount:
 * 
 * 5=5
 * 
 * 5=2+2+1
 * 
 * 5=2+1+1+1
 * 
 * 5=1+1+1+1+1
 * 
 * Note:
 * 
 * You can assume that
 * 
 * 0 <= amount <= 5000
 * 
 * 1 <= coin <= 5000
 * 
 * the number of coins is less than 500 the answer is guaranteed to fit into
 * signed 32-bit integer
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution7 {

	public int change(int amount, int[] coins) {

		int[] dp = new int[amount + 1];

		dp[0] = 1;

		for (int coin : coins) {
			for (int j = coin; j <= amount; j++)
				dp[j] += dp[j - coin];
		}

		return dp[amount];
	}

	public int change_n(int amount, int[] coins) {

		int rows = coins.length;
		int cols = amount;

		int[][] dp = new int[rows + 1][cols + 1];

		for (int row = 0; row <= rows; row++) {
			for (int col = 0; col <= cols; col++) {
				if (col == 0)
					dp[row][col] = 1;
				else if (row == 0)
					dp[row][col] = 0;
				else
					dp[row][col] = dp[row - 1][col] + (col - coins[row - 1] < 0 ? 0 : dp[row][col - coins[row - 1]]);
			}
		}

		return dp[rows][cols];
	}

}
