package sorting;

import java.util.Arrays;

public class SelectionSortAlgo {
	public static void main(String[] args) {
		int [] arr = {12,55,1,3,31,98,89,5};
		
		System.out.println("before sorting: " + Arrays.toString(arr));
		//selectionSort(arr,0,arr.length);
		selectionSort2(arr);
		System.out.println("aftter sorting: " + Arrays.toString(arr));
	}

	private static void selectionSort2(int[] arr) {
		int temp;
		int minPos;
		for (int i = 0; i < arr.length; i++) {
			minPos = i;
			for (int j = i+1; j < arr.length;  j++) {
				if(arr[j] < arr[minPos] ){
					minPos = j;
				}
			}
			temp = arr[minPos];
			arr[minPos] = arr[i];
			arr[i] = temp;
		}
		
	}

	private static void selectionSort(int[] arr, int beg, int end) {
		
		int min = Integer.MAX_VALUE;
		int minPos = 0;
		int temp;

		for (int i = beg; i < arr.length; i++) {
			if(arr[i] < min ){
				min = arr[i];
				minPos = i;
			}
		}
		System.out.println("min : " + min );
			
		if(minPos != 0){
			temp = arr[beg];
			arr[beg] = arr[minPos];
			arr[minPos] = temp;
		}
		beg ++;
		if(beg < end){
			selectionSort(arr, beg, end);
		}	
	}
}
