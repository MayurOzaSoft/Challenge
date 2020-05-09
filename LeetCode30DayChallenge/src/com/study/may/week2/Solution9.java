package com.study.may.week2;

/**
 * Valid Perfect Square Given a positive integer num, write a function which
 * returns True if num is a perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Input: 16 Output: true
 * 
 * Input: 14 Output: false
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution9 {
	public boolean isPerfectSquare(int num) {

		if (num == 0)
			return false;

		int i = 1;
		while (num > 0) {
			if (i % 2 != 0) {
				num -= i;
				if (num == 0)
					return true;
				else if (num < 0)
					return false;
			}
			i++;
		}

		return true;
	}
}
