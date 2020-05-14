package com.study.may.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * 
 * trie.search("apple"); // returns true
 * 
 * trie.search("app"); // returns false
 * 
 * trie.startsWith("app"); // returns true
 * 
 * trie.insert("app");
 * 
 * trie.search("app"); // returns true
 * 
 * Note:
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * All inputs are guaranteed to be non-empty strings.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution14 {
	class Trie {

		class Node {
			char value;
			Map<Character, Node> children = new HashMap<>();
			boolean isEndOfWord;

			Node() {
			}

			Node(char value) {
				this.value = value;
			}

			public boolean hasChild(char ch) {
				return children.containsKey(ch);
			}

			public void addChild(Character ch) {
				children.putIfAbsent(ch, new Node(ch));
			}

			public Node getChild(Character ch) {
				return children.get(ch);
			}
		}

		private Node root = new Node();

		/** Initialize your data structure here. */
		public Trie() {

		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			if (null == word)
				return;

			Node current = root;
			for (char ch : word.toCharArray()) {
				current.addChild(ch);
				current = current.getChild(ch);
			}
			current.isEndOfWord = true;
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			if (null == word)
				return false;

			Node current = root;

			for (char ch : word.toCharArray()) {
				if (!current.hasChild(ch))
					return false;
				current = current.getChild(ch);
			}

			return current.isEndOfWord;
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			if (null == prefix)
				return false;

			boolean isPresent = true;
			Node current = root;

			for (char ch : prefix.toCharArray()) {
				if (!current.hasChild(ch))
					return false;

				Node childNode = current.getChild(ch);
				if (ch != childNode.value) {
					isPresent = false;
					break;
				}
				current = childNode;
			}

			return isPresent;
		}
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * 
	 * Trie obj = new Trie();
	 * 
	 * obj.insert(word);
	 * 
	 * boolean param_2 = obj.search(word);
	 * 
	 * boolean param_3 = obj.startsWith(prefix);
	 */

}
