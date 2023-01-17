package examples;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphs G = new Graphs();
		
		int[][] bipartite = {{0,1},
				{0,2},
				{2,3},
				};
		
		
		if(G.isBipartite(4, bipartite))
			System.out.println("It is!");
		else
			System.out.println("NOPE");
		
								//A B C D E F G H
		int[][] DFSGraph = {/*A*/{0,1,0,0,0,0,0,1},
							/*B*/{1,0,1,0,0,0,0,1},
							/*C*/{0,1,0,1,0,0,0,1},
							/*D*/{0,0,1,0,0,0,1,0},
							/*E*/{0,0,0,0,0,1,0,0},
							/*F*/{0,0,0,0,1,0,0,0},
							/*G*/{0,0,0,1,0,0,0,0},
							/*H*/{1,1,1,0,0,0,0,0}
							
		};
		
		Graphs.print2D(DFSGraph);
		
		System.out.println('\n');
		
		Graphs.printDFS(G.DFS(DFSGraph));
		
		
		IntExamples intPrac = new IntExamples();
		

		
		
		
			
	}

	
}
