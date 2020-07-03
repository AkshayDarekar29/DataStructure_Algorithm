package linkedList.reverseLinkedList;

import linkedList.ListNode;

public class ReverseLinkedList {
		 
	public static void main(String[] args) {
		ListNode head = ListNode.getSinglyLinkedList();
		
		ReverseLinkedList obj = new ReverseLinkedList();
		ListNode node = obj.reverseList_2(head, null);
		System.out.println(node);
	}
	
	/*
	 * Approach 1 : Iteration-Three Pointers
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode N = null;
        ListNode P = null;
        
        while(curr != null){
        	N = curr.next;
        	curr.next = P;
        	P = curr;
        	curr = N;
        }
        return P;
    }
	
	/*
	 * Approach 2 : Recursion
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public ListNode reverseList_2(ListNode curr, ListNode P) {
		ListNode N = null;
       if(curr == null){
    	   return P;
       }
        N = curr.next;
	   	curr.next = P;
	   	P = curr;
	   	curr = N;
	   	
	   	return reverseList_2(curr, P);
   }
	
}
