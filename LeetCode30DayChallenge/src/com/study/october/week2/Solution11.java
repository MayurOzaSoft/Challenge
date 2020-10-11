package com.study.october.week2;

/**
 * Remove Duplicate Letters
 * <p>
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 * <p>
 * Example 1:
 * <p>
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 * <p>
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 */
public class Solution11 {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();

        boolean[] used = new boolean[26];
        int[] count = new int[26];

        char[] chars = s.toCharArray();

        for (char ch : chars) {
            count[ch - 'a']++;
        }

        processData(sb, used, count, chars);

        return sb.toString();
    }

    private void processData(StringBuilder sb, boolean[] used, int[] count, char[] chars) {
        for (char ch : chars) {

            count[ch - 'a']--;

            if (used[ch - 'a']) continue;

            while (sb.length() > 0
                    && ch < sb.charAt(sb.length() - 1)
                    && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {

                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(ch);
            used[ch - 'a'] = true;
        }
    }
}
