package com.study.may.week5;

/**
 * Edit Distance
 * 
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * 1. Insert a character
 * 
 * 2. Delete a character
 * 
 * 2. Replace a character
 * 
 * Input: word1 = "horse", word2 = "ros"
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * horse -> rorse (replace 'h' with 'r')
 * 
 * rorse -> rose (remove 'r')
 * 
 * rose -> ros (remove 'e')
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution31 {

	public int minDistance_1D(String word1, String word2) {

		if (word1.equals(word2))
			return 0;

		int m = word1.length();
		int n = word2.length();

		int dp[] = new int[n + 1];

		for (int i = 1; i < n + 1; i++)
			dp[i] = i;

		for (int i = 1; i < m + 1; i++) {
			int prev = dp[0];
			dp[0] += 1;

			for (int j = 1; j < n + 1; j++) {
				int temp = dp[j];

				dp[j] = Math.min(Math.min(dp[j - 1] + 1, dp[j] + 1),
						word1.charAt(i - 1) == word2.charAt(j - 1) ? prev : prev + 1);

				prev = temp;
			}
		}

		return dp[n];
	}

	public int minDistance_2D(String word1, String word2) {

		if (word1.equals(word2))
			return 0;

		int m = word1.length();
		int n = word2.length();

		int dp[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++)
			dp[i][0] = i;

		for (int i = 0; i <= n; i++)
			dp[0][i] = i;

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				int val1 = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);

				int val2 = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;

				dp[i][j] = Math.min(val1, val2);
			}
		}

		return dp[m][n];
	}

	char[] w1, w2;
	int[][] memo;

	public int minDistance(String word1, String word2) {
		w1 = word1.toCharArray();
		w2 = word2.toCharArray();

		memo = new int[w1.length][w2.length];

		return findDistance(w1.length - 1, w2.length - 1);
	}

	private int findDistance(int i, int j) {
		if (i < 0)
			return j + 1;
		if (j < 0)
			return i + 1;

		if (memo[i][j] > 0)
			return memo[i][j];

		if (w1[i] == w2[j])
			return memo[i][j] = findDistance(i - 1, j - 1);

		return memo[i][j] = 1
				+ Math.min(Math.min(findDistance(i - 1, j), findDistance(i, j - 1)), findDistance(i - 1, j - 1));
	}

}
