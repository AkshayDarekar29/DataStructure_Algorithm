package sorting;

import java.util.Arrays;

public class InsertionSortAlgo {
	public static void main(String[] args) {
		int [] arr = {12,55,1,3,31,98,89,5};
		
		System.out.println("before sorting: " + Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("aftter sorting: " + Arrays.toString(arr));
	}

	private static void insertionSort(int[] arr) {
		int temp;
		boolean flag;
		for (int i = 1; i < arr.length; i++) {
			flag =false;
			/*for (int j = i; j > 0; j--) {
				if(arr[j] < arr[j-1]){
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}else{
					flag = true;
				}
			}*/
			int j = i;
			while(j>0){
				if(arr[j] < arr[j-1]){
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}else{
					flag = true;
				}
				System.out.println("iteration: "+ i + " of "+ (i - j + 1) + ":" + Arrays.toString(arr));
				j--;
				if(flag){
					break;
				}	
			}
		}
	}
}
