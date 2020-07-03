package linkedList.mergeTwoSortedList;

import linkedList.ListNode;

public class MergeTwoSortedList {
		 
	public static void main(String[] args) {
		ListNode head = ListNode.getSinglyLinkedList();
		/*
		MergeTwoSortedList obj = new MergeTwoSortedList();
		ListNode node = obj.reverseList_2(head, null);
		System.out.println(node);*/
	}
	
	/*
	 * Approach 1 : Merge Method of Merge Sort
	 * Time Complexity: O(m+n) 
	 * Space Complexity: O(1)
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    
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
