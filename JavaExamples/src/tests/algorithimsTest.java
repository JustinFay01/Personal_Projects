package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import examples.Algorithims;

class algorithimsTest {

	@Test
	void coinRowTest() {
		Algorithims algo = new Algorithims();
		
		int[] C = new int[8];
		C[0] = -1;
		C[1] = 5;
		C[2] = 1;
		C[3] = 2;
		C[4] = 10;
		C[5] = 6;
		C[6] = 2;
		
		
		int[] F = algo.coinRowProblem(C);
		System.out.println("Original: "+ Arrays.toString(C));
		System.out.println("  Solved: "+ Arrays.toString(F));
		//assertTrue(Arrays.equals(F, F));
		
		C[0] = -1;
		C[1] = 6;
		C[2] = 2;
		C[3] = 3;
		C[4] = 9;
		C[5] = 11;
		C[6] = 8;
		C[7] = 5;
		
		F = algo.coinRowProblem(C);
		System.out.println("Original: "+ Arrays.toString(C));
		System.out.println("  Solved: "+ Arrays.toString(F));
	}
	
	@Test
	void recursiveFibTest() {
		Algorithims algo = new Algorithims();
		System.out.println(algo.fib(40));
	}
	@Test
	void itFibTest() {
		Algorithims algo = new Algorithims();
		System.out.println(algo.fibIT(60));
	}

}
