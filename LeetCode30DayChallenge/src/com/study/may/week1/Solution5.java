package com.study.may.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * First Unique Character in a String
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Example :
 * 
 * s = "leetcode" return 0.
 * 
 * s = "loveleetcode", return 2.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution5 {

	public int firstUniqChar_22ms(String s) {

		if (s == null || s.length() == 0)
			return -1;

		Map<Character, Integer> mapChars = new HashMap<>();

		for (char ch : s.toCharArray()) {
			mapChars.put(ch, mapChars.getOrDefault(ch, 0) + 1);
		}

		for (char ch : s.toCharArray()) {
			if (mapChars.get(ch) == 1) {
				return s.indexOf(ch);
			}
		}

		return -1;
	}

	public int firstUniqChar_5ms(String s) {

		if (s == null || s.length() == 0)
			return -1;
		if (s.length() == 1)
			return 0;

		int[] result = new int[26];

		for (char ch : s.toCharArray()) {
			result[ch - 'a']++;
		}

		int index = 0;

		for (char ch : s.toCharArray()) {
			if (result[ch - 'a'] == 1)
				return index;
			index++;
		}

		return -1;
	}

	public int firstUniqChar_1ms(String s) {

		int res = Integer.MAX_VALUE;

		for (char c = 'a'; c <= 'z'; c++) {
			int index = s.indexOf(c);

			if (index != -1 && index == s.lastIndexOf(c))
				res = Math.min(res, index);
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}

}
