package stack.StackImplementationUsingLinkedList;

public class StackImplementationUsingLinkedList<E> {
	private ListNode<E> head;
	public StackImplementationUsingLinkedList(){
		
	}
	
	public E push(E item){
		ListNode<E> toBeInserted = new ListNode<>(item);
		if(head == null){
			head = toBeInserted;
		}else{
			ListNode<E> temp = head;
			toBeInserted.next = head;
			head = toBeInserted;
		}
		return item;
	}
	
	public E pop(){
		E item = null;
		if(head == null){
			throw new RuntimeException("Stack is empty");
		}else{
			ListNode<E> toBeRemopved = head;
			item = toBeRemopved.val;
			head = head.next;
			toBeRemopved = null;
		}
		return item;
	}
	
	public E peek(){
		if(head == null){
			throw new RuntimeException("Stack is empty");
		}
		return head.val;
	}
	public boolean empty(){
		if(head == null){
			return true;
		}
		
		return false;
	}
}

class ListNode<E> {
    public E val;
    public ListNode<E> next;
    public ListNode(E x) {
  	  val = x; 
  	  next = null;
    }    
}
