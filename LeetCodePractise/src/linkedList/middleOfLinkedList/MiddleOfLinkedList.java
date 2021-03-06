package linkedList.middleOfLinkedList;

import linkedList.ListNode;

public class MiddleOfLinkedList {
		 
	public static void main(String[] args) {
		ListNode head = ListNode.getSinglyLinkedList();
		
		MiddleOfLinkedList obj = new MiddleOfLinkedList();
		ListNode node = obj.middleNode(head);
		System.out.println(node);
	}
	
	/*
	 * Approach 1 : Two Pointers
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
	
	/*
	 * Approach 2 : Using array to store each node
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public ListNode middleNode_2(ListNode head) {
       ListNode[] A = new ListNode[100];
       int t = 0;
       while (head.next != null) {
           A[t++] = head;
           head = head.next;
           if(head.next == null){
                A[t++] = head;
           }
       }
       if(t == 0){
           return head;
       }
     
       return A[t/2];
   }
	
}
