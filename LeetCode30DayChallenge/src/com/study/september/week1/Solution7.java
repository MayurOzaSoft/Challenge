package com.study.september.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Pattern
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 *
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 *
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 *
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 *
 */
public class Solution7 {
    public boolean wordPattern_0ms(String pattern, String str) {
        Map<Object, Integer> map_index = new HashMap<>();
        String[] words = str.split(" ");

        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (!map_index.containsKey(c))
                map_index.put(c, i);

            if (!map_index.containsKey(w))
                map_index.put(w, i);

            if (!map_index.get(c).equals(map_index.get(w)))
                return false;
        }

        return true;
    }

    public boolean wordPattern_2ms(String pattern, String str) {
        String[] stringArray = str.split("\\s");

        if(stringArray.length != pattern.length())
            return false;

        Map<Character, String> map = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                String value = map.get(c);
                if(!value.equals(stringArray[i])){
                    return false;
                }
            }else if (map.containsValue(stringArray[i])){
                return false;
            }

            map.put(c, stringArray[i]);
        }

        return true;
    }
}
