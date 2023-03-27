package examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs {

	/////////////////// MIMIMUM SUM PATH//////////////////////////
	/*
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right, which minimizes the sum of all numbers along its path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 */
	public int minPathSum(int[][] grid) {
		int rows = grid.length; // Initialize rows and cols
		int cols = grid[0].length;

		int[][] sums = new int[rows + 1][cols + 1]; // New graph of one larger to included infinity on outside

		// fill graph with infinity
		for (int i = 0; i < rows + 1; i++) {
			for (int j = 0; j < cols + 1; j++) {
				sums[i][j] = Integer.MAX_VALUE;
			}
		}
		// evalute sums
		// For this program we begin at the base case which is the bottom right of the
		// graph. Because of this, we want to the set our sums graph (which will
		// eventually hold the answer) at the index beneath our starting point the value
		// of zero. (sums[rows - 1][cols] = 0) This will allow our formula to work. 
		// The formula we are using is sum(i,j)=grid[i][j]+min(sum(i+1,j), sum(i,j+1))
		// At the end of this process the sums graph at location [0][0] will hold the final 
		// mimum path sum. 
		sums[rows - 1][cols] = 0;
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 0; j--) {
				sums[i][j] = grid[i][j] + Math.min(sums[i + 1][j], sums[i][j + 1]);
			}
		}
		for (int[] sum : sums) {
			System.out.println(Arrays.toString(sum));
		}

		// The best solution resides in the 0th slot
		return sums[0][0];
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////// DFS//////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private int white = 0;
	private int grey = 1;
	private int black = 2;
	private int time;

	public int[][] DFS(int[][] G) {
		// row 1 = Predecessor
		// row 2 = distance from start
		// row 3 = final time stamp
		// row 4 = color
		int[][] result = new int[4][G.length];

		// Setting all colors to white and predecessor to null
		for (int i = 0; i < G.length; i++) {
			result[0][i] = -1;
			result[3][i] = white;
		}
		// start time
		time = 1;
		// for each vertex in the graph
		for (int i = 0; i < G.length; i++) {
			// if the color is white visit the node
			if (result[3][i] == white)
				DFSVisit(G, result, i);
		}

		return result;
	}

	public int[][] DFSVisit(int G[][], int[][] result, int v) {
		// set to grey
		result[3][v] = grey;
		// first time stamp is distance from start
		result[1][v] = time++;
		// for all vertices adjacent to v
		for (int i = 0; i < G.length; i++) {
			// if the there is an edge from this vertex
			if (G[v][i] == 1) {
				// If that vertex that is connected to is white
				if (result[3][i] == white) {
					// set its predecessor to the current vertex
					result[0][i] = v;
					// visit that vertex
					DFSVisit(G, result, i);
				}
			}
		}
		// Set color black
		result[3][v] = black;
		// Set final time stamp
		result[2][v] = time++;

		return result;
	}

	public static void printDFS(int arr[][]) {
		System.out.println("\t\tA\tB\tC\tD\tE\tF\tG\tH");
		System.out.println("\t     -------------------------------------------------------------");
		int count = 0;
		for (int[] row : arr) {
			for (int i = 0; i < row.length; i++) {
				if (i == 0) {
					switch (count) {
						case 0:
							System.out.print("Predecessor: |");
							break;
						case 1:
							System.out.print("Distance:    |");
							break;
						case 2:
							System.out.print("Final:       |");
							break;
						case 3:
							System.out.print("Color:       |");
							break;
					}
					count++;

					System.out.print("[" + row[i] + ", ");
				} else if (i + 1 != row.length) {
					System.out.print("\t" + row[i] + ", ");
				} else {
					System.out.print("\t" + row[i] + "]");
				}
			}
			System.out.println();
		}
		System.out.println("\n\t\tPredecessor's are: ");
		for (int i = 0; i < arr[0].length; i++) {
			if (i == 0)
				System.out.print("\t\tNull = -1 ");
			System.out.print(((char) (i + 'A')) + " = " + i + " ");
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////// DFS//////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int[][] BFS(int G[][], int n) {
		HashMap<Integer, int[]> map = new HashMap<>();
		int white = 0;
		int grey = 1;
		int black = 2;

		for (int i = 0; i < n; i++) {
			int[] dpc = new int[3];
			dpc[0] = white;
			dpc[1] = Integer.MAX_VALUE;
			// dpc[2] is already set to null
			map.put(i, dpc);
		}

		// Start at 0
		Queue<Integer> Q = new LinkedList<>();

		return G;
	}

	public boolean isBipartite(int n, int edges[][]) {
		int[][] values = new int[n][n];

		for (int row = 0; row < edges.length; row++) {

			int from = edges[row][0];
			int to = edges[row][1];

			// Make sure edges are there
			values[from][to] = 3;
			values[to][from] = 3;

			// Color
			int fromGroup = values[from][from];
			int toGroup = values[to][to];

			// if neither have a value set
			if (fromGroup == 0 && toGroup == 0) {
				values[from][from] = 1;
				values[to][to] = 2;
			}

			// if one of them has a value set
			else if (fromGroup == 0 || toGroup == 0) {
				if (fromGroup == 1 || fromGroup == 2) {
					if (fromGroup == 1)
						values[to][to] = 2;
					else
						values[to][to] = 1;
				}
				if (toGroup == 1) {
					if (toGroup == 2) {
						values[from][from] = 1;
					} else
						values[from][from] = 2;
				}
			}
			// if they are equal
			else if (fromGroup == toGroup) {
				print2D(values);
				return false;
			}
		}
		print2D(values);
		return true;

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

	public static void print2D(int arr[][]) {
		// Loop through all rows

		for (int[] row : arr) {
			// converting each row as string
			// and then printing in a separate line
			// System.out.println(Arrays.toString(row));
			for (int i = 0; i < row.length; i++) {
				if (i == 0)
					System.out.print("[" + row[i] + ", ");
				else if (i + 1 != row.length) {
					System.out.print("\t" + row[i] + ", ");
				} else {
					System.out.print("\t" + row[i] + "]");
				}
			}
			System.out.println();
		}
	}

}
