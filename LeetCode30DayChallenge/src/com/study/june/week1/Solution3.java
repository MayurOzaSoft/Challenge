package com.study.june.week1;

import java.util.Arrays;

/**
 * Two City Scheduling
 * 
 * There are 2N people a company is planning to interview. The cost of flying
 * the i-th person to city A is costs[i][0], and the cost of flying the i-th
 * person to city B is costs[i][1].
 * 
 * Return the minimum cost to fly every person to a city such that exactly N
 * people arrive in each city.
 * 
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * 
 * Output: 110
 * 
 * Explanation:
 * 
 * The first person goes to city A for a cost of 10. The second person goes to
 * city A for a cost of 30. The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 * 
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people
 * interviewing in each city.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution3 {
	public int twoCitySchedCost(int[][] costs) {

		Arrays.sort(costs, (a, b) -> {
			return (a[0] - a[1]) - (b[0] - b[1]);
		});

		int i = 0, j = costs.length - 1;
		int sum = 0;

		while (i < j) {
			sum += costs[i][0] + costs[j][1];
			++i;
			--j;
		}

		return sum;
	}
}
