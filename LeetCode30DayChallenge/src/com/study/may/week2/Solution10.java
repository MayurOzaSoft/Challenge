package com.study.may.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution10 {

	public int findJudge(int N, int[][] trust) {
		if (trust.length == 0)
			return 1;

		int[] parents = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}

		Map<Integer, List<Integer>> parentMap = new HashMap<>();

		for (int[] data : trust) {
			int a = data[0];
			int b = data[1];
			parents[a] = b;
			parentMap.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
		}

		for (Map.Entry<Integer, List<Integer>> judgeSet : parentMap.entrySet()) {
			List<Integer> trustFactors = judgeSet.getValue();

			if (trustFactors.size() == N - 1) {
				Integer judge = judgeSet.getKey();
				if (parents[judge] != judge)
					return -1;
				return judge;
			}
		}

		return -1;
	}

	public int findJudge_3ms(int N, int[][] trust) {

		int[] isTrusted = new int[N + 1];

		for (int[] person : trust) {
			isTrusted[person[0]]--;
			isTrusted[person[1]]++;
		}

		for (int i = 1; i < isTrusted.length; i++) {
			if (isTrusted[i] == N - 1)
				return i;
		}

		return -1;
	}

}
