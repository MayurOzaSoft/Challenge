package com.study.may.week4;

/**
 * Counting Bits
 * 
 * Given a non negative integer number num. For every numbers i in the range 0
 * <= i <= num calculate the number of 1's in their binary representation and
 * return them as an array.
 * 
 * Input: 2 Output: [0,1,1]
 * 
 * Input: 5 Output: [0,1,1,2,1,2]
 * 
 * Follow up:
 * 
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)).
 * 
 * But can you do it in linear time O(n) /possibly in a single pass?
 * 
 * Space complexity should be O(n).
 * 
 * Can you do it like a boss? Do it without using any builtin function like
 * __builtin_popcount in c++ or in any other language.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution28 {
	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		result[0] = 0;

		for (int i = 1; i <= num; i++)
			result[i] = result[i >> 1] + i % 2;

		return result;
	}

	int numberOfBits_memo(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	public void findBinary_bruteForce(int index, int[] result) {
		int count = 0;
		int process = index;

		while (process > 0) {
			int binary = process % 2;
			if (binary == 1)
				count++;
			process = process / 2;
		}

		result[index] = count;

	}
}
