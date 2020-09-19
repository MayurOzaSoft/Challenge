package com.study.september.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * Sequential Digits
 *
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 * Example 1:
 *
 * Input: low = 100, high = 300
 * Output: [123,234]
 *
 * Example 2:
 *
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 *
 * Constraints:
 *
 * 10 <= low <= high <= 10^9
 *
 */
public class Solution19 {

    /**
     * Optimised
     */
    public List<Integer> sequentialDigits_0ms(int low, int high) {
        List<Integer> result = new ArrayList<>();

        String digits = "123456789";

        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();

        for(int i = lowLength; i <= highLength; i ++)
            for(int j = 0; j < 10 - i; j ++){
                int num = Integer.parseInt(digits.substring(j, j + i));
                if(num >= low && num <= high)
                    result.add(num);
            }

        return result;
    }

    /**
     * Brute Force
     */
    public List<Integer> sequentialDigits_n(int low, int high) {
        List<Integer> result = new ArrayList<>();

        for(int i = low; i < high; i ++){

            String[] strArray = String.valueOf(i).split("");

            boolean isValid = false;

            for(int j = 1; j < strArray.length; j ++){
                int diff = Integer.parseInt(strArray[j]) - Integer.parseInt(strArray[j - 1]);
                if(Integer.parseInt(strArray[j]) > Integer.parseInt(strArray[j - 1]) && diff == 1){
                    isValid = true;
                } else {
                    isValid = false;
                    break;
                }
            }

            if(isValid)
                result.add(i);
        }

        return result;
    }
}
