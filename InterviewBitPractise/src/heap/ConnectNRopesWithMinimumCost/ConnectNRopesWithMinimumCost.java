package heap.ConnectNRopesWithMinimumCost;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {
	
	
	/* Approach : MIn Heap
	 * Time Complexity : nLog(n)
	 * Space Complexity : O(n)
	 */
	public int solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int n : A){
            q.offer(n);
        }
        int length = 0;
        while(q.size() != 1 ){
            int x = q.poll();
            int y = q.poll();
            length += x+y;
            q.offer(x+y);
        }
        return length;
    }
	
}
