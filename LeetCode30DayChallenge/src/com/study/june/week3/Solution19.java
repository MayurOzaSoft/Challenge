package com.study.june.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Trie {
	Trie[] children;
	final int startPos;
	final int depth;

	Trie(int startPos, int depth) {
		this.startPos = startPos;
		this.depth = depth;
	}

	boolean isLeaf() {
		return children == null;
	}

	int childIndex(String S, int start) {
		return S.charAt(start + depth) - 'a';
	}

	int add(String S, int start) {
		if (start + depth == S.length())
			return depth;
		if (isLeaf()) {
			children = new Trie[28];
			children[childIndex(S, startPos)] = new Trie(startPos, depth + 1);
		}
		int newIndex = childIndex(S, start);
		Trie child = children[newIndex];
		if (child == null) {
			children[newIndex] = new Trie(start, depth + 1);
			return depth;
		}
		return child.add(S, start);
	}
}

/**
 * Longest Duplicate Substring
 * 
 * Given a string S, consider all duplicated substrings: (contiguous) substrings
 * of S that occur 2 or more times. (The occurrences may overlap.)
 * 
 * Return any duplicated substring that has the longest possible length. (If S
 * does not have a duplicated substring, the answer is "".)
 * 
 * Input: "banana" Output: "ana"
 * 
 * Input: "abcd" Output: ""
 * 
 * @author mayur.p.ozardekar
 *
 */
class Solution19 {

	public String longestDupSubstring(String S) {
		int maxStart = 0, maxLength = 0;
		int length = S.length();
		Trie root = new Trie(0, 0);
		for (int i = 1; i + maxLength < length; ++i) {
			int len = root.add(S, i);
			if (len > maxLength) {
				maxLength = len;
				maxStart = i;
			}
		}
		return S.substring(maxStart, maxStart + maxLength);
	}

	public String longestDupSubstring_LTE(String S) {
		int n = S.length();
		for (int l = n - 1; l > 1; l--) {
			Set<String> set = new HashSet<>();
			for (int i = 0; i < n - l + 1; i++) {
				String sub = S.substring(i, i + l);
				if (set.contains(sub)) {
					return sub;
				} else {
					set.add(sub);
				}
			}
		}

		return "";
	}

	public String longestDupSubstring_348ms(String S) {
		int start = 0;
		int end = S.length() - 1;
		String result = "";
		while (start <= end) {
			int mid = (start + end) / 2;
			String dupSubstring = dupSubstring(S, mid); // check if any dupSubstring of mid size
			if (dupSubstring != null) {
				start = mid + 1;
				result = dupSubstring;
			} else
				end = mid - 1;
		}

		return result;
	}

	private String dupSubstring(String s, int m) {
		int R = 31; // prime
		Map<Long, List<Integer>> map = new HashMap<>();
		// why Map<Long, List<Integer>> ? with this we will keep index of all string of
		// having same hash.

		long patHash = hash(s, m, R);
		map.putIfAbsent(patHash, new ArrayList<>());
		map.get(patHash).add(0);

		// pre-compute R^(m-1) % q for use in removing leading digit
		long RM = 1;
		for (int i = 1; i <= m - 1; i++)
			RM = (R * RM);

		for (int i = m; i < s.length(); i++) {
			// Remove leading digit, add trailing digit, check for match.
			patHash = (patHash - RM * s.charAt(i - m));
			patHash = (patHash * R + s.charAt(i));
			if (map.containsKey(patHash)) {
				for (int index : map.get(patHash))
					if (s.substring(index, index + m).equals(s.substring(i - m + 1, i + 1)))
						return s.substring(i - m + 1, i + 1);
			}
			map.putIfAbsent(patHash, new ArrayList<>());
			map.get(patHash).add(i - m + 1);
		}

		return null;
	}

	private long hash(String s, int m, int R) {
		long h = 0;
		for (int j = 0; j < m; j++)
			h = (R * h + s.charAt(j));
		return h;
	}
}
