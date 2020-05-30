package com.study.may.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * K Closest Points to Origin
 * 
 * We have a list of points on the plane. Find the K closest points to the
 * origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in.)
 * 
 * Example :
 * 
 * Input: points = [[1,3],[-2,2]], K = 1 Output: [[-2,2]]
 * 
 * Explanation:
 * 
 * The distance between (1, 3) and the origin is sqrt(10). The distance between
 * (-2, 2) and the origin is sqrt(8).
 * 
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * 
 * We only want the closest K = 1 points from the origin, so the answer is just
 * [[-2,2]].
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution30 {

	public int[][] kClosest(int[][] points, int K) {

		int length = points.length;
		int[] distance = new int[length];

		for (int i = 0; i < length; i++)
			distance[i] = getDistance(points[i]);

		Arrays.sort(distance);

		int distanceK = distance[K - 1];

		int[][] result = new int[K][2];
		int j = 0;

		for (int i = 0; i < length; i++)
			if (getDistance(points[i]) <= distanceK)
				result[j++] = points[i];

		return result;
	}

	private int getDistance(int[] subPoints) {
		return (subPoints[1] - 0) * (subPoints[1] - 0) + (subPoints[0] - 0) * (subPoints[0] - 0);
	}

	public int[][] kClosest_n(int[][] points, int K) {

		Map<Double, List<Integer>> distanceMap = new HashMap<>();
		PriorityQueue<Double> queue = new PriorityQueue<>();

		for (int i = 0; i < points.length; i++) {
			int[] subPoints = points[i];
			double distance = Math
					.sqrt(((subPoints[1] - 0) * (subPoints[1] - 0)) + ((subPoints[0] - 0) * (subPoints[0] - 0)));

			distanceMap.compute(distance, (k, v) -> v == null ? new ArrayList<>() : v).add(i);
			queue.add(distance);
		}

		int[][] result = new int[K][2];

		int index = 0;
		while (!queue.isEmpty() && K > index) {
			List<Integer> positions = distanceMap.get(queue.poll());
			for (int j : positions) {
				result[index++] = points[j];
			}
		}

		return result;
	}

	public int[][] kClosest_n2(int[][] points, int K) {

		List<int[]> pointList = Arrays.asList(points);

		pointList.sort((p1, p2) -> {
			int x1 = p1[0];
			int y1 = p1[1];
			int x2 = p2[0];
			int y2 = p2[1];
			return (x1 * x1 + y1 * y1) - (x2 * x2 + y2 * y2);
		});

		int[][] result = new int[K][2];

		for (int i = 0; i < K; i++) {
			int[] point = pointList.get(i);
			result[i] = new int[] { point[0], point[1] };
		}

		return result;
	}

}
