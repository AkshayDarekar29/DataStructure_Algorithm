package linkedList.intersectionOfTwoLinkedList;

import java.util.HashSet;
import java.util.Set;

import linkedList.ListNode;

public class IntersectionOfTwoLinkedList {
		 
	public static void main(String[] args) {
		ListNode head = ListNode.getSinglyLinkedList();
		
		IntersectionOfTwoLinkedList obj = new IntersectionOfTwoLinkedList();
		ListNode node = obj.getIntersectionNode(head, null);
		System.out.println(node);
	}
	
	/*
	 * Approach 1 : Two Pointers
	 * Time Complexity: O(max(m,n)) 
	 * Space Complexity: O(1)
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0;
        int bLength = 0;
        ListNode slow = headA;
        
        while(slow != null){
            aLength++;
            slow = slow.next;
        }
        slow = headB;
        while(slow != null){
            bLength++;
            slow = slow.next;
        }
        boolean aLarger = (aLength > bLength) ? true : false;
        ListNode aPointer = headA;
        ListNode bPointer = headB;
        if(aLarger){
            int counter = 0;
             while(counter < (aLength - bLength)){
                 aPointer = aPointer.next;
                 counter++;
             }
        }else{
             int counter = 0;
             while(counter < (bLength - aLength)){
                 bPointer = bPointer.next;
                 counter++;
             }
        } 
        
        while(aPointer != null){
            if(aPointer == bPointer){
                return aPointer;
            }
            aPointer = aPointer.next;
            bPointer = bPointer.next;
        }
        
        return null;
    }
	/*
	 * Approach 2 : HashSet
	 * Time Complexity: O(n)) 
	 * Space Complexity: O(n)
	 */
	public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
		ListNode pointer = headA;
		Set<ListNode> set = new HashSet<>();
		while(pointer != null){
			set.add(pointer);
			pointer = pointer.next;
		}
		
		pointer = headB;
		while(pointer != null){
			if(set.contains(pointer)){
				return pointer;
			}
			pointer = pointer.next;
		}
		return null;
	}
}
