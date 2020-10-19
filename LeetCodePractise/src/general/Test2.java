package general;

import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> q = new LinkedBlockingQueue<>(2);
		System.out.println(q.add(0));
		System.out.println(q.add(1));
		System.out.println(q.add(1));
		//q.put(2);
		System.out.println("Completed");
	}
}
