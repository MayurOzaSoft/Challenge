package com.study.aug.week2;

import java.util.ArrayList;

public class Solution13 {
    class CombinationIterator {
        ArrayList<String> comb;
        int pointer, cLen;

        public CombinationIterator(String characters, int combinationLength) {
            this.comb = new ArrayList<>();
            this.pointer = 0;
            this.cLen = combinationLength;
            this.combinations(characters, 0, "");
        }

        public void combinations(String s, int index, String com) {
            if (com.length() == this.cLen) {
                this.comb.add(com);
                return;
            }
            if (index >= s.length()) return;
            for (int i = index; i < s.length(); i++)
                combinations(s, i + 1, com + s.charAt(i));
        }

        public String next() {
            return this.comb.get(this.pointer++);
        }

        public boolean hasNext() {
            return this.pointer < this.comb.size();
        }
    }
}
