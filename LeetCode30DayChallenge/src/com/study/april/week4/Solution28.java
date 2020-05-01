package com.study.april.week4;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * You have a queue of integers, you need to retrieve the first unique integer
 * in the queue.
 * 
 * Implement the FirstUnique class:
 * 
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the
 * queue, and returns -1 if there is no such integer. void add(int value) insert
 * value to the queue.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution28 {

	class FirstUnique {

		Set<Integer> setOfUnique;
		Set<Integer> setOfNumbers;

		public FirstUnique(int[] nums) {
			setOfUnique = new LinkedHashSet<Integer>();
			setOfNumbers = new HashSet<Integer>();

			for (int num : nums) {
				add(num);
			}

		}

		public int showFirstUnique() {
			if (setOfUnique.isEmpty())
				return -1;
			else
				return setOfUnique.iterator().next();

		}

		public void add(int value) {
			if (setOfNumbers.add(value)) {
				setOfUnique.add(value);
			} else
				setOfUnique.remove(value);
		}
	}
}
