import java.util.*;
/*
 * Name: Andrew Boothe
 * Class: CSE-374
 * Date: 9/11/2022
 * Description: Code to output a merge sort of an array in normal and reverse order
 */
public class Solution {
	public static int[][] mergeSort(int[] list) { 
		// final 2D array to be printed
		int arr[][] = {{1,2},{3,4}};
		
		// makes second array to be sorted reversely
		int[] list2 = Arrays.copyOf(list, list.length);

		int[] spot1 = sort(list, 0, list.length-1);
		int[] spot2 = reverseSort(list2, 0, list.length-1);
		
		// stores results in 2D array
		arr[0] = spot1;
		arr[1] = spot2;
		
		return arr;
	}
	
	// merges divided arrays back together
	static void mergeBack(int[] list, int left, int right, int middle) {
		int lower = middle - left + 1;
		int higher = right - middle;

		int[] lowArray = splitLow(list, lower, left);
		int[] highArray = splitHigh(list, higher, middle);

		int i,j;
		int iterate = left;
		for (i=0,j=0; i<lower&&j<higher;) {
			if (lowArray[i]<=highArray[j]) {
				list[iterate] = lowArray[i];
				i++;
			} else {
				list[iterate] = highArray[j];
				j++;
			}
			iterate++;

		}
		// move miscellaneous elements back into list
		while (i < lower) {
			list[iterate] = lowArray[i];
			iterate++;
			i++;
		}
		while (j < higher) {
			list[iterate] = highArray[j];
			iterate++;
			j++;
		}
	}
	// merges divided arrays back together (reverse element order)
	static void reverseMergeBack(int[] list, int left, int right, int middle) {
		int lower = middle - left + 1;
		int higher = right - middle;

		int[] lowArray = splitLow(list, lower, left);
		int[] highArray = splitHigh(list, higher, middle);

		int i,j;
		int iterate = left;
		for (i=0,j=0; i<lower&&j<higher;) {
			if (lowArray[i]>=highArray[j]) {
				list[iterate] = lowArray[i];
				i++;
			} else {
				list[iterate] = highArray[j];
				j++;
			}
			iterate++;
		}
		// move miscellaneous elements back into list
		while (i < lower) {
			list[iterate] = lowArray[i];
			iterate++;
			i++;
		}
		while (j < higher) {
			list[iterate] = highArray[j];
			iterate++;
			j++;
		}
	}
	
	// splits array into sub-arrays
	static int[] splitLow(int[] list, int lower, int left) {
		int[] lowArray = new int[lower];

		for (int i = 0; i < lower; i++) {
			lowArray[i] = list[i+left];
		}

		return lowArray;
	}
	// splits array into sub-arrays
	static int[] splitHigh(int[] list, int higher, int middle) {
		int[] highArray = new int[higher];

		for (int i = 0; i < higher; i++) {
			highArray[i] = list[i+1+middle];
		}
		return highArray;
	}
	
	// combines all previous methods, sorts down to O(1) and merges back together
	static int[] sort(int[] list, int left, int right) {
		if (left<right) {
			int middle =left+(right-left)/2;
			// recursive sort
			sort(list, left, middle);
			sort(list, middle+1, right);

			mergeBack(list, left, right, middle);
		}
		return list;
	}
	// combines all previous methods, sorts down to O(1) and merges back together (reverse)
	static int[] reverseSort(int[] list, int left, int right) {
		if (left<right) {
			int middle =left+(right-left)/2;
			//recursive sort
			reverseSort(list, left, middle);
			reverseSort(list, middle+1, right);

			reverseMergeBack(list, left, right, middle);
		}
		return list;
	}
}