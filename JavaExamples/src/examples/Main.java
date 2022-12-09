package examples;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Algorithms algo = new Algorithms();
		
		int[][] bipartite = {{0,1},
				{0,2},
				{2,3},
				};
		
		algo.print2D(bipartite);
		//A Goes to B
		
		//A goes to C
//		bipartite[1][0] = 0;
//		bipartite[1][1] = 2;
//		
//		//C Goes to D
//		bipartite[2][0] = 2;
//		bipartite[2][1] = 3;
		
		if(algo.isBipartite(4, bipartite))
			System.out.println("It is!");
		else
			System.out.println("NOPE");
		
		
		
		
	}

	
}
