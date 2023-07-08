import java.util.ArrayList;
import java.util.Arrays;

public class Solution3 {
	
	public static int[] tester1() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] arr = {1, 2, 3, 4, 5};
		for (int i = 0; i < arr.length; i++) {
			arr[arr.length-1] = 0;
			steps.add(arr);
		}
		return steps.get(3);
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(tester1()));
	}
}
