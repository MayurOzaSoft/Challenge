package com.study.june.week2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Insert Delete GetRandom O(1)
 * 
 * Design a data structure that supports all following operations in average
 * O(1) time.
 * 
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present. getRandom: Returns
 * a random element from current set of elements. Each element must have the
 * same probability of being returned.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution12 {
	class RandomizedSet {

		Set<Integer> set;

		/** Initialize your data structure here. */
		public RandomizedSet() {
			set = new HashSet<>();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already contain
		 * the specified element.
		 */
		public boolean insert(int val) {
			if (!set.contains(val)) {
				set.add(val);
				return true;
			}

			return false;
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the specified
		 * element.
		 */
		public boolean remove(int val) {
			if (!set.contains(val))
				return false;
			else {
				set.remove(val);
				return true;
			}

		}

		/** Get a random element from the set. */
		public int getRandom() {
			Integer random = new Random().nextInt(set.size());
			Integer[] randData = set.toArray(new Integer[set.size()]);
			return randData[random];
		}
	}

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
	 */
}
