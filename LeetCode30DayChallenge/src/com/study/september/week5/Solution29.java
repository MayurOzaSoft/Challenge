package com.study.september.week5;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Word Break
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 */
public class Solution29 {
    /**
     * TC : O(n^2) Time Limit Exceeded
     */
    public boolean wordBreak_n2(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);
    }

    public boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length())
            return true;

        for(String a: dict){
            int len = a.length();
            int end = start+len;

            // end index should be <= string length
            if(end > s.length())
                continue;

            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s, dict, start+len))
                    return true;
        }

        return false;
    }

    /**
     * TC : O(string length * dict size)
     */
    public boolean wordBreak_1(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state

        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i])
                continue;

            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;

                if(t[end]) continue;

                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }

    /**
     * TC : O(n^2) where n : Length of String
     */
    public boolean wordBreak_n2(String s, List<String> wordDict) {
        int[] pos = new int[s.length()+1];

        Arrays.fill(pos, -1);

        pos[0]=0;

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub)){
                        pos[j]=i;
                    }
                }
            }
        }

        return pos[s.length()]!=-1;
    }

    /**
     *
     */
    public boolean wordBreak_0ms(String s, List<String> wordDict) {
        boolean canBreak = false;

        boolean[] memo = new boolean[s.length()];
        Arrays.fill(memo, true);

        for(String word : wordDict) {
            if(s.startsWith(word)) {
                // System.out.println("Picking word: "+word);
                canBreak = canReallyBreak(s, wordDict, word.length(), memo);
                if(canBreak) break;
            }
        }

        return canBreak;
    }

    public boolean canReallyBreak(String s, List<String> wordDict, int index, boolean[] memo) {
        // System.out.println("At index: " + index);
        if(index >= s.length()) return true;

        if(!memo[index]) return false;

        boolean canBreak = false;

        for(String word : wordDict) {
            if(s.startsWith(word, index)) {
                // System.out.println("Picking word: " + word);
                canBreak = canReallyBreak(s, wordDict, index + word.length(), memo);
                if(canBreak) break;

            }
        }
        memo[index] = canBreak;

        return canBreak;
    }
}
