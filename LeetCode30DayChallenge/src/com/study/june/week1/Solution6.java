package com.study.june.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Queue Reconstruction by Height
 * 
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * Note: The number of people is less than 1,100.
 * 
 * Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution6 {

	public int[][] reconstructQueue_10ms(int[][] people) {
		
		Arrays.sort(people, (p1, p2) -> {
			if (p1[0] == p2[0]) {
				return p1[1] - p2[1];
			} else
				return p2[0] - p1[0];
		});

		List<int[]> positionList = new ArrayList<>();

		for (int row = 0; row < people.length; row++) {
			int[] position = people[row];
			positionList.add(people[row][1], position);
		}

		return positionList.toArray(new int[0][0]);
	}

	public int[][] reconstructQueue_5ms(int[][] people) {

		if (people == null || people.length == 0) {
			return new int[0][0];
		}

		Queue<int[]> queue = new PriorityQueue<>(people.length, (a, b) -> {
			int result = Integer.compare(b[0], a[0]);
			return result == 0 ? Integer.compare(a[1], b[1]) : result;
		});

		for (int i = 0; i < people.length; i++) {
			int[] peopleQueue = people[i];
			queue.offer(peopleQueue);
		}

		List<int[]> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			result.add(pos[1], pos);
		}

		return result.toArray(new int[0][0]);
	}

}
