package com.study.august.week1;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    class MyHashSet {

        private final Object CONSTANT = new Object();
        private Map<Integer, Object> mapSet;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            mapSet = new HashMap<>();
        }

        public void add(int key) {
            mapSet.put(key, CONSTANT);
        }

        public void remove(int key) {
            mapSet.remove(key);
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return mapSet.containsKey(key);
        }
    }

    class MyHashSet2 {

        class Node {
            int val;
            Node next;

            Node(int val){
                this.val = val;
            }
        }

        Node[] nodes;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet2() {
            nodes = new Node[10000 + 11];
        }

        public void add(int key) {
            int index = hash(key);

            if(nodes[index] == null){
                nodes[index] = new Node(key);
            } else {
                Node current = nodes[index];
                while(current.next != null){
                    current = current.next;
                }

                if(current.val != key)
                    current.next = new Node(key);
            }
        }

        public void remove(int key) {
            int index = hash(key);

            if(nodes[index] == null)
                return;
            if(nodes[index].val == key)
                nodes[index] = nodes[index].next;
            else {
                Node previous = null;
                Node current = nodes[index];

                while(current.next != null && current.val != key){
                    previous = current;
                    current = current.next;
                }

                if(current.val == key && previous != null)
                    previous.next = current.next;
            }
        }

        public int hash(int key){
            return key % nodes.length;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int index = hash(key);
            Node current = nodes[index];

            while(current != null && current.val != key){
                current = current.next;
            }

            return current != null;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
