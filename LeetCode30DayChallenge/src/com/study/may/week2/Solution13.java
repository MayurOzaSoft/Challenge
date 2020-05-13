package com.study.may.week2;

/**
 * Remove K Digits
 * 
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * Note:
 * 
 * The length of num is less than 10002 and will be >= k.
 * 
 * The given num does not contain any leading zero.
 * 
 * Input: num = "1432219", k = 3 Output: "1219"
 * 
 * Explanation:
 * 
 * Remove the three digits 4, 3, and 2 to form the new number 1219 which is the
 * smallest.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution13 {
	public String removeKdigits_18ms(String num, int k) {

		String result = "";

		while (k >= 0) {
			if (k == 0) {
				result += num;
				break;
			}

			if (num.length() == k)
				break;

			int minIndex = 0;
			for (int i = 1; i <= k; i++)
				if (num.charAt(i) < num.charAt(minIndex))
					minIndex = i;

			if (!result.isEmpty() && num.charAt(minIndex) == 'c') {
				result += num.charAt(minIndex);
			} else if (num.charAt(minIndex) != 48) {
				result += num.charAt(minIndex);
			}

			num = num.substring(minIndex + 1);

			k = k - minIndex;
		}

		if (result.isEmpty())
			return "0";
		else
			return result;
	}

	public String removeKdigits_3ms(String num, int k) {
		if (num.length() == k)
			return "0";
		if (k == 0)
			return num;
		StringBuilder sb = new StringBuilder(num);
		int i = 0, j = 1;
		while (k > 0) {
			if (sb.charAt(i) > sb.charAt(j)) {
				sb.deleteCharAt(i);
				i = Math.max(0, i - 1);
				j = Math.max(1, j - 1);
				k--;
			} else if (sb.charAt(i) <= sb.charAt(j) && sb.length() - 1 - j >= k) {
				i++;
				j++;
			} else {
				sb.deleteCharAt(j);
				k--;
			}
		}
		// removes the leading zeros
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
}
