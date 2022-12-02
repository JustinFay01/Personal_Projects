package examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\justi\\git\\personal_projects\\GoodExamples\\src\\requests.txt");

		if (f.exists()) {
			System.out.println("exists");
		} else
			System.out.println("does not");

//		  try {
//		      File myObj = new File("filename.txt");
//		      if (myObj.createNewFile()) {
//		    	 System.out.println(myObj.getAbsolutePath());
//		        System.out.println("File created: " + myObj.getName());
//		      } else {
//		    	  System.out.println(myObj.getAbsolutePath());
//		        System.out.println("File already exists.");
//		      }
//		    } catch (IOException e) {
//		      System.out.println("An error occurred.");
//		      e.printStackTrace();
//		    }
		
		if(halvesAreAlike("textbook"))
			System.out.println("True");
		
		
		int[] vowel = { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
		if(binarySearch(vowel, 'E', 0, vowel.length-1))
			System.out.println("Found");
		else
			System.out.println("Not found");
	}
	
	//Haves are alike using binary search
	public static boolean halvesBinary(String s) {
		int[] vowel = { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
		int count1 = 0, count2 = 0;
		char[] str = s.toCharArray();
		for(int i = 0; i < str.length; i++) {
			if(i < str.length/2){
				if(binarySearch(vowel, str[i], 0, vowel.length-1)) {
					count1++;
				}		
			}
			else if(binarySearch(vowel, str[i], 0, vowel.length-1))
				count2++;
		}
		return (count1 == count2);
	}
	
		public static boolean binarySearch(int[] toSearch, int searching, int l, int r) {
			int mid = (l+r)/2;
			if(searching == toSearch[mid])
				return true;
			else if(searching < toSearch[mid])
				return binarySearch(toSearch, searching,l, mid-1);
			else if(searching > toSearch[mid])
				return binarySearch(toSearch, searching, mid+1, r);
			else
				return false;
		}
		

	// If to haves of a string have the same amount of vowels
	// Uses binary search to look for values based on ASCII values
	//
	public static boolean halvesAreAlike(String s) {
		int[] vowel = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		int count1 = 0, count2 = 0;
		for (int i = 0; i < s.length() / 2; i++) {
			for (int j = 0; j < vowel.length; j++)
				if (s.charAt(i) == vowel[j])
					count1++;
		}
		for (int i = s.length() / 2; i < s.length(); i++) {
			for (int j = 0; j < vowel.length; j++)
				if (s.charAt(i) == vowel[j])
					count2++;
		}
		return count1 == count2;
	}

	

//Largest element in array quickly (binary search style)
	public static int largest(int s[], int l, int r) {
		int mid = 0;
		if (l == r)
			return l;
		else {
			mid = (r + l) / 2;
			int lLarge, rLarge;
			lLarge = rLarge = 0;

			lLarge = largest(s, l, mid);
			rLarge = largest(s, mid + 1, r);

			if (s[lLarge] >= s[rLarge])
				return lLarge;
			else
				return rLarge;
		}
	}

	/*
	 * Find a sum of perfect
	 */
	public static int sumOfSquares(int x, int n) {
		int sum = 0;
		for (int i = 0; i < x; i++) {
			sum += x;
			System.out.println(x);
		}
		if (x == n) {
			return sum;
		} else
			System.out.println(sum);

		return sumOfSquares(++x, n) + sum;
	}

	/**
	 * return nth number in the fibonacci sequence
	 */
	public static int fib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else { // recursive case
			return fib(n - 2) + fib(n - 1);
		}
	}

	public static int findPower(int x, int y) {
		if (y == 0) {
			return 1;
		} else if (y == 1) {
			return x;
		} else {
			return x * findPower(x, y - 1);
		}
	}

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	// DO IT BACKWARDS
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
	 * Reverse words and use trim statement to delete extra white space
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
