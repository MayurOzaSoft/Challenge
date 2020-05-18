package com.study.may.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find All Anagrams in a String
 *
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example :
 * 
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * 
 * Explanation:
 * 
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution17 {
	public List<Integer> findAnagrams_slow(String s, String p) {

		List<Integer> result = new ArrayList<>();

		int pLen = p.length();
		int sLen = s.length();

		int[] charPArray = new int[26];

		for (int i = 0; i < pLen; i++)
			charPArray[p.charAt(i) - 'a']++;

		for (int i = 0; i <= sLen - pLen; i++) {
			String newStr = s.substring(i, pLen + i);
			int[] newStrArray = new int[26];

			for (int j = 0; j < pLen; j++)
				newStrArray[newStr.charAt(j) - 'a']++;

			if (Arrays.equals(charPArray, newStrArray))
				result.add(i);

		}

		return result;
	}

	public List<Integer> findAnagrams_13ms(String s, String p) {
		int[] letters = new int[26];

		for (int i = 0; i < p.length(); i++) {
			letters[p.charAt(i) - 'a']++;
		}

		int j = 0;
		int rem = p.length();
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {

			while (j < s.length() && j - i < p.length()) {
				if (letters[s.charAt(j++) - 'a']-- > 0) {
					rem--;
				}
			}

			if (rem == 0 && j - i == p.length())
				result.add(i);

			if (letters[s.charAt(i) - 'a']++ >= 0)
				rem++;
		}

		return result;
	}

	public List<Integer> findAnagrams_6ms(String s, String p) {

		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;

		int[] counter = new int[26];
		for (int i = 0; i < p.length(); i++) {
			counter[p.charAt(i) - 'a']++;
		}

		int left = 0, right = 0;
		int count = p.length(); // to count if all chars found in p

		while (right < s.length()) {
			if (counter[s.charAt(right++) - 'a']-- >= 1)
				count--;
			if (count == 0)
				list.add(left);
			if (right - left == p.length() && ++counter[s.charAt(left++) - 'a'] > 0)
				count++;
		}

		return list;
	}

}
