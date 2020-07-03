package linkedList.ListCycle_2;

import java.util.HashSet;
import java.util.Set;

import linkedList.ListNode;

public class ListCycle_2 {
	public static void main(String[] args) {
		ListCycle_2 obj = new ListCycle_2();
		ListNode head = ListNode.getSinglyCircularLinkedList();
		ListNode loopStart = obj.detectCycle(head);
	}
	/*
	 * Approach 1 : Two Pointers
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public ListNode detectCycle(ListNode a) {
        ListNode slow=a;
        ListNode fast=a;
        boolean flag=false;
        while(fast!=null && fast.next!=null)
        {
          slow=slow.next;
          fast=fast.next.next;
          if(slow==fast){
        	  flag=true; 
        	  break;
          }
        }
        if(flag==true){
        	slow=a;
	         while(slow!=fast){
		          slow=slow.next;
		          fast=fast.next;
	         }
	         return slow;	
	    }
	    return null;
    }
	
	/*
	 * Approach 2 : HashSet
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public ListNode detectCycle_2(ListNode head) {
		if (head == null){
			return null;
		}
		HashSet<ListNode> set = new HashSet<>();
		for (ListNode cur = head; cur != null; cur = cur.next) {
		    if (!set.contains(cur)){
		    	set.add(cur);
		    }else {
		    	return cur;
		    }
		}
		return null;          
	}
}
