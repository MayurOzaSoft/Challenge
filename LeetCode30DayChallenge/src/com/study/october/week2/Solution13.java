package com.study.october.week2;

/**
 * Sort List
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 * Example 1:
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 *
 */
public class Solution13 {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;
        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(slow);

        return merge(leftHalf, rightHalf);
    }

    private ListNode merge(ListNode leftHalf, ListNode rightHalf) {
        ListNode sortedNode = new ListNode(0);
        ListNode currentNode = sortedNode;

        while(leftHalf != null && rightHalf != null){
            if(leftHalf.val < rightHalf.val){
                currentNode.next = leftHalf;
                leftHalf = leftHalf.next;
            } else {
                currentNode.next = rightHalf;
                rightHalf = rightHalf.next;
            }

            currentNode = currentNode.next;
        }

        if(leftHalf != null){
            currentNode.next = leftHalf;
        }

        if(rightHalf != null){
            currentNode.next = rightHalf;
        }

        return sortedNode.next;
    }
}
