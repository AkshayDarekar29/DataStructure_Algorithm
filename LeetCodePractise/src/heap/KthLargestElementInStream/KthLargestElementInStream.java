package heap.KthLargestElementInStream;

import java.util.PriorityQueue;

/* Approach : Min Heap
 * Time Complexity : nLog(k)
 * Space Complexity : O(k)
 */
public class KthLargestElementInStream {
	final PriorityQueue<Integer> q;
    final int k;
    public KthLargestElementInStream(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }
}
