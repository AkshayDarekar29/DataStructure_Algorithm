package linkedList.CloneLL_withRandomPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import linkedList.ListNode;

public class CloneLL_withRandomPointer {
	/*
	 * Approach 1 : HashMap to store reference to newly  created node
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node oldHead = head;
        Node newHead = new Node(head.val);
        Node curr = newHead;
        HashMap<Node, Node> hash = new HashMap<>();
        hash.put(head, newHead);
        while(head.next != null){
            Node next = head.next;
            Node temp = new Node(next.val);
            hash.put(next, temp);
            curr.next = temp;
            curr = curr.next;
            head = head.next;
        }
        curr = newHead;
        while(oldHead != null){
            Node random = oldHead.random;
            Node temp = hash.get(random);
            curr.random = temp;
            curr = curr.next;
            oldHead = oldHead.next;
        }
        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
