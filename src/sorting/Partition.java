package sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Partition {
	
	public static int partitionLomuto(int[] arr,int low, int high) {
		int pivot = arr[high];
		int j = low;

		for(int i = low; i < high; i++){
			if(arr[i] < pivot){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}

		int temp = arr[j];
		arr[j] = arr[high];
		arr[high] = temp;

		return j;

	}
	
	/***********ANSWER QUESTION HERE*****************/
    /*
     * What sort of input arrays will enable Hoare’s algorithm to still create relatively 
     * equal size partitions whereas Lomuto’s algorithm will create unequal partitions?
     *
     * Arrays that have a lot of the same elements in a row, and arrays that have fully all equal elements.
     *
     */
	
	public static int partitionHoare(int[] arr,int low, int high) {

		int pivot = arr[low];
		int low_i = low - 1;
		int high_i = high + 1;

		while (true)
		{
			do {
				low_i++;
			} while (arr[low_i] < pivot);

			do {
				high_i--;
			} while (arr[high_i] > pivot);

			if (low_i < high_i) {
				int temp = arr[low_i];
				arr[low_i] = arr[high_i];
				arr[high_i] = temp;
			} else {
				return high_i;
			}
		}
	}


	public static void main(String [] args){
		int [] arr = new int[]{5,3,8,4,2,7,1,9};

		System.out.println(Partition.partitionHoare(arr, 0, arr.length-1));
		for(int a : arr) System.out.print(a + " ");
	}


}
