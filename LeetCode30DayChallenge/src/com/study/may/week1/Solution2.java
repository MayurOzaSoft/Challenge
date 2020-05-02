package com.study.may.week1;

import java.util.HashSet;

/**
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 * 
 * Input: J = "aA", S = "aAAbbbb" Output: 3
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution2 {

	public int numJewelsInStones(String J, String S) {

		if (J == null || J.length() == 0)
			return 0;

		int count = 0;
		for (Character stone : S.toCharArray())
			for (Character jewel : J.toCharArray()) {
				if (jewel == stone) {
					count++;
					break;
				}
			}

		return count;

	}

	public int numJewelsInStones_WithSpace(String J, String S) {

		HashSet<Character> jewelSet = new HashSet<>();

		for (int i = 0; i < J.length(); i++)
			jewelSet.add(J.charAt(i));

		int count = 0;
		for (Character ch : S.toCharArray())
			if (jewelSet.contains(ch))
				count++;

		return count;

	}

}
