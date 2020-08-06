package com.study.aug.week1;

/**
 * Power of Four
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 5
 * Output: false
 *
 * Follow up: Could you solve it without loops/recursion?
 *
 */
public class Solution4 {
    public boolean isPowerOfFour(int num) {
        if(num == 0) return false;

        int result = (int) (Math.log(num) / Math.log(4));

        return num == Math.pow(4, result);
    }

    public boolean isPowerOfFour_Iterative(int num) {

        while(num > 0) {
            if(num == 1) return true;

            if (num % 4 != 0) return false;
            else {
                num /= 4;
            }
        }

        return false;
    }

    public boolean isPowerOfFour_BitWise(int num){

        int count1 = 0;
        int count0 = 0;

        while(num > 1){

            if((num &= 1) == 1) count1 ++;
            else count0 ++;

            num >>= 1;
        }

        return count1 == 1 && count0 % 2 == 0;
    }
}
