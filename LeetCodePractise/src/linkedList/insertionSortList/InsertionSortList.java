package linkedList.insertionSortList;

import linkedList.ListNode;

public class InsertionSortList {
	
	public static void main(String[] args) {
		ListNode head = ListNode.getSinglyLinkedList();
	
		InsertionSortList obj = new InsertionSortList();
		ListNode node = obj.insertionSortList(head);
		System.out.println(node);
	}
	/*
	 * Approach 1 : 
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */

	public ListNode insertionSortList(ListNode head) {
	    ListNode dummy = new ListNode(0);
	    ListNode prev = dummy;
	
	   while (head != null) {
	       ListNode temp = head.next;
	       
	       /* Before insert, the prev is at the last node of the sorted list.
	          Only the last node's value is larger than the current inserting node 
	          should we move the temp back to the head*/
	       if (prev.val >= head.val) prev = dummy;
	
	       while (prev.next != null && prev.next.val < head.val) {
	           prev = prev.next;
	       }
	       
	       head.next = prev.next;
	       prev.next = head;
	       // prev = dummy; // Don't set prev to the head of the list after insert
	       head = temp;
	   }
	   return dummy.next;
	}
}