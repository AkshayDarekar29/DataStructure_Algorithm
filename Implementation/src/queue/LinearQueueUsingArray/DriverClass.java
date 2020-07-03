package queue.LinearQueueUsingArray;

public class DriverClass {
	public static void main(String[] args) {
		LinearQueueUsingArray<Integer> queue = new LinearQueueUsingArray<>();
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		System.out.println(queue.isFull());
		System.out.println(queue.poll());
		System.out.println(queue.isFull());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
	}
}
