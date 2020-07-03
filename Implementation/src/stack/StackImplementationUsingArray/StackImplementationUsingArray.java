package stack.StackImplementationUsingArray;

import java.util.Stack;

public class StackImplementationUsingArray<E> {
	
	private E [] internalArray;
	private int topOfStack;
	public StackImplementationUsingArray(){
		internalArray = (E[]) new Object[5];
	}
	
	public E push(E item){
		if(topOfStack == internalArray.length){
			throw new StackOverflowError();
		}else{
			internalArray[topOfStack++] = item;
		}
		return item;
	}
	
	public E pop(){
		if(topOfStack == 0){
			throw new RuntimeException("stack is empty");
		}else{
			return internalArray[--topOfStack];
		}
	}
	
	public E peek(){
		if(topOfStack == 0){
			throw new RuntimeException("stack is empty");
		}else{
			return internalArray[topOfStack-1];
		}
	}
	public boolean empty(){
		if(topOfStack == 0){
			return true;
		}
		return false;
	}
	public boolean isFull(){
		if(topOfStack == internalArray.length){
			return true;
		}
		return false;
	}
}
