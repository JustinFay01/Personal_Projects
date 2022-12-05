package examples;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		loadSack();
		MFKnapsack(weights.length-1, capacity-1);
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
	
	// USED FOR MF KNAPSACK
		private static int[] weights = { 0, 3, 2, 1, 4, 5 };
		private static int[] values = { 0, 25, 20, 15, 40, 50 };
		public static int capacity = 7;
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

}
