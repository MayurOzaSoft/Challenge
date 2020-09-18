package com.study.september.week3;

public class Solution18 {

    /**
     * Brute Force
     */
    public int maxProfit_n(int[] prices){
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i ++){
            for(int j = i; j < prices.length; j ++){
                int profit = prices[j] - prices[i];
                if(maxProfit < profit)
                    maxProfit = profit;
            }
        }

        return maxProfit;
    }

    /**
     * Optimised
     */
    public int maxProfit_1ms(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }

        return max;
    }

    /**
     * dp Solution
     */
    public int maxProfit_0ms(int[] prices){
        if(prices.length == 0) return 0;

        int[] dp = new int[prices.length];
        dp[prices.length - 1] = prices[prices.length - 1];

        for(int i = prices.length - 2; i >= 0; i --){
            dp[i] = Math.max(prices[i], dp[i + 1]);
        }

        int max = 0;
        for(int i = 0; i < prices.length; i ++){
            int currentMax = dp[i] - prices[i];
            max = Math.max(currentMax, max);
        }

        return max;
    }
}
