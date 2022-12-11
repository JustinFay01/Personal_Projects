package examples.misc;

import java.util.Arrays;
import java.util.Has

public class KnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		loadSack();
		MFKnapsack(weights.length-1, capacity-1);
		print2D(sack);
		
		for(int i = 0; i < capacity-1; i++) {
			for(int j = 0; j < weights.length-1; j++) {
				MFKnapsack(i,j);
			}
			print2D(sack);
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
	
	// USED FOR MF KNAPSACK
		private static int[] weights = { 0, 1, 6, 2, 2, 2, 5, 4, 1 };
		private static int[] values = { 0, 1, 4, 3, 6, 1, 8, 10, 2 };
		public static int capacity = 11;
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
