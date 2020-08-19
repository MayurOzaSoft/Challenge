package com.study.aug.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Numbers With Same Consecutive Differences
 *
 * Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.
 *
 * Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 3, K = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 * Example 2:
 *
 * Input: N = 2, K = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 *
 *
 * Note:
 *
 * 1 <= N <= 9
 * 0 <= K <= 9
 *
 */
public class Solution18 {
    int[] ans = new int[1556];
    int index = 0;
    public int[] numsSameConsecDiff_0ms(int n, int k) {
        for (int i = (n == 1 ? 0 : 1); i <= 9; i++) {
            fun(n - 1, k, i);
        }
        return Arrays.copyOf(ans, index);
    }

    private void fun(int n, int k, int e) {
        // System.out.println(n+" "+k+"  "+ e);
        if (n == 0) {
            // System.out.println("["+index+"] "+ e);
            ans[index++] = e;
            return;
        }
        int rest = e % 10;
        int newE = e * 10 + rest;
        if (rest + k <= 9) {
            fun(n - 1, k, newE + k);
        }
        if (k != 0 && rest - k >= 0) {
            fun(n - 1, k, newE - k);
        }
    }

    public int[] numsSameConsecDiff_4ms(int N, int K) {
        if (N == 1)
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> results = new ArrayList<Integer>();
        for (int num = 1; num < 10; ++num)
            this.DFS(N - 1, num, K, results);

        // convert the ArrayList to int[]
        return results.stream().mapToInt(i->i).toArray();
    }

    protected void DFS(int N, int num, int K, List<Integer> results) {
        if (N == 0) {
            results.add(num);
            return;
        }
        List<Integer> nextDigits = new ArrayList<>();

        Integer tailDigit = num % 10;
        nextDigits.add(tailDigit + K);
        if (K != 0)
            nextDigits.add(tailDigit - K);
        for (Integer nextDigit : nextDigits) {
            if (0 <= nextDigit && nextDigit < 10) {
                Integer newNum = num * 10 + nextDigit;
                this.DFS(N - 1, newNum, K, results);
            }
        }
    }
}
