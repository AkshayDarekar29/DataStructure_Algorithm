package linkedList.MergeSortOnList;

import linkedList.ListNode;

public class MergeSortOnList {
	
	public static void main(String[] args) {
		ListNode head = ListNode.getSinglyLinkedList();
	
		MergeSortOnList obj = new MergeSortOnList();
		ListNode node = obj.sortList_2(head);
		System.out.println(node);
	}
	
	/*
	 * Approach 1 : Recursion
	 * Time Complexity: O(nLog(n)) 
	 * Space Complexity: O(1)
	 */
	public ListNode sortList_2(ListNode head) {
	    if (head == null || head.next == null)
	      return head;
	        
	    // step 1. cut the list to two halves
	    ListNode prev = null, slow = head, fast = head;
	    
	    while (fast != null && fast.next != null) {
	      prev = slow;
	      slow = slow.next;
	      fast = fast.next.next;
	    }
	    
	    prev.next = null;
	    
	    // step 2. sort each half
	    ListNode l1 = sortList(head);
	    ListNode l2 = sortList(slow);
	    
	    // step 3. merge l1 and l2
	    return mergeLists(l1, l2);
	  }

	/*
	 * Approach 2 : My Solution
	 * Time Complexity: O(nLog(n)) 
	 * Space Complexity: O(n)
	 */ 
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode result = null;
		ListNode firstHalf = new ListNode(0);
		ListNode tempFirstHalf = firstHalf;
	    if(head.next != null){
	    	ListNode slow = new ListNode(0);
	    	slow.next = head;
	    	ListNode fast = new ListNode(0);
	    	fast.next = head;
	    	while(fast.next != null && fast.next.next != null){
	    		slow = slow.next;
                fast = fast.next.next;
                tempFirstHalf.next = new ListNode(slow.val);
	    		tempFirstHalf = tempFirstHalf.next;

	    	}
	    	ListNode x = sortList(firstHalf.next);
	    	ListNode y = sortList(slow.next);
	    	result = mergeLists(x, y);
	    }
	    return result;
	}
	
	public ListNode mergeLists(ListNode l1, ListNode l2) {
	    
        ListNode result = new ListNode(0);
        ListNode tempResult = result;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tempResult.next = l1;
                l1 = l1.next;
            }else{
                tempResult.next = l2;
                l2 = l2.next;
            }
            tempResult = tempResult.next;
        }
        while(l1 != null){
            tempResult.next = l1;
            l1 = l1.next;
            tempResult = tempResult.next;
        }
        
        while(l2 != null){
            tempResult.next = l2;
            l2 = l2.next;
            tempResult = tempResult.next;
        }
        
        return result.next;
    }
}