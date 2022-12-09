package examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Example {

	public static void main(String[] args) {

	}
	
	//Determine if two strings are isomorphic using dictionary
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
            
            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both 
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }
        
        return true;
    }
	
	//Determine if two strings are subsequences
	 public boolean isSubsequence(String s, String t) {
	        if(s.length()==0 || s==null)
	            return true;
	        int sIndex=0,tIndex=0;
	        while(tIndex<t.length()){
	            if(t.charAt(tIndex)==s.charAt(sIndex)){
	                sIndex++;
	                if(sIndex==s.length())
	                    return true;
	                }
	                tIndex++;
	        }
	        return false;
	    }

	// Computing pivotIndex for Equilibrium Value
	public int pivotIndex(int[] nums) {
		int n = nums.length;
		int left[] = new int[n];
		// Compute all values of left
		for (int i = 1; i < n; i++) {
			left[i] = nums[i - 1] + left[i - 1];
		}
		// compute all possible values of right
		int right[] = new int[n];
		for (int i = n - 2; i >= 0; i--) {
			right[i] = nums[i + 1] + right[i + 1];
		}
		nums = null;
		// compare until they are equal or not
		for (int i = 0; i < n; i++) {
			if (left[i] == right[i])
				return i;
		}
		return -1;
	}


	// My Presorting 2 sum
	public int[] twoSum(int[] nums, int target) {

		Arrays.sort(nums);

		int[] solutions = new int[2];

		for (int i = 0; i < nums.length; i++) {
			solutions[1] = Arrays.binarySearch(nums, Math.abs(nums[i] - target));
			if (solutions[1] >= 0 && solutions[1] != i) {
				solutions[0] = i;
				System.out.println(solutions[0] + " " + solutions[1]);
				return solutions;
			}
		}
		return solutions;
	}

	// Fastest 2 sum while still returning the original indices
	public int[] twoSumMap(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap();
		int[] result = new int[2];
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num = nums[i];
			if (map.containsKey(target - num)) {
				result[0] = map.get(target - num);
				result[1] = i;
				return result;
			} else {
				map.put(num, i);
			}
		}
		return result;
	}

	// Haves are alike using binary search
	public static boolean halvesBinary(String s) {
		int[] vowel = { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' };
		int count1 = 0, count2 = 0;
		char[] str = s.toCharArray();
		for (int i = 0; i < str.length; i++) {
			if (i < str.length / 2) {
				if (binarySearch(vowel, str[i], 0, vowel.length - 1)) {
					count1++;
				}
			} else if (binarySearch(vowel, str[i], 0, vowel.length - 1))
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

	public static boolean binarySearch(int[] toSearch, int searching, int l, int r) {
		int mid = (l + r) / 2;
		if (searching == toSearch[mid])
			return true;
		else if (searching < toSearch[mid])
			return binarySearch(toSearch, searching, l, mid - 1);
		else if (searching > toSearch[mid])
			return binarySearch(toSearch, searching, mid + 1, r);
		else
			return false;
	}

}
