import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
	public static int[] insertionSort(int[] list,int N) {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] list3 = new int[list.length];
		for (int k = 0; k<list3.length; k++) {
			list3[k] = list[k];
		}
		steps.add(list3);
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
