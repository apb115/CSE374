import java.util.ArrayList;
import java.util.List;

// Name: Andrew Boothe
// Class: CSE-374 C
// Date: 11/30/2022
// Assignment: CSE-374 Coding Assignment 12

class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean tester = false;
		if (s.length() == 0) return true;

		// iterate through string
		for (int i = 1; i <= s.length(); i++) {

			// dictionary has a word matching substring of initial char list
			if (wordDict.contains(s.substring(0,i))) {
				// it continues to have matching words throughout whole word
				if (wordBreak(s.substring(i,s.length()), wordDict)) {
					tester = true;
				}
			}
		}
		// otherwise return false
		return tester;
	}

	//	public static void main(String[] args) {
	//		String x = "applepen";
	//		List<String> wordDict = new ArrayList<String>();
	//		wordDict.add("apple");
	//		wordDict.add("pen");
	//
	//		System.out.println(wordBreak(x,wordDict));
	//
	//		String y = "catsandog";
	//		List<String> wordDict2 = new ArrayList<String>();
	//		wordDict2.add("cats");
	//		wordDict2.add("dog");
	//		wordDict2.add("sand");
	//		wordDict2.add("and");
	//		wordDict2.add("cat");
	//
	//		System.out.println(wordBreak(y,wordDict2));
	//	}
}

