package com.study.august.week1;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
 *
 * Constraints:
 *
 * s consists only of printable ASCII characters.
 */
public class Solution3 {
    public boolean isPalindrome_26ms(String s) {
        String strNew = s.replaceAll("[^A-Za-z0-9]","");

        StringBuilder sb = new StringBuilder(strNew);

        return strNew.toLowerCase().equals(sb.reverse().toString().toLowerCase());
    }

    /**
     *
     * @param s
     * @return flag is valid palindrome or not
     */
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while(start < end){
            if(Character.isLetterOrDigit(s.charAt(start))){
                start ++;
            } else if(Character.isLetterOrDigit(s.charAt(end))){
                end --;
            } else if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            } else {
                start ++;
                end --;
            }
        }
        return true;
    }
}
