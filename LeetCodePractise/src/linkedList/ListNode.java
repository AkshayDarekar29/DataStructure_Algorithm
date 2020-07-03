package linkedList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
  	  val = x; 
    }
    
    public static ListNode getSinglyLinkedList(){
    	ListNode head = new ListNode(2);
		ListNode sec = new ListNode(1);
		head.next = sec;
		ListNode third = new ListNode(5);
		sec.next = third;
		ListNode fourth = new ListNode(-1);
		third.next = fourth;
		ListNode fifth = new ListNode(4);
		fourth.next = fifth;

		return head;
    }
    
    public static ListNode getSinglyCircularLinkedList(){
    	ListNode head = new ListNode(5);
		ListNode sec = new ListNode(6);
		head.next = sec;
		ListNode third = new ListNode(7);
		sec.next = third;
		ListNode fourth = new ListNode(8);
		third.next = fourth;
		fourth.next = third;
		return head;
    }
    
}