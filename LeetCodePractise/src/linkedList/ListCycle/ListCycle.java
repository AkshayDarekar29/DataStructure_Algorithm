package linkedList.ListCycle;

import java.util.HashSet;
import java.util.Set;

import linkedList.ListNode;

public class ListCycle {
	public static void main(String[] args) {
		ListCycle obj = new ListCycle();
		ListNode head = ListNode.getSinglyCircularLinkedList();
		boolean cycle = obj.hasCycle_2(head);
		System.out.println(cycle);
	}
	/*
	 * Approach 1 : Two Pointers
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public boolean hasCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }        
        return cycle;
    }
	
	/*
	 * Approach 2 : HashSet
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public boolean hasCycle_2(ListNode head) {
	    Set<ListNode> nodesSeen = new HashSet<>();
	    while (head != null) {
	        if (nodesSeen.contains(head)) {
	            return true;
	        } else {
	            nodesSeen.add(head);
	        }
	        head = head.next;
	    }
	    return false;
	}
}
