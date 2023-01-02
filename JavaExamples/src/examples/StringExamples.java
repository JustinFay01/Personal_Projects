package examples;

import java.util.*;

public class StringExamples {

	/*
	 * We define the usage of capitals in a word to be right when one of the
	 * following cases holds:
	 * 
	 * All letters in this word are capitals, like "USA". All letters in this word
	 * are not capitals, like "leetcode". Only the first letter in this word is
	 * capital, like "Google". Given a string word, return true if the usage of
	 * capitals in it is right.
	 * 
	 * 
	 */
	public boolean detectCapitalUse(String word) {
		int n = word.length();
		if (n == 1) {
			return true;
		}

		// case 1: All capital
		if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
			for (int i = 2; i < n; i++) {
				if (Character.isLowerCase(word.charAt(i))) {
					return false;
				}
			}
			// case 2 and case 3
		} else {
			for (int i = 1; i < n; i++) {
				if (Character.isUpperCase(word.charAt(i))) {
					return false;
				}
			}
		}

		// if pass one of the cases
		return true;
	}


	/*
	 * Given a pattern and a string s, find if s follows the same pattern.
	 * 
	 * Here follow means a full match, such that there is a bijection between a
	 * letter in pattern and a non-empty word in s.
	 */
	public boolean wordPattern(String pattern, String s) {
		HashMap<Character, String> map_char = new HashMap<>();
		HashMap<String, Character> map_word = new HashMap<>();
		String[] words = s.split(" ");

		if (words.length != pattern.length())
			return false;

		for (int i = 0; i < words.length; i++) {
			char c = pattern.charAt(i);
			String w = words[i];
			if (!map_char.containsKey(c)) {
				if (map_word.containsKey(w)) {
					return false;
				} else {
					map_char.put(c, w);
					map_word.put(w, c);
				}

			} else {
				String mapped_word = map_char.get(c);
				if (!mapped_word.equals(w))
					return false;
			}
		}

		return true;
	}

	/*
	 * Given two strings s and t, return true if s is a subsequence of t, or false
	 * otherwise.
	 * 
	 * A subsequence of a string is a new string that is formed from the original
	 * string by deleting some (can be none) of the characters without disturbing
	 * the relative positions of the remaining characters. (i.e., "ace" is a
	 * subsequence of "abcde" while "aec" is not).
	 */

	// Determine if two strings are subsequences
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0 || s == null)
			return true;
		int sIndex = 0, tIndex = 0;
		while (tIndex < t.length()) {
			if (t.charAt(tIndex) == s.charAt(sIndex)) {
				sIndex++;
				if (sIndex == s.length())
					return true;
			}
			tIndex++;
		}
		return false;
	}

	/*
	 * Given two strings s and t, determine if they are isomorphic.
	 * 
	 * Two strings s and t are isomorphic if the characters in s can be replaced to
	 * get t.
	 * 
	 * All occurrences of a character must be replaced with another character while
	 * preserving the order of characters. No two characters may map to the same
	 * character, but a character may map to itself.
	 * 
	 * 
	 */
	// Determine if two strings are isomorphic using dictionary
	public boolean isIsomorphic(String s, String t) {

		int[] mappingDictStoT = new int[256];
		Arrays.fill(mappingDictStoT, -1);

		int[] mappingDictTtoS = new int[256];
		Arrays.fill(mappingDictTtoS, -1);

		for (int i = 0; i < s.length(); ++i) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			// Case 1: No mapping exists in either of the dictionaries
			if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
				mappingDictStoT[c1] = c2;
				mappingDictTtoS[c2] = c1;
			}

			// Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping
			// exists and
			// it doesn't match in either of the dictionaries or both
			else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 
	 * You are given a string s of even length. Split this string into two halves of
	 * equal lengths, and let a be the first half and b be the second half.
	 * 
	 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i',
	 * 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and
	 * lowercase letters.
	 * 
	 * Return true if a and b are alike. Otherwise, return false.
	 */

	// Haves are alike using binary search
	public static boolean halvesBinary(String s) {
		Algorithms algo = new Algorithms(); // To use my own binary search algorithm

		int[] vowel = { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' };
		int count1 = 0, count2 = 0;
		char[] str = s.toCharArray();
		for (int i = 0; i < str.length; i++) {
			if (i < str.length / 2) {
				if (algo.binarySearch(vowel, str[i], 0, vowel.length - 1)) {
					count1++;
				}
			} else if (algo.binarySearch(vowel, str[i], 0, vowel.length - 1))
				count2++;
		}
		return (count1 == count2);
	}

	// Using sets and going forwards and backwards at same time
	public boolean halvesAreAlike(String s) {
		int start = 0;
		int end = 0;
		Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (set.contains(s.charAt(i))) {
				start++;
			}
			if (set.contains(s.charAt(j))) {
				end++;
			}
			i++;
			j--;
		}
		if (start == end) {
			return true;
		}
		return false;
	}

	// DO IT BACKWARDS
	// Convert Roman Numerals to letters
	public int romanToIntBetter(String s) {
		int ans = 0, num = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.charAt(i)) {
			case 'I':
				num = 1;
				break;
			case 'V':
				num = 5;
				break;
			case 'X':
				num = 10;
				break;
			case 'L':
				num = 50;
				break;
			case 'C':
				num = 100;
				break;
			case 'D':
				num = 500;
				break;
			case 'M':
				num = 1000;
				break;
			}
			if (4 * num < ans)
				ans -= num;
			else
				ans += num;
		}
		return ans;
	}

	/*
	 * Given an input string s, reverse the order of the words.
	 * 
	 * A word is defined as a sequence of non-space characters. The words in s will
	 * be separated by at least one space.
	 * 
	 * Return a string of the words in reverse order concatenated by a single space.
	 * 
	 * Note that s may contain leading or trailing spaces or multiple spaces between
	 * two words. The returned string should only have a single space separating the
	 * words. Do not include any extra spaces.
	 */
	public String reverseWords(String s) {

		s = s.trim().replaceAll(" +", " ");

		String[] str = s.split(" ");
		int j = str.length - 1;

		for (int i = 0; i < str.length / 2; i++, j--) {

			String tmp = str[j];
			str[j] = str[i];
			str[i] = tmp;
		}

		s = String.join(" ", str);
		return s;
	}
}
