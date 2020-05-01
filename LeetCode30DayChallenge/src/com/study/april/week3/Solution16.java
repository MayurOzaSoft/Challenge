package com.study.april.week3;

/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the
 * validity of a string by these rules:
 * 
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'. Any
 * right parenthesis ')' must have a corresponding left parenthesis '('. Left
 * parenthesis '(' must go before the corresponding right parenthesis ')'. '*'
 * could be treated as a single right parenthesis ')' or a single left
 * parenthesis '(' or an empty string. An empty string is also valid.
 * 
 * Input: "()" Output: True
 * 
 * Input: "(*)" Output: True
 * 
 * Input: "(*))" Output: True
 * 
 * Note: The string size will be in the range [1, 100].
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution16 {
	
	public boolean checkValidString(String s) {
        return verifyString(s);
    }
    
    private static boolean verifyString(String s) {
        int leftBalance = 0;
        for (int i = 0; i < s.length(); i++) {
          if ((s.charAt(i) == '(') || (s.charAt(i) == '*'))
            leftBalance++;        
          else
            leftBalance--;

          if (leftBalance < 0) return false;
        }
        
        if (leftBalance == 0) return true;            
        
        int rightBalance = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
          if ((s.charAt(i) == ')') || (s.charAt(i) == '*'))
            rightBalance++;
          else
            rightBalance--;

          if (rightBalance < 0) return false;
        }
        
        return true;   
    }

}
