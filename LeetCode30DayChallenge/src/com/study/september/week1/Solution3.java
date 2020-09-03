package com.study.september.week1;

/**
 * Repeated Substring Pattern
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *  Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 */
public class Solution3 {
    public boolean repeatedSubstringPattern_72ms(String s) {
        return ((s.concat(s)).indexOf(s, 1) != s.length());
    }

    public boolean repeatedSubstringPattern_9ms(String str) {
        int n = str.length();

        for (int i = n / 2; i > 0; i--) {
            if (n % i == 0) {
                int left = 0;
                int right = i;

                while (right < n && str.charAt(left ++) == str.charAt(right))
                    right ++;

                if (right == n) {
                    return true;
                }
            }
        }

        return false;
    }
}
