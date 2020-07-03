package heap.FindMedianOfInputStream;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianOfInputStream {
	
	
	/* Approach : Using MinHeap and MaxHeap
	 * Time Complexity : Log(n)
	 * Space Complexity : O(n)
	 */
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public FindMedianOfInputStream() {
        
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        if (maxSize > minSize){
            return maxHeap.peek();
        }else{
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
    }
	
}