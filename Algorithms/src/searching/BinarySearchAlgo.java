package searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchAlgo {
	public static void main(String[] args) {
		int [] arr = {1,2,4,5,8,10,19,25,46,89,96};
		System.out.println(Arrays.toString(arr));
		System.out.println("size of array is " + arr.length);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number:");
		int n = sc.nextInt();
		
		/*int mid = a.length/2;
		int oldLength = a.length;
		boolean flag = false;
		while(mid >= 0 && mid < a.length){
			if(n == a[mid]){
				flag = true;
				break;
			}else if(n > a[mid]){
				//int x = mid;
				mid = (oldLength + mid)/2;
				//oldLength = x;
			}else if(n < a[mid]){
				int x = mid;
				mid = mid/2;
				oldLength = x;
			}
			if(mid == 0){
				break;
			}
		}
		if(flag){
			System.out.println("Number is present at "+ mid);
		}else{
			System.out.println("Number is not present");
		}*/
		
		int location = binarySearch(arr, 0, arr.length, n);
		if(location == -1){
			System.out.println("Item is not present");
		}else{
			System.out.println("Item is present at position : "+ location);
		}
	}

	private static int binarySearch(int[] arr, int beg, int end, int item) {
		int mid;
		if(end >= beg){
			mid = (beg + end)/2;
			if(item == arr[mid]){
				return mid;
			}else if(item > arr[mid]){
				return binarySearch(arr, mid+1, end, item);
			}else {
				return binarySearch(arr, beg , mid-1, item);
			}
		}	
		return -1;
	}
}
