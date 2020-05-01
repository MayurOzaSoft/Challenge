package com.study.april.week2;

import java.util.Arrays;

/**
 * Last Stone Weight
 * 
 * We have a collection of stones, each stone has a positive integer weight.
 * 
 * Each turn, we choose the two heaviest stones and smash them together. Suppose
 * the stones have weights x and y with x <= y. The result of this smash is:
 * 
 * If x == y, both stones are totally destroyed; If x != y, the stone of weight
 * x is totally destroyed, and the stone of weight y has new weight y-x. At the
 * end, there is at most 1 stone left. Return the weight of this stone (or 0 if
 * there are no stones left.)
 * 
 * Note:
 * 
 * 1. <= stones.length <= 30
 * 
 * 1. <= stones[i] <= 1000
 * 
 * 
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution14 {

	public int lastStoneWeight(int[] stones) {

		Arrays.sort(stones);

		while (stones.length != 1) {
			int length = stones.length;

			int smash = stones[length - 1] - stones[length - 2];

			stones[length - 2] = smash;

			int[] newStones = Arrays.copyOfRange(stones, 0, length - 1);

			Arrays.sort(newStones);

			stones = newStones;

		}

		return stones.length > 0 ? stones[stones.length - 1] : 0;

	}

}
