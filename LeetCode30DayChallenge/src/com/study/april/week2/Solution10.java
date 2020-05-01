package com.study.april.week2;

/**
 * Given a non-empty, singly linked list with head node head, return a middle
 * node of linked list.
 * 
 * If there are two middle nodes, return the second middle node.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution10 {
	public ListNode middleNode(ListNode head) {
		ListNode dummyNode = head;
		int counter = 0;
		while (dummyNode != null) {
			counter++;
			dummyNode = dummyNode.next;
		}

		counter /= 2;

		dummyNode = head;
		while (counter > 0) {
			dummyNode = dummyNode.next;
			counter--;
		}

		return dummyNode;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
