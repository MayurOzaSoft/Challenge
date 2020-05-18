package com.study.may.week3;

import java.util.Arrays;

/**
 * Permutation in String
 * 
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's permutations
 * is the substring of the second string.
 * 
 * Example :
 * 
 * Input: s1 = "ab" s2 = "eidbaooo"
 * 
 * Output: True Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * Note:
 * 
 * The input strings only contain lower case letters.
 * 
 * The length of both given strings is in range [1, 10,000].
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution18 {
	public boolean checkInclusion_n(String s1, String s2) {
		s1 = sort(s1);
		for (int i = 0; i <= s2.length() - s1.length(); i++)
			if (s1.equals(sort(s2.substring(i, i + s1.length()))))
				return true;

		return false;
	}

	private String sort(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public boolean checkInclusion_n2(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int[] s1map = new int[26];
		for (int i = 0; i < s1.length(); i++)
			s1map[s1.charAt(i) - 'a']++;
		for (int i = 0; i <= s2.length() - s1.length(); i++) {
			int[] s2map = new int[26];
			for (int j = 0; j < s1.length(); j++) {
				s2map[s2.charAt(i + j) - 'a']++;
			}
			if (Arrays.equals(s1map, s2map))
				return true;
		}
		return false;
	}

	public boolean checkInclusion(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 > len2)
			return false;

		int[] count = new int[26];
		for (int i = 0; i < len1; i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}
		if (allZero(count))
			return true;

		System.out.println(Arrays.toString(count));

		for (int i = len1; i < len2; i++) {
			count[s2.charAt(i) - 'a']--;
			count[s2.charAt(i - len1) - 'a']++;
			System.out.println(Arrays.toString(count));
			if (allZero(count))
				return true;
		}

		return false;
	}

	private boolean allZero(int[] count) {
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0)
				return false;
		}
		return true;
	}

}
