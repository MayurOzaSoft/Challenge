package com.study.aug.week2;

import java.util.Arrays;

public class Solution14 {
    public int longestPalindrome(String s) {
        if(s == null || s.isEmpty()) return 0;

        int[] occurrences = new int[128];

        for(char ch : s.toCharArray())
            occurrences[ch]++;

        int length = 0;

        for(int i : occurrences){
            length += i / 2 * 2;
            if(length % 2 == 0 && i % 2 == 1)
                length ++;
        }

        return length;
    }

    public int longestPalindrome_n(String s) {
        int[] occurrences = new int[128];
        for(char ch : s.toCharArray()) occurrences[ch] ++;

        int oddNumbers = (int) Arrays.stream(occurrences)
                                    .filter(i -> i % 2 != 0)
                                    .count();

        return oddNumbers > 1 ? s.length() - oddNumbers + 1 : s.length();

    }
}
