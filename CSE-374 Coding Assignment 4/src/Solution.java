import java.util.*;
/*
 * Name: Andrew Boothe
 * Class: CSE-374
 * Date: 9/13/2022
 * Goal: Program that correctly outputs sorted arrays using
 * Quick Sort
 */

public class Solution {
	public int[][] sort(int[] list) { 
		// final 2D array to be printed
		int arr[][] = {{1,2},{3,4}};

		// reverses order of sort
		boolean reverse = false;

		// makes second array to be sorted reversely
		int[] list2 = Arrays.copyOf(list, list.length);

		// uses other methods for result
		int[] spot1 = quickSort(list, 0, list.length-1, reverse);
		reverse = true;
		int[] spot2 = quickSort(list2, 0, list.length-1, reverse);

		// stores results in 2D array
		arr[0] = spot1;
		arr[1] = spot2;

		return arr;
	}

	public static int partition(int[] list, int p, int r, boolean reverse) {
		// pivot will be at first position in this case
		int pivot = list[p];
		// element after pivot to check
		int j = p+1;

		// iterate through elements up until r (end of array)
		for (int i = j; i <= r; i++) {
			// forward or reverse?
			if (reverse == false) {
				// is the other position less than the pivot?
				if (list[i] < pivot) {
					// swap when not discussing same position
					if (i != j) {
						int tmp = list[j];
						list[j] = list[i];
						list[i] = tmp;
					}
					j++;
				}
			} else if (reverse == true) {
				// is the other position less than the pivot?
				if (list[i] > pivot) {
					// swap when not discussing same position
					if (i != j) {
						int tmp = list[j];
						list[j] = list[i];
						list[i] = tmp;
					}
					j++;
				}
			}
		}

		// swap pivot back to middle position (smaller elements left, greater elements right)
		list[p] = list[j-1];
		list[j-1] = pivot;

		// return new position of the pivot
		return j-1;
	}
	
	// similar to mergeSort with recursion)
	public static int[] quickSort(int[] list, int p, int r, boolean reverse) {
		if (p<r) {
			int q = 0;
			// send true reverse to partition?
			if (reverse == false) {
				// first and biggest partition
				q = partition(list, p, r, reverse);
			} else if (reverse == true) {
				// first and biggest partition
				q = partition(list, p, r, reverse);
			}
			//recursive sort
			quickSort(list, p, q-1, reverse);
			quickSort(list, q+1, r, reverse);
		}
		return list;
	}
}