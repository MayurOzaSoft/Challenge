package com.study.june.week1;

import java.util.Arrays;

/**
 * Random Pick with Weight
 * 
 * 
 * Given an array w of positive integers, where w[i] describes the weight of
 * index i, write a function pickIndex which randomly picks an index in
 * proportion to its weight.
 * 
 * Note:
 * 
 * 1 <= w.length <= 10000
 * 
 * 1 <= w[i] <= 10^5
 * 
 * pickIndex will be called at most 10000 times.
 * 
 * Input: ["Solution","pickIndex"] [[[1]],[]] Output: [null,0]
 * 
 * Explanation :
 * 
 * The problem is, we need to randomly pick an index proportional to its weight.
 * What this means? We have weights array, each weights[i] represents weight of
 * index i. The more the weight is, then high chances of getting that index
 * randomly.
 * 
 * suppose weights = [1, 3] then 3 is larger, so there are high chances to get
 * index 1.
 * 
 * We can know the chances of selecting each index by knowing their probability.
 * 
 * P(i) = weight[i]/totalWeight
 * 
 * totalWeight = 1 + 3 = 4 So, for index 0, P(0) = 1/4 = 0.25 = 25% for index 1,
 * P(1) = 3/4 = 0.75 = 75%
 * 
 * So, there are 25% of chances to pick index 0 and 75% chances to pick index 1.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution5 {
	private double[] probabilities;

	public Solution5(int[] w) {
		double sum = 0;
		this.probabilities = new double[w.length];

		for (int weight : w)
			sum += weight;

		for (int i = 0; i < w.length; i++) {
			w[i] += (i == 0) ? 0 : w[i - 1];
			probabilities[i] = w[i] / sum;
		}
	}

	public int pickIndex() {
		return Math.abs(Arrays.binarySearch(this.probabilities, Math.random())) - 1;
	}

}
