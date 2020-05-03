package com.study.may.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * Example :
 * 
 * canConstruct("a", "b") -> false
 * 
 * canConstruct("aa", "ab") -> false
 * 
 * canConstruct("aa", "aab") -> true
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution3 {

	public boolean canConstruct_17ms(String ransomNote, String magazine) {

		char[] charRansom = ransomNote.toCharArray();
		Map<Character, Integer> mapRansom = new HashMap<>();

		for (Character ch : charRansom) {
			if (!mapRansom.containsKey(ch)) {
				mapRansom.put(ch, 1);
			} else {
				mapRansom.put(ch, mapRansom.get(ch) + 1);
			}
		}

		char[] charMagazine = magazine.toCharArray();
		Map<Character, Integer> mapMagazine = new HashMap<>();

		for (Character ch : charMagazine) {
			if (!mapMagazine.containsKey(ch)) {
				mapMagazine.put(ch, 1);
			} else {
				mapMagazine.put(ch, mapMagazine.get(ch) + 1);
			}
		}

		System.out.println(mapRansom);
		System.out.println(mapMagazine);

		for (Map.Entry<Character, Integer> entry : mapRansom.entrySet()) {
			if (mapMagazine.containsKey(entry.getKey())) {
				if (entry.getValue() > mapMagazine.get(entry.getKey()))
					return false;
			} else {
				return false;
			}
		}

		return true;
	}

	public boolean canConstruct_1ms(String ransomNote, String magazine) {

		if (magazine.length() < ransomNote.length())
			return false;

		int[] chars = new int[26];

		int count = 0;
		for (char ch : ransomNote.toCharArray()) {
			int index = ch - 'a';
			if (chars[index] == 0)
				count++;
			chars[index]++;
		}

		for (char ch : magazine.toCharArray()) {
			int index = ch - 'a';
			if (chars[index] == 1)
				count--;
			if (count == 0)
				return true;
			chars[index]--;
		}

		return count == 0;
	}

	public boolean canConstruct_0ms(String ransomNote, String magazine) {

		if (magazine.length() < ransomNote.length())
			return false;

		int[] chars = new int[26];

		for (char ch : ransomNote.toCharArray()) {
			int index = magazine.indexOf(ch, chars[ch - 'a']);
			if (index == -1)
				return false;
			chars[ch - 97] = index + 1;
		}

		return true;
	}

}
