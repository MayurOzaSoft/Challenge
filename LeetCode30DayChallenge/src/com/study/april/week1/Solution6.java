package com.study.april.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Anagrams
 * 
 * Given an array of strings, group anagrams together.
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 
 * Output:
 * 
 * [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution6 {

	public List<List<String>> groupAnagrams(String[] strs) {

		if (strs.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> ans = new HashMap<String, List<String>>();

		for (String s : strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			if (!ans.containsKey(key))
				ans.put(key, new ArrayList<String>());
			ans.get(key).add(s);
		}

		return new ArrayList<List<String>>(ans.values());
	}

}
