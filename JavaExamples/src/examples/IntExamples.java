package examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IntExamples {

	public static void main(String[] args) {

	}

	/*
	 * You are given a 0-indexed integer array tasks, where tasks[i] represents the
	 * difficulty level of a task. In each round, you can complete either 2 or 3
	 * tasks of the same difficulty level.
	 * 
	 * Return the minimum rounds required to complete all the tasks, or -1 if it is
	 * not possible to complete all the tasks.
	 * 
	 * EXAMPLE: Input: tasks = [2,2,3,3,2,4,4,4,4,4] Output: 4 Explanation: To
	 * complete all the tasks, a possible plan is: - In the first round, you
	 * complete 3 tasks of difficulty level 2. - In the second round, you complete 2
	 * tasks of difficulty level 3. - In the third round, you complete 3 tasks of
	 * difficulty level 4. - In the fourth round, you complete 2 tasks of difficulty
	 * level 4. It can be shown that all the tasks cannot be completed in fewer than
	 * 4 rounds, so the answer is 4.
	 */
	public int minimumRounds(int[] tasks) {
		Map<Integer, Integer> freq = new HashMap();
		// Store the frequencies in the map.
		for (int task : tasks) {
			freq.put(task, freq.getOrDefault(task, 0) + 1); // getOrDefault Returns the value to which the specified key
															// is mapped, or defaultValue if this map contains no
															// mapping for the key.
		}

		int minimumRounds = 0;
		// Iterate over the task's frequencies.
		for (int count : freq.values()) {
			// If the frequency is 1, it's not possible to complete tasks.
			if (count == 1) {
				return -1;
			}

			if (count % 3 == 0) {
				// Group all the task in triplets.
				minimumRounds += count / 3;
			} else {
				// If count % 3 = 1; (count / 3 - 1) groups of triplets and 2 pairs.
				// If count % 3 = 2; (count / 3) groups of triplets and 1 pair.
				minimumRounds += count / 3 + 1;
			}
		}

		return minimumRounds;
	}

	/*
	 * You are given an array prices where prices[i] is the price of a given stock
	 * on the ith day.
	 * 
	 * You want to maximize your profit by choosing a single day to buy one stock
	 * and choosing a different day in the future to sell that stock.
	 * 
	 * Return the maximum profit you can achieve from this transaction. If you
	 * cannot achieve any profit, return 0.
	 */
	// Time O(n)
	// Space O(1)
	public int maxProfit(int[] prices) {
		int prof = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min)
				min = prices[i];
			else if (prices[i] - min > prof)
				prof = prices[i] - min;
		}

		return prof;
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

	/**
	 * 
	 * Given an array of integers nums and an integer target, return indices of the
	 * two numbers such that they add up to target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 * 
	 * You can return the answer in any order.
	 */

	// My Pre-sorting 2 sum
	// Dosen't work since we need to return original indices and the array has been
	// sorted
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

	/*
	 * Given an array of integers nums and an integer target, return indices of the
	 * two numbers such that they add up to target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 * 
	 * You can return the answer in any order.
	 */
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
	 * Find a sum of perfect squares
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

}
