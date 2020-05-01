package com.study.april.week2;

import java.util.Stack;

/**
 * Backspace String Compare
 * 
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * 
 * Input: S = "ab#c", T = "ad#c" Output: true
 * 
 * Explanation: Both S and T become "ac".
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution11 {

	public boolean backspaceCompare(String S, String T) {

		S = getString(S);
		T = getString(T);

		return S.equals(T);

	}

	public static String getString(String S) {
		Stack<Character> ans = new Stack<Character>();
		for (char c : S.toCharArray()) {
			if (c != '#')
				ans.push(c);
			else if (!ans.empty())
				ans.pop();
		}
		return String.valueOf(ans);
	}

}
