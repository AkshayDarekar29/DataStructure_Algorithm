package sorting;

import java.util.Arrays;

public class CountingSortAlgo {
	public static void main(String[] args) {
		int [] arr = {7,4,2,5,1,2,0,7,4, 8,1,10,15,11,20,5};
		
		System.out.println("before sorting: " + Arrays.toString(arr));
		countingSort(arr,0,20);
		System.out.println("aftter sorting: " + Arrays.toString(arr));
	}

	private static void countingSort(int[] arr,int start, int end) {
		int [] copyArr = Arrays.copyOf(arr, arr.length);
		
		int range = end-start+1;
		int [] rangeArr = new int[range];
		
		for (int i = 0; i < copyArr.length; i++) {
			rangeArr[copyArr[i]] += 1;
		}
		System.out.println(Arrays.toString(rangeArr));
		for (int i = 0; i < rangeArr.length-1; i++) {
			rangeArr[i+1] = rangeArr[i+1] + rangeArr[i];
		}
		System.out.println(Arrays.toString(rangeArr));
		for (int i = 0; i < copyArr.length; i++) {
			rangeArr[copyArr[i]] = rangeArr[copyArr[i]] -1;
			arr[rangeArr[copyArr[i]]] = copyArr[i];
		}
		
	}
}
