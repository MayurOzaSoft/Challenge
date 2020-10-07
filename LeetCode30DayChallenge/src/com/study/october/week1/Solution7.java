package com.study.october.week1;

public class Solution7 {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null) return head;
        if(head.next == null) return head;

        ListNode old_node = head;
        int n = 1;

        while(old_node.next != null){
            n ++;
            old_node = old_node.next;
        }

        old_node.next = head;

        ListNode new_node = head;

        for(int i = 0; i < n - k % n - 1; i ++)
            new_node = new_node.next;

        ListNode new_head = new_node.next;

        new_node.next = null;

        return new_head;
    }

    /**
     * Definition for singly-linked list.
     */
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
