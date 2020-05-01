package com.study.april.week4;

/**
 * Longest Common Subsequence
 * 
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative order
 * of the remaining characters. (eg, "ace" is a subsequence of "abcde" while
 * "aec" is not). A common subsequence of two strings is a subsequence that is
 * common to both strings.
 * 
 * If there is no common subsequence, return 0.
 * 
 * Example : Input: text1 = "abcde", text2 = "ace" Output: 3 Explanation: The
 * longest common subsequence is "ace" and its length is 3.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution26 {
	public int longestCommonSubsequence(String text1, String text2) {
		char[] a = text1.toCharArray();
		char[] b = text2.toCharArray();

		int rows = a.length;
		int cols = b.length;

		int[] dp = new int[cols + 1];

		for (int i = 1; i <= rows; i++) {
			int prev = 0;
			for (int j = 1; j <= cols; j++) {
				int tmp = dp[j];
				if (a[i - 1] == b[j - 1])
					dp[j] = prev + 1;
				else
					dp[j] = Math.max(dp[j], dp[j - 1]);
				prev = tmp;
			}
		}

		return dp[cols];
	}
}
