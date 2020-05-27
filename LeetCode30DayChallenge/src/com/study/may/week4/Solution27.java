package com.study.may.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Possible Bipartition
 * 
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split
 * everyone into two groups of any size.
 * 
 * Each person may dislike some other people, and they should not go into the
 * same group.
 * 
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the
 * people numbered a and b into the same group.
 * 
 * Return true if and only if it is possible to split everyone into two groups
 * in this way.
 * 
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 
 * Output: true Explanation: group1 [1,4], group2 [2,3]
 * 
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]] Output: false
 * 
 * Note:
 * 
 * 1 <= N <= 2000
 * 
 * 0 <= dislikes.length <= 10000
 * 
 * 1 <= dislikes[i][j] <= N
 * 
 * dislikes[i][0] < dislikes[i][1]
 * 
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution27 {

	List<List<Integer>> graph = new ArrayList<>();
	Map<Integer, Integer> color = new HashMap<>();

	public boolean possibleBipartition(int N, int[][] dislikes) {

		int[] group = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			group[i] = i; // initial
		}

		for (int[] dislike : dislikes) {
			int a = dislike[0];
			int b = dislike[1];

			if (group[a] == a && group[b] == b) {
				group[a] = b;
				group[b] = a;
			} else if (group[a] == a && group[b] != b) {
				// let a go to group that all hate b;
				group[a] = group[group[b]];
			} else if (group[b] == b && group[a] != a) {
				// let a go to group that all hate a;
				group[b] = group[group[a]];
			} else if (group[b] == group[a]) {
				return false;
			}
		}

		return true;
	}

	public boolean possibleBipartition_6ms(int N, int[][] dislikes) {

		for (int i = 1; i <= N + 1; ++i)
			graph.add(new ArrayList<>());

		for (int[] edge : dislikes) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		for (int node = 1; node <= N; ++node) {
			if (!color.containsKey(node) && !dfs(node, 0))
				return false;
		}

		return true;
	}

	private boolean dfs(int node, int color) {
		if (this.color.containsKey(node))
			return this.color.get(node) == color;

		this.color.put(node, color);

		for (int neighbor : graph.get(node)) {
			if (!dfs(neighbor, color ^ 1))
				return false;
		}

		return true;
	}

}
