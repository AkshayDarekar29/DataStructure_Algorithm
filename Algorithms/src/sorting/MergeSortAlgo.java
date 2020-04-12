package sorting;

import java.util.Arrays;

public class MergeSortAlgo {
	public static void main(String[] args) {
		int [] arr = {12,55,1,3,31,98,89,5};
		
		System.out.println("before sorting: " + Arrays.toString(arr));
		mergeSort(arr,0,arr.length-1);
		System.out.println("aftter sorting: " + Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr,int l, int r) {
		if(l<r){
			int m = (l + r)/2;
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for (int i = 0; i < L.length; i++) {
			L[i] = arr[l+i];
		}
		for (int i = 0; i < R.length; i++) {
			R[i] = arr[m+i+1];
		}
		
		int i = 0, j = 0;
		
		int k = l;
		
		while(i < n1 && j < n2){
			if(L[i]<=R[j]){
				arr[k] = L[i];
				i++;
			}else{
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		System.out.println(Arrays.toString(arr));
		
		while(i<n1){
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j<n2){
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}
