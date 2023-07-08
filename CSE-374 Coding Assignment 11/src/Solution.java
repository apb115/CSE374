import java.util.HashMap;
/*
 * Name: Andrew Boothe
 * Assignment: CSE-374 Coding Assignment 11
 * Date: 11/19/2022
 * Goal: Make sure string follows a pattern
 */

class Solution {
	public boolean wordPattern(String pattern, String s) { 
		String[] words = s.split(" "); // splits phrase into a bunch of words
		if (s.isEmpty()) return false; // no matching pattern if string is empty
		if (words.length != pattern.length()) return false; // no matching pattern if there are more or less words than pattern chars

		// stores a word and pattern char as key value pair
		HashMap<String, Character> patternHash = new HashMap<>();
		
		// loops through both word and pattern and makes sure each letter pattern is in line with pattern		
		for (int i = 0; i < pattern.length(); i++) {
			if (patternHash.containsKey(words[i]) == false) { 
				if (patternHash.containsValue(pattern.charAt(i)) == false) patternHash.put(words[i], pattern.charAt(i)); // adds key value if it follows pattern
				else if (patternHash.containsValue(pattern.charAt(i)) == true) return false; // does not follow pattern
				else { if(pattern.charAt(i) != patternHash.get(words[i])) return false; } // does not follow pattern
			}
			else { if(pattern.charAt(i) != patternHash.get(words[i])) return false; } // does not follow pattern
		}
		return true; // phrase follows pattern
	}
	
	// For testing
//	public static void main(String[] args) {
//		String pattern = "abba";
//		String s = "dog cat cat dog";
//		System.out.println(wordPattern(pattern, s));
//	}
}

