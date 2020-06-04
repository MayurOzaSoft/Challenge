package com.study.june.week1;

/**
 * Reverse String
 * 
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii characters.
 * 
 * Input: ["h","e","l","l","o"]
 * 
 * Output: ["o","l","l","e","h"]
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution4 {

	public void reverseString(char[] s) {

		int firstPointer = 0;
		int lastPointer = s.length - 1;

		while (firstPointer < lastPointer) {
			swap(s, firstPointer, lastPointer);
			firstPointer++;
			lastPointer--;
		}
	}

	private void swap(char[] s, int first, int second) {
		char temp = s[first];
		s[first] = s[second];
		s[second] = temp;
	}

}
