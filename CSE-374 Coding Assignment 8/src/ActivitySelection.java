import java.util.ArrayList;
import java.util.Arrays;
// Name: Andrew Boothe
// Class: CSE-374
// Assignment: Coding-8
// Goal: Get optimal paths from two arrays, start and finish (Greedy)
public class ActivitySelection {

    int[] findMaxActivities(int[] startTime, int[] finishTime) {
    	ArrayList<Integer> final1 = new ArrayList<>(); // ArrayList for final values 
    	int tmp = 0; // gets position of greedy cost
    	final1.add(tmp); // first position is always added because there is nothing better
        for (int i = 1; i < startTime.length; i++) {
        	if (startTime[i] >= finishTime[tmp]) { // if finish at previous position is <= start at current
        		tmp = i;
        		final1.add(tmp); // position gets added if it is the best greedy choice
        	}
        }
        // Converts ArrayList to Array for method purposes
        int[] finalAnswer = new int[final1.size()];
        for (int j = 0; j<finalAnswer.length; j++) {
        	finalAnswer[j] = final1.get(j);
        }
        return finalAnswer;
    }
    
    // For testing purposes
//    public static void main(String[] args) {
//		int[] start = {1,3,0,5,8,5};
//		int[] finish = {2,4,6,7,9,9};
//		
//		System.out.println(Arrays.toString(findMaxActivities(start, finish)));
//	}
}
