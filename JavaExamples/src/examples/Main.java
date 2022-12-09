package examples;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Algorithms algo = new Algorithms();
		
		int[][] bipartite = {{0,1},
				{0,2},
				{2,3},
				{1,2}
				};
		
		
		if(algo.isBipartite(4, bipartite))
			System.out.println("It is!");
		else
			System.out.println("NOPE");
		
		
		int[] numbers = {2000, 2, 45, 7, 750, 1000};

		int max = Arrays.stream(numbers).max().getAsInt();
		System.out.println(max);
		
		
		
		
	}

	
}
