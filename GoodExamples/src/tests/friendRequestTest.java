package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import examples.FriendRequest;


class friendRequestTest {

	@Test
	void case1() {
		String case1res = "C:\\Users\\justi\\git\\personal_projects\\GoodExamples\\src\\case1res.txt";
		String case1req = "C:\\Users\\justi\\git\\personal_projects\\GoodExamples\\src\\case1req.txt";
		String case1Answers = "C:\\Users\\justi\\git\\personal_projects\\GoodExamples\\src\\case1req.txt";
		FriendRequest fb = new FriendRequest(3, case1res, case1req);
		
		
		
		try {
			boolean[] result = fb.run();
			fb.printBoolean(result);
			assertTrue(result[0]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void case2() {
		String case2res = "C:\\Users\\justi\\git\\personal_projects\\GoodExamples\\src\\case2res.txt";
		String case2req = "C:\\Users\\justi\\git\\personal_projects\\GoodExamples\\src\\case2req.txt";
		FriendRequest fb = new FriendRequest(3, case2res, case2req);
		
		try {
			boolean[] result = fb.run();
			fb.printBoolean(result);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void case3() {
		
	}
	
	public boolean[] answerArray() {
			
	}


}
