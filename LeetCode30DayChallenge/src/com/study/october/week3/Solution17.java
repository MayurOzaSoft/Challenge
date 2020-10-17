package com.study.october.week3;

import java.util.*;

/**
 * Repeated DNA Sequences
 *
 * All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example 1:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 *
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 *
 * Constraints:
 *
 * 0 <= s.length <= 105
 * s[i] is 'A', 'C', 'G', or 'T'.
 *
 */
public class Solution17 {

    public List<String> findRepeatedDnaSequences_19ms(String s) {
        List<String> dnaSequences = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int i = 0;

        while (i + 10 <= s.length()) {
            String subString = s.substring(i, i + 10);
            map.put(subString, map.getOrDefault(subString, 0) + 1);
            if(map.get(subString) == 2)
                dnaSequences.add(subString);
        }

        return dnaSequences;
    }

    public List<String> findRepeatedDnaSequences_15ms(String s) {
        Set<String> subSet = new HashSet<>();
        Set<String> result = new HashSet<>();

        for(int i = 0; i < s.length() - 9; i ++){
            String subString = s.substring(i, i + 10);
            if(!subSet.add(subString))
                result.add(subString);
        }

        return new ArrayList<>(result);
    }


}
