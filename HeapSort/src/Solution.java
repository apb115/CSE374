import java.util.Arrays;

public class Solution {
	public static String sort(int[] data) {

		return Arrays.toString(buildMaxHeap(data));
	}

	public static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;

		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		if (i != largest) {
			int tmp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = tmp;
			heapify(arr, n, largest);
		}
	}

	public static int[] buildMaxHeap(int[] arr) {
		for (int j = arr.length/2 -1; j >= 0; j--) {
			heapify(arr, arr.length, j);
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;

			heapify(arr, i, 0);
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] test = {5, 7, 2, 3, 4, 1, 6};
		System.out.println(sort(test));
	}
}
