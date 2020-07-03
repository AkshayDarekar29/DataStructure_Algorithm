package linkedList.addTwoNumbers;

import linkedList.ListNode;

public class AddTwoNumbers {
	
	/*
	 * Approach 1 : Iteration
	 * Time Complexity: O(max(m,n))
	 * Space Complexity: O(1)
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead; 
        while(l1 != null || l2 != null){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            sum = x + y + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
	
	/*
	 * Approach 2 : Recursion
	 * Time Complexity: O(max(m,n))
	 * Space Complexity: O(1), If we consider implicit memory then O(Max(m,n))
	 */
	public ListNode addTwoNumbers_2(ListNode l1, ListNode l2){
	       ListNode head = new ListNode(0);
	       ListNode end =  addTwoNumbers_main(l1, l2, head);
	       if(carry != 0) end.next = new ListNode(carry);
	       return head.next;
	}
	
    int carry = 0;
    
	public ListNode addTwoNumbers_main(ListNode l1, ListNode l2, ListNode end) {
		if(l1 == null && l2 == null){
			return end;
		}
		int x = (l1 != null) ? l1.val : 0;
		int y = (l2 != null) ? l2.val : 0;
		
		int sum = x + y + carry;
		carry = sum/10;
		
        end.next = new ListNode(sum%10);
        end = end.next;

		l1 = (l1 != null) ? l1.next : l1;
		l2 = (l2 != null) ? l2.next : l2;
		
		return addTwoNumbers_main(l1, l2, end);
	}
}
