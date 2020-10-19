package linkedList.ReorderList;

import java.util.Stack;

import linkedList.ListNode;

public class ReorderList {
	public static void main(String[] args) {
		
	}
	/*
	 * Approach 1 : Stack
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        while(fast != null){
            stack.push(fast);
            fast = fast.next;
        }
        ListNode curr = head; 
        while(!stack.empty()){
           ListNode temp = curr.next;
            curr.next = stack.pop();
            curr = curr.next;
            curr.next = temp;
            curr = curr.next;
        }
    }
	
	/*
	 * Approach 2 : Reverse second half of the linkedList
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public void reorderList_2(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            if(fast.next.next == null){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(curr != null){
            ListNode NEXT = curr.next;
            curr.next = prev;
            prev = curr;
            curr = NEXT;
        }
        curr = head; 
        while(curr != null && prev != null){
           ListNode temp = curr.next;
            curr.next = prev;
            prev = prev.next;
            curr = curr.next;
            curr.next = temp;
            curr = curr.next;
        }
    }
}
