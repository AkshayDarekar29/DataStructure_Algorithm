package sorting;

import java.util.Arrays;

public class BubbleSortAlgo {
	public static void main(String[] args) {
		int [] arr = {12,55,1,3,31,98,89,5};
		
		System.out.println("before sorting: " + Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("aftter sorting: " + Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		int temp;
		boolean swapped;
		for (int i = 0; i < arr.length; i++) {
			swapped = false;
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[j]>arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
					swapped = true;
				}
			}
			
			if(!swapped){
				break;
			}
		}	
	}

}
