package com.study.april.week2;

/**
 * Perform String Shifts
 * 
 * 
 * You are given a string s containing lowercase English letters, and a matrix
 * shift, where shift[i] = [direction, amount]:
 * 
 * direction can be 0 (for left shift) or 1 (for right shift). amount is the
 * amount by which string s is to be shifted. A left shift by 1 means remove the
 * first character of s and append it to the end. Similarly, a right shift by 1
 * means remove the last character of s and add it to the beginning. Return the
 * final string after all operations.
 * 
 * Input: s = "abc", shift = [[0,1],[1,2]] Output: "cab"
 * 
 * Explanation:
 * 
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * 
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution9 {

	public String stringShift(String s, int[][] shift) {
		int row = shift.length;

		for (int i = 0; i < row; i++) {

			if (shift[i][0] == 0) {
				// Left Shift
				s = leftShift(s, shift[i][1]);
			} else {
				// Right Shift
				s = rightShift(s, shift[i][1]);
			}
		}

		return s;
	}

	private static String leftShift(String s, int shift) {

		if (shift == 0)
			return s;

		while (shift > 0) {
			char firstChar = s.charAt(0);

			if (shift <= s.length()) {
				s = s.substring(1, s.length());
			} else {
				s = s.substring(1, shift / s.length() - 1);
			}

			s += firstChar;
			shift--;
		}

		return s;
	}

	private static String rightShift(String s, int shift) {

		if (shift == 0)
			return s;

		while (shift > 0) {
			char lastChar = s.charAt(s.length() - 1);

			if (shift <= s.length()) {
				s = s.substring(0, s.length() - 1);
			} else {
				s = s.substring(0, shift / s.length() - 1);
			}

			s = lastChar + s;
			shift--;
		}

		return s;
	}

}
