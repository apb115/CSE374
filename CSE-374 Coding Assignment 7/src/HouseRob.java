// Name: Andrew Boothe
// Assignment: CSE-374 Coding Assignment
// Date: 10/23/2022
// Description: Code that gives the most possible houses robbed
// 		without robbing adjacent houses
public class HouseRob {
	int rob(int[] houses) {
		// sends a call to method that can use length as recursive parameter
		return robHouses(houses, houses.length-1);
	}

	static int robHouses(int[] houses, int length) {
		// if the array length is 0 the only possible sum is 0
		if (length < 0) return 0;
		// if the array length is 1 the sum has to be that one value
		else if (length == 0) return houses[0];

		// makes a sum total of all the even array values
		int evens = robHouses(houses, length-2)+houses[length];
		// makes a sum total of all the odd array values
		int odds = robHouses(houses, length-1);

		// return the greater of the two
		if (evens > odds) return evens;
		else return odds;
	}

//	public static void main(String[] args) {
//		int houses[] = {2,7,9,3,1};
//		System.out.println(rob(houses)); // 12?
//	}
}
