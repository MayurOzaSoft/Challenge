package com.study.aug.week3;

/**
 * Sort Array By Parity
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 */
public class Solution21 {
    public int[] sortArrayByParity_2ms(int[] A) {

        int[] result = new int[A.length];
        int even = 0;
        int odd = A.length - 1;

        for (int value : A) {
            if (value % 2 == 0) {
                result[even] = value;
                even++;
            } else {
                result[odd] = value;
                odd--;
            }
        }

        return result;
    }

    public int[] sortArrayByParity_78ms(int[] A) {

        for(int i = 0; i < A.length; i ++){
            if(A[i] % 2 != 0){
                for(int j = i; j < A.length; j ++){
                    if(A[j] % 2 == 0){
                        int temp = A[j];
                        A[j] = A[i];
                        A[i] = temp;
                        break;
                    }
                }
            }
        }

        return A;
    }

    public int[] sortArrayByParity_1ms(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }
}
