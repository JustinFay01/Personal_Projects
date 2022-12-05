package examples;

import java.util.ArrayList;
import java.util.Arrays;

public class Algorithims {
	
	
/**
 * Start with empty set of edges A of minimal spanning tree G	
 * 
 * At each step the algorithim adds an edege uv to A so that the set A union uv is a subset 
 * of some minimum spanning tree. Such an edge uv is called a safe edge, because we can safley add it 
 * to the set A and still continue
 * 
 * MST(G)
 * A = emptyElisy
 * While ! Is SpanningTree (G,A) (add n-1 edges makes it a spanning tree assuming everything else is right)
 * 	e =  SafeEdge(G,A)
 * Insert(A, e)	
 * return a
 * 
 * 
 * how to find safe edge? 
 * A safe edge is an edge that you can add that is still a minimum spanning tree 
 * 
 * 
 * Start at some vertex 
 * 
 * Kruskal-MST(G)
 * 
 * A=EmptySet
 * ForAll v in V[G]
 * 	create_set(v)
 * SortAscending(E[G])
 * ForAll edges e = (u,v)
 * 	If Set(u) != Set(v)
 * 		Insert (A, e)
 * 		Set_Union(u,v)
 * Return A
 * 
 */
	

	
///////////////////////////////START OF KNAP SACK//////////////////////////////////////////////
	/*
	 * Use the memory function saver for the Knap Sack problem
	 * 
	 * Implements the memory function method for the knapsack problem
	 * 
	 * Input: A nonnegative integer i indicating the number of the first items being
	 * considered and a non negative integer j indicating the knap sack capacity
	 * 
	 * Output: The value of an optimal feasible subset of the first i items Note:
	 * Use global variables input arrays Weights[1...n] Values[1...n] and the table
	 * F[0..n], 0..W] whose entries are initialized with -1's except for row 0
	 * column 0 initialized with 0's
	 * 
	 * WHEN USING MAKE SURE WEIGHTS AND VALUES HAS AN EXTRA 0 AT THE START OF ARRAYS
	 * TO MAKE ROOM FOR THE 0'th CAPCITY COLUMN AND ROW START IN BOTTOM RIGHT CORNER
	 * 
	 * 
	 * Run like:
	 * loadSack();
	 *	MFKnapsack(weights.length-1, capacity-1);
	 *	print2D(sack);
	 */
	public static int MFKnapsack(int i, int j) {
		int value = 0;
		if (sack[i][j] < 0) {
			if (j < weights[i]) {

				value = MFKnapsack(i - 1, j);
			} else {
				if (MFKnapsack(i - 1, j) > values[i] + MFKnapsack(i - 1, j - weights[i])) {

					value = MFKnapsack(i - 1, j);
				} else {
					value = values[i] + MFKnapsack(i - 1, j - weights[i]);
				}

			}
			sack[i][j] = value;
		}
		return sack[i][j];
	}
	
	// USED FOR MF KNAPSACK
		private static int[] weights = { 0, 2, 1, 3, 2 };
		private static int[] values = { 0, 12, 10, 20, 15 };
		public static int capacity = 6;
		public static int[][] sack = new int[values.length][capacity];
		// USED FOR MFKNAPSACK

		public static void loadSack() {
			for (int i = 0; i < sack.length; i++) {
				for (int j = 0; j < sack[0].length; j++) {
					if (i == 0 || j == 0)
						sack[i][j] = 0;
					else
						sack[i][j] = -1;
				}
			}
		}
		
		public static void print2D(int arr[][]) {
			// Loop through all rows
			for (int[] row : arr)

				// converting each row as string
				// and then printing in a separate line
				System.out.println(Arrays.toString(row));
		}
///////////////////////////////END OF KNAP SACK//////////////////////////////////////////////
		
		
	public boolean binarySearch(int[] toSearch, int searching, int l, int r) {
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

	/**
	 * return nth number in the fibonacci sequence
	 */
	public int fib(int n) {
		if (n <= 1)
			return n;
		 else  // recursive case
			return fib(n - 2) + fib(n - 1);
	}
	
	/*
	 * Iterative Fib
	 */
	public int fibIT(int n) {
		if(n <= 1) return n;
		else {
	
			int[] fib = new int[n+1];
			fib[0] = 0;
			fib[1] = 1;
			
			for(int i = 2; i <= n; i++) {
				fib[i] = fib[i-1] + fib[i-2];
				
			}	
			return fib[n];
		}
		
	}
	
	
	/*
	 * Iterative Fib
	 */
	public int fibITInPlace(int n) {
		if(n <= 1) return n;
		
		else {
			int fib0 = 0;
			int fib1 = 1;
			int fibn = 0;
			
			for(int i = 2; i <= n; i++) {
				fibn = fib0 + fib1;
				
				int tmp = fib1;
				fib1 = fibn;
				fib0 = tmp;
				
			}	
			return fibn;
		}
	}

	/*
	 * Solve Coin row problem using dynamic programming
	 */
	public int[] coinRowProblem(int[] C) {
		int[] F = new int[C.length];
		F[0] = 0;
		F[1] = C[1];
		for (int i = 2; i < F.length; i++) {
			if (C[i] + F[i - 2] > F[i - 1])
				F[i] = C[i] + F[i - 2];
			else
				F[i] = F[i - 1];
		}
		return F;
	}
	
	public int[][] transitiveClosure(int[][] restrictionMatrix) {
		int[][] r = restrictionMatrix;

		for (int row = 0; row < r.length; row++) {
			for (int col = 0; col < r[0].length; col++) {
				if (r[col][row] == 1) {
					for (int k = 0; k < r.length; k++) {
						if (r[col][row] == 1 && r[row][k] == 1)
							r[col][k] = 1;
					}
				}
			}
		}
		return r;

	}

	public void displayTC(int V, int[][] tc) {
		System.out.println("\nTransitive closure :\n");
		System.out.print(" ");
		for (int v = 0; v < V; v++)
			System.out.print("   " + v);
		System.out.println();
		for (int v = 0; v < V; v++) {
			System.out.print(v + " ");
			for (int w = 0; w < V; w++) {
				if (tc[v][w] == 1)
					System.out.print("  * ");
				else
					System.out.print("    ");
			}
			System.out.println();
		}
	}

}
