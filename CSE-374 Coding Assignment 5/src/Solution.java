import java.util.*;

/* Name: Andrew Boothe
 * Class: CSE-374
 * Date: 9/21/2022
 * Goal: Program that correctly outputs sorted arrays using heap sort
 */

/*
 Sorting Strategy: 
1. Build Max Heap from unordered array; 
2. Find maximum element A[1]; 
3. Swap elements A[n] and A[1]: 
now max element is at the end of the array! 
 */

public class Solution {
	// parent sorting class for 2D array output
	public int[][] sort(int[] list) { 
		// final 2D array to be printed
		int arr[][] = {{1,2},{3,4}};

		// reverses order of sort
		boolean reverse = false;

		// makes second array to be sorted reversely
		int[] list2 = Arrays.copyOf(list, list.length);

		// uses other methods for result
		int[] spot1 = heapSort(list, reverse);
		reverse = true;
		int[] spot2 = heapSort(list2, reverse);

		// stores results in 2D array
		arr[0] = spot1;
		arr[1] = spot2;

		// Deprecated for testing purposes
//		System.out.println(Arrays.toString(arr[0]));
//		System.out.println(Arrays.toString(arr[1]));

		return arr;
	}

	// builds max heap from unordered array
	public static int[] heapSort(int[] list, boolean reverse) {

		// first half of heap build
		int i = list.length/2;
		for (i=i-1; i>=0; i--) {
			// recursively developing heap
			heapify(list, list.length, i, reverse);
		}

		// brings largest or smallest value to end of array (top of tree, from back to front)
		for (i=list.length-1; i>0; i--) {
			// continuous swapping from heap sorts array here
			arraySwap(list, 0, i);
			heapify(list, i, 0, reverse);
		}

		return list;
	}

	//	Find maximum element A[1]; 
	//	Swap elements A[n] and A[1]: 
	public static void heapify(int[] list, int size, int root, boolean reverse) {
		// in max heap the largest node is the root (A[1])
		int large = root;

		// binary tree child node positions
		int left = 2*root+1;
		int right = 2*root+2;

		if (reverse == false) {
			// find the largest node between the children and root, then swap
			// In tree always start with left side
			if (left<size) {
				if (list[left]>list[large]) {
					// new largest node
					large = left;
				}
			}
			if (right<size) {
				if (list[right]>list[large]) {
					// new largest node
					large = right;
				}
			}	
			if (large != root) {
				// Swap A[n] and A[1]
				arraySwap(list, root, large);
				// recursive heapify
				heapify(list, size, large, reverse);
			}

		} else if (reverse == true) {
			// find the smallest node between the children and root, then swap
			// In tree always start with left side
			if (left<size) {
				if (list[left]<list[large]) {
					// new smallest node
					large = left;
				}
			}
			if (right<size) {
				if (list[right]<list[large]) {
					// new smallest node
					large = right;
				}
			}
			if (large != root) {
				// Swap A[n] and A[1]
				arraySwap(list, root, large);
				// recursive heapify
				heapify(list, size, large, reverse);
			}
		}


	}

	public static void arraySwap(int[] list, int a, int b) {
		int tmp = list[a];
		list[a] = list[b];
		list[b] = tmp;
	}

	// Deprecated for testing purposes
//	public static void main(String[] args) {
//		int[] list = {432, 432, 21, 2, 31, 25, 61};
//		int[] list = {12, 11, 13, 6, 5};
//		System.out.println(sort(list));
//	}
}