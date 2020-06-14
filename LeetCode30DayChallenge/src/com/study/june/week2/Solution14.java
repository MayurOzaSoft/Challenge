package com.study.june.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Cheapest Flights Within K Stops
 * 
 * 
 * There are n cities connected by m flights. Each flight starts from city u and
 * arrives at v with a price w.
 * 
 * Now given all the cities and flights, together with starting city src and the
 * destination dst, your task is to find the cheapest price from src to dst with
 * up to k stops. If there is no such route, output -1.
 * 
 * Example 1:
 * 
 * Input:
 * 
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * 
 * src = 0, dst = 2, k = 1
 * 
 * Output: 200
 * 
 * Explanation:
 * 
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as
 * marked red in the picture.
 * 
 * Constraints:
 * 
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to
 * n - 1.
 * 
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * 
 * The format of each flight will be (src, dst, price).
 * 
 * The price of each flight will be in the range [1, 10000].
 * 
 * k is in the range of [0, n - 1].
 * 
 * There will not be any duplicated flights or self cycles.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution14 {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		Map<Integer, int[]> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(i, new int[n]);
		}

		for (int[] flight : flights) {
			map.get(flight[0])[flight[1]] = flight[2];
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { src, 0 });

		int[] visit = new int[n];
		Arrays.fill(visit, Integer.MAX_VALUE);

		int min = Integer.MAX_VALUE;

		while (K >= 0 && !queue.isEmpty()) {
			K--;
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] pair = queue.poll();
				int from = pair[0];
				int pr = pair[1];
				int[] nexts = map.get(from);
				for (int t = 0; t < n; t++) {
					if (nexts[t] != 0) {
						int p = pr + nexts[t];
						if (t != dst && visit[t] > p) {
							queue.offer(new int[] { t, p });
							visit[t] = p;
						} else if (t == dst) {
							min = Math.min(min, p);
						}
					}
				}
			}

		}

		if (min == Integer.MAX_VALUE) {
			return -1;
		}

		return min;
	}

	public int findCheapestPrice_n(int n, int[][] flights, int src, int dst, int K) {
		int[] dp = new int[n + 1];

		final int MAX = 0x3f3f3f3f;

		Arrays.fill(dp, MAX);

		dp[src] = 0;

		for (int i = 0; i <= K; i++) {

			int[] temp = new int[n + 1];

			System.arraycopy(dp, 0, temp, 0, n + 1);

			for (int[] flight : flights) {
				int u = flight[0];
				int v = flight[1];
				int cost = flight[2];
				temp[v] = Math.min(temp[v], dp[u] + cost);
			}

			dp = temp;
		}

		return dp[dst] == MAX ? -1 : dp[dst];
	}

}
