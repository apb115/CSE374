import java.util.*;
// Andrew Boothe
// CSE 374 Coding Assignment 1
// 9/6/2022

/**
 * Goal: Develop an insertion sort algorithm that prints out the steps of the sort
 * at input of the user
 *
 * @author Andrew Boothe
 *
 */
public class Solution {
	public static int[] insertionSort(int[] list,int N) { 
		ArrayList<int[]> steps = new ArrayList<int[]>();
		for (int i = 1; i < list.length; i++) {
			int key = list[i];
			int j = i-1;
			while (j >= 0 && list[j] > key) {
				list[j+1] = list[j];
				j = j -1;			
				list[j+1] = key;
				int[] list2 = new int[list.length];
				for (int k = 0; k<list2.length; k++) {
					list2[k] = list[k];
				}
				steps.add(list2);
			}
		}
		return steps.get(N-1);
	}
}
