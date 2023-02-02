package examples.misc;

import java.util.Arrays;

public class KnapSack {

	// USED FOR MF KNAPSACK
	private static int[] weights = { 0, 1, 6, 2, 2, 2, 5, 4, 1 };
	private static int[] values = { 0, 1, 4, 3, 6, 1, 8, 10, 2 };
	public static int capacity = 11;
	public static int[][] sack = new int[values.length][capacity];

	public static void main(String[] args) {
		loadSack(); //fil with -1's
		MFKnapsack(weights.length - 1, capacity-1);//Start in the bottom right square
		print2D(sack);
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		//By Hand Example
		loadSack();
		for(int i = 1; i < weights.length; i++) {
			for(int j = 1; j < capacity; j++) {
				MFKnapsack(i,j);
			}
		}
		print2D(sack);
	}

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
		
		System.out.println("Weights: " + Arrays.toString(weights));
		System.out.println("Values: " + Arrays.toString(values) + '\n');
		
		for (int[] row : arr) {
			// converting each row as string
			// and then printing in a separate line
			//System.out.println(Arrays.toString(row));
			for(int i = 0; i < row.length; i++) {
				if(i == 0)
					System.out.print("[" +row[i] + ", ");
				else if(i + 1 != row.length) {
					System.out.print("\t" +row[i] + ", ");
				}
				else {
					System.out.print("\t" + row[i] + "]");
				}
			}
			System.out.println();
		}
	}

}
