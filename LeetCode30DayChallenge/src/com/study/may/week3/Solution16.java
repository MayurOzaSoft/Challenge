package com.study.may.week3;

/**
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution16 {
	public ListNode oddEvenList_1ms_1(ListNode head) {
		if (head == null)
			return null;
		ListNode odd = head, even = head.next, evenHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	public ListNode oddEvenList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode result = head;
		ListNode currentOdd = head;
		ListNode currentEven = head.next;
		ListNode connectNode = head.next;

		while (currentOdd != null && currentEven != null) {
			ListNode fast = currentEven.next;
			if (fast == null)
				break;

			currentOdd.next = currentEven.next;
			currentOdd = currentOdd.next;

			currentEven.next = currentOdd.next;
			currentEven = currentEven.next;

		}

		currentOdd.next = connectNode;

		return result;

	}

	// Definition for singly-linked list.
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

}
