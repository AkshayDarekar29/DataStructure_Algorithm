package queue.LinearQueueUsingLinkedList;

public class Driver {
	public static void main(String[] args) {
		LinearQueueUsingLinkedList<Integer> queue = new LinearQueueUsingLinkedList<>();
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println(queue.dequeue());
		queue.enqueue(3);
		queue.enqueue(4);
		System.out.println(queue.peek());
		
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
	}
}
