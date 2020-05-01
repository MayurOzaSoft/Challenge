package com.study.april.week4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU Cache
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 *
 * @author mayur.p.ozardekar
 *
 */
public class Solution24 {

	public static void main(String[] args) {

	}

	class LRUCache {

		HashMap<Integer, Integer> cacheMap;
		int capacity;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			cacheMap = new LinkedHashMap<>(capacity);
		}

		public int get(int key) {
			if (cacheMap.containsKey(key)) {
				Integer fetchRecord = cacheMap.get(key);
				cacheMap.remove(key);
				cacheMap.put(key, fetchRecord);
				return fetchRecord;
			}

			return -1;

		}

		public void put(int key, int value) {

			if (cacheMap.containsKey(key))
				cacheMap.remove(key);

			else if (cacheMap.size() == capacity) {
				Map.Entry<Integer, Integer> entry = cacheMap.entrySet().iterator().next();
				int first = entry.getKey();
				cacheMap.remove(first);
			}

			cacheMap.put(key, value);

		}
	}

}
