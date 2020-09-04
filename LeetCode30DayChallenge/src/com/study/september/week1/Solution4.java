package com.study.september.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition Labels
 *
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 *
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 *
 */
public class Solution4 {
    public List<Integer> partitionLabels_3ms(String S) {
        // get the last seen index for each letter 'a' - 'z'
        int[] last = new int[26];

        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int boundary = 0, cnt = 0;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < S.length(); ++i) {
            // update boundary and cnt along the way
            char curChar = S.charAt(i);
            boundary = Math.max(boundary, last[curChar - 'a']);
            cnt++;
            // if we reach the boundary, we collect result and reset count to 0
            if (i == boundary) {
                ans.add(cnt);
                cnt = 0;
            }
        }

        return ans;
    }

    public List<Integer> partitionLabels_2ms(String S) {

        List<Integer> partitionLengths = new ArrayList<>();
        int[] endCharacter = new int[26];

        for(int i = 0; i < S.length(); i ++){
            endCharacter[S.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while(i < S.length()) {
            int end = endCharacter[S.charAt(i) - 'a'];
            int j = i;

            while(j != end){
                end = Math.max(end, endCharacter[S.charAt(j++) - 'a']);
            }

            partitionLengths.add(j - i + 1);
            i = j + 1;

        }

        return partitionLengths;
    }
}
