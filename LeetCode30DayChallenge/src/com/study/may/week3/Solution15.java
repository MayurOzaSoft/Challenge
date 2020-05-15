package com.study.may.week3;

import java.util.Arrays;

/**
 * Maximum Sum Circular Subarray
 * 
 * Given a circular array C of integers represented by A, find the maximum
 * possible sum of a non-empty subarray of C.
 * 
 * Here, a circular array means the end of the array connects to the beginning
 * of the array. (Formally, C[i] = A[i] when 0 <= i < A.length, and
 * C[i+A.length] = C[i] when i >= 0.)
 * 
 * Also, a subarray may only include each element of the fixed buffer A at most
 * once. (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist
 * i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 *
 * Input: [1,-2,3,-2] Output: 3
 * 
 * Explanation: Subarray [3] has maximum sum 3
 * 
 * Input: [3,-1,2,-1] Output: 4
 * 
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 * 
 * Note:
 * 
 * -30000 <= A[i] <= 30000
 * 
 * 1 <= A.length <= 30000
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution15 {

	public int maxSubarraySumCircular(int[] A) {
		int length = A.length;
		if (length == 1)
			return A[0];

		int max_kadane_pos = maxKadane(A);
		int eliminate_sum = Arrays.stream(A).sum();

		for (int i = 0; i < length; i++)
			A[i] = -A[i];

		int max_kadane_neg = maxKadane(A);

		eliminate_sum += max_kadane_neg;

		if (eliminate_sum == 0)
			return max_kadane_pos;

		return Integer.max(max_kadane_pos, eliminate_sum);
	}

	public int maxKadane(int[] A) {
		int length = A.length;
		int current_max = Integer.MIN_VALUE;
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < length; i++) {
			current_max = Math.max(current_max, 0) + A[i];
			result = Math.max(result, current_max);
		}

		return result;
	}
	
	public int maxSubarraySumCircular_3ms(int[] A) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int sum1 = 0, sum2 = 0, total = 0;
        
        for(int x : A) {
        	
            if(sum1 < 0){
                sum1 = 0;
            }
            sum1 += x;
            max = Math.max(max, sum1);
            
            if(sum2 > 0){
                sum2 = 0;
            }
            sum2 += x;
            min = Math.min(min, sum2);
            
            total += x;
        }
        
        return max > 0 ? Math.max(max, total - min) : max;
    }

}
