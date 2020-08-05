package com.study.aug;

public class Solution4 {
    public boolean isPowerOfFour(int num) {
        if(num == 0) return false;

        int result = (int) (Math.log(num) / Math.log(4));

        if(num == Math.pow(4, result))
            return true;

        return false;
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
