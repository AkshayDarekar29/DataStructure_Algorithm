package sorting;

import java.util.Arrays;

public class QuickSortAlgo {
	public static void main(String[] args) {
		int [] arr = {12,55,1,3,31,98,89,5};
		
		System.out.println("before sorting: " + Arrays.toString(arr));
		quickSort(arr,0,arr.length-1);
		System.out.println("aftter sorting: " + Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int p, int r) {
		if(p < r){
			int q = partition(arr, p, r);
			quickSort(arr,p,q-1);
			quickSort(arr,q+1,r);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low -1;
		
		for (int j = low; j < high; j++) {
			if(arr[j] <= pivot){
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,high);
		return i+1;
	}

	private static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
