package com.study.august.week3;

/**
 * Reorder List
 *
 * Solution
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class Solution20 {

    public void reorderList(ListNode head) {
        if(head == null) return;

        // Finding the middle point
        ListNode p1 = head, p2 = p1.next;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // Splitting the linked list
        ListNode node1 = head;
        ListNode node2 = p1.next;
        p1.next = null;

        // Reverse the second half
        node2 = reverselist(node2);

        // Merge alternate nodes
        head = new ListNode('X');
        ListNode curr = head;

        while (node1 != null || node2 != null) {

            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }

            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }

        head = head.next;
    }

    public ListNode reverselist(ListNode node) {
        ListNode prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    /**
     * Definition for singly-linked list.
     *
     * */
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}