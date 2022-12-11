package examples;

import java.util.HashMap;

public class DataStructureExamples {

/////////////////////////////LINKED LISTS/////////////////////////////////////
	static class ListNode {
		private int val;
		private ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		if (list1.val < list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}

	}

	// TIME (N)
	// SPACE (N)
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// Reverse the list except me (descend to the bottom of the call stack or end of
		// the ll)
		ListNode rest = reverseList(head.next);

		// Upward reversal set next nodes next to the head and then set the next to null
		head.next.next = head;
		head.next = null;

		// return upward
		return rest;
	}

	// TIME O(N)
	// SPACE O(1)
	public ListNode reverseListIterativley(ListNode head) {
		ListNode prev = new ListNode();
		ListNode curr = head;
		ListNode next = new ListNode();

		while (curr != null) {
			// Stash next as not to lose the link
			// Set Curr to prev to reverse
			// Advance prev
			// Advance Curr
			// return prev when curr == null

			// Stash Next so we can change pointer
			next = curr.next;
			// Change pointer of the currents next values to now be the previous (which will
			// be null
			// on first iteration)
			curr.next = prev;
			// Move the list forward for next iteration by setting previous to current
			prev = curr;
			// curr is now the next value for next iteration
			curr = next;
		}
		return prev;
	}

	// Slow and fast pointers
	// TIME O(N)
	// SPACE O(1)
	public ListNode middleNode(ListNode head) {
		// Use pointers based on the position of the list you are looking for
		// slow computes at half the speed of fast which will in return result in the
		// middle of the list
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	// Detect Cycle
	// O(n) ?
	// O(n) ?
	public ListNode detectCycle(ListNode head) {
		HashMap<ListNode, Integer> counter = new HashMap<>();
		counter.put(head, 0);

		if (head == null || head.next == null)
			return null;

		while (head != null && counter.get(head) == 0) {
			int count = counter.containsKey(head.next) ? counter.get(head.next) : 0;
			counter.put(head.next, count);

			counter.put(head, counter.get(head) + 1);
			head = head.next;
		}

		return head;
	}

	/*
	 * Detect Cycle using fast and slow pointers Define two pointers slow and fast.
	 * Both start at head node, fast is twice as fast as slow. If it reaches the end
	 * it means there is no cycle, otherwise eventually it will eventually catch up
	 * to slow pointer somewhere in the cycle.
	 * 
	 * Let the distance from the first node to the the node where cycle begins be A,
	 * and let say the slow pointer travels travels A+B. The fast pointer must
	 * travel 2A+2B to catch up. The cycle size is N. Full cycle is also how much
	 * more fast pointer has traveled than slow pointer at meeting point.
	 * 
	 * A+B+N = 2A+2B N=A+B
	 * 
	 * From our calculation slow pointer traveled exactly full cycle when it meets
	 * fast pointer, and since originally it traveled A before starting on a cycle,
	 * it must travel A to reach the point where cycle begins! We can start another
	 * slow pointer at head node, and move both pointers until they meet at the
	 * beginning of a cycle.
	 */
	// Space O(1)
	public ListNode detectCycleFaster(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				ListNode slow2 = head;
				while (slow2 != slow) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow;
			}
		}
		return null;
	}

/////////////////////////END OF LINKED LISTS/////////////////////////////////////

}
