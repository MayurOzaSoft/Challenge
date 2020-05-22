package com.study.may.week4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 
 * Sort Characters By Frequency
 * 
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Input: "tree"
 * 
 * Output: "eert"
 * 
 * Explanation:
 * 
 * 'e' appears twice while 'r' and 't' both appear once.
 * 
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution22 {

	public String frequencySort_4ms(String s) {
		int[] counts = new int[128];

		for (char c : s.toCharArray()) {
			counts[c]++;
		}

		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> counts[b] - counts[a]);
		for (int i = 0; i < 128; i++) {
			if (counts[i] != 0) {
				pq.add((char) i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			char c = pq.poll();
			for (int i = 0; i < counts[c]; i++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public String frequencySort_3ms(String s) {

		if (s.isEmpty() || s.length() == 0)
			return s;

		int[] count = new int[128];
		char[] charArray = s.toCharArray();
		int length = s.length();

		for (char ch : charArray) {
			count[ch]++;
		}

		char[] result = new char[length];

		for (int i = 0; i < length;) {
			int index = 0;
			int max = 0;

			for (int j = 0; j < 128; j++) {
				if (count[j] > max) {
					max = count[j];
					index = j;
				}
			}

			while (count[index] > 0) {
				result[i++] = (char) index;
				count[index]--;
			}

		}

		return new String(result);
	}

	public String frequencySort_17ms(String s) {
		Map<Character, Integer> mapOfChar = new HashMap<>();

		for (char ch : s.toCharArray()) {
			mapOfChar.put(ch, mapOfChar.getOrDefault(ch, 0) + 1);
		}

		Map<Character, Integer> sortedByCount = mapOfChar.entrySet().stream()
				.sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		StringBuilder sb = new StringBuilder();

		for (Map.Entry<Character, Integer> entry : sortedByCount.entrySet()) {
			int count = entry.getValue();
			while (count > 0) {
				sb.append(entry.getKey());
				count--;
			}
		}

		return sb.toString();

	}
}
