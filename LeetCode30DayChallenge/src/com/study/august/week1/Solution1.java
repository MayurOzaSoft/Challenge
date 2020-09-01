package com.study.august.week1;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * Example 1:
 *
 * Input: "USA"
 * Output: True
 *
 * Example 2:
 *
 * Input: "FlaG"
 * Output: False
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 *
 * Complexity :
 *
 * Time : O(N)
 * Space : O(1)
 *
 */
public class Solution1 {
    public boolean detectCapitalUse(String word) {
        int length = word.length();

        boolean isAllUpperCase = true;
        boolean isAllLowerCase = true;

        boolean isFirstUpperCase = Character.isUpperCase(word.charAt(0));

        if(isFirstUpperCase){

            for(int i = 1; i < length; i ++)
                if(Character.isUpperCase(word.charAt(i))) {
                    isAllLowerCase = false;
                } else {
                    isAllUpperCase = false;
                }

            return isAllUpperCase || isAllLowerCase;

        } else {
            for(int i = 1; i < word.length(); i ++)
                if(Character.isUpperCase(word.charAt(i))) {
                    return false;
                }

            return true;
        }

    }

    /**
     * with the help of Regex, it is quite slow in comparison with above approach
     *
     * As per Leetcode submission it take time Complexity as 6ms
     *
     * @param word input
     * @return output if isValid
     */
    public boolean detectCapitalUse_regex(String word){
        return word.matches("[A-Z]*|.[a-z]*");
    }

}
