package queue.DesignCircularQueue;

public class DesignCircularQueue {
	int [] arr;
    int start;
    int topOfQueue;
    int size;
    public DesignCircularQueue(int k) {
        arr = new int[k];
        start = -1;
        topOfQueue = -1;
        size = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }else{
            if(start == -1){
                start = 0;
            }
            if(topOfQueue + 1 == size){
                topOfQueue = 0;
            }else{
                topOfQueue++;
            }
            arr[topOfQueue] = value;
        }
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }else{
            if (start == topOfQueue) { 
				start = topOfQueue = -1;
			}else if (start+1 == size) { 
				start=0;
			}else {
				start++;
			}
        }
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(topOfQueue != -1){
            return arr[start];
        }else{
            return -1;
        }
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(topOfQueue != -1){
            return arr[topOfQueue];
        }else{
            return -1;
        }
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(topOfQueue == -1){
           return true; 
        }
        return false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(topOfQueue + 1 == start ||(start == 0 && topOfQueue + 1 == size)){
            return true;
        }
        return false;
    }
}
