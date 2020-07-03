package stack.QueueUsingStack;


public class DriverClass {
	public static void main(String[] args) {
		QueueUsingStack_2 q =new QueueUsingStack_2();
		q.push(1);
		q.push(2);
		System.out.println(q.peek());
		System.out.println(q.pop());
		System.out.println(q.pop());

		System.out.println(q.empty());
	}
}
