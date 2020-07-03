package linkedList.reverseNodeInKGroups;

import java.util.Stack;

import linkedList.ListNode;

public class ReverseNodeInKGroups {
 
	/*
	 * Approach 1 : extra space
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode sizeList = head;
        int len = 0;
        while(sizeList != null){
            len++;
            sizeList = sizeList.next;
        }
        ListNode curr = head;
        ListNode N = null;
        ListNode P = null;
        ListNode x = null;
        int counter = 0;
        while(counter != (len - len%k)){
        	N = curr.next;
        	curr.next = P;
        	P = curr;
        	curr = N;
            counter++;
            
            if(counter%k == 0){
                if(x == null){
                    x = P;
                }
                else{
                    ListNode temp = x;
                    while(temp.next != null){
                        temp = temp.next;
                    }
                    temp.next = P;

                }  
                P = null;
            }
        } 
        ListNode temp = x;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = N;   
        return x;
    }	
	
	public ListNode reverseKGroup_2(ListNode head, int k) {
        ListNode result = new ListNode(0);
        ListNode resultPointer = result;
        ListNode pointer = head;
        Stack<ListNode> stack = new Stack<>();
        
        ListNode sizeList = head;
        int len = 0;
        while(sizeList != null){
            len++;
            sizeList = sizeList.next;
        }
        int counter = 0;
        while(counter != (len - len%k)){
            stack.push(pointer);
            pointer = pointer.next;
            counter++;
            if(counter%k == 0){
                while(!stack.empty()){
                    resultPointer.next = stack.pop();
                    resultPointer =  resultPointer.next;
                }
            }
        }
        
        resultPointer.next = pointer;
        
        return result.next;
    }
}
