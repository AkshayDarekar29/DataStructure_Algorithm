package queue.LinearQueueUsingArray;

public class LinearQueueUsingArray<E> {
	E [] array;
	int topOfQueue = 0;
	int beginningOfQueue = 0;
	LinearQueueUsingArray(){
		array = (E[]) new Object[5];
	}
	
	public boolean add(E item){
		if(topOfQueue == array.length){
			throw new IllegalStateException("Queue is full");
		}else{
			array[topOfQueue++] = item;
		}
		return true;
	}
	
	
	public E poll(){
		E item;
		if(beginningOfQueue >= topOfQueue){
			beginningOfQueue = 0;
			topOfQueue = 0;
			item = null;
		}else{
			item = array[beginningOfQueue++];
		}
		
		return item;
	}
	
	public E peek(){
		E item;
		if(topOfQueue == 0){
			item = null;
		}else{
			item = array[beginningOfQueue];
		}
		return item;
	}
	
	public boolean isEmpty(){
		return topOfQueue == 0;
	}
	
	public boolean isFull(){
		return topOfQueue == array.length;
	}
}
