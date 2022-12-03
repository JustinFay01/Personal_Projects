package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import examples.FriendRequest.FriendRequest;


class friendRequestTest {

	@Test
	void case1() {
	
		String case1res = "C:\\Users\\justi\\eclipse-workspace\\personal_projects\\JavaExamples\\src\\tests\\friendRequestDocs\\case1res.txt";
		String case1req = "C:\\Users\\justi\\eclipse-workspace\\personal_projects\\JavaExamples\\src\\tests\\friendRequestDocs\\case1req.txt";
		
		FriendRequest fb = new FriendRequest(3, case1res, case1req);

		System.out.println("Case 1 ");
		System.out.println("Restrictions: ");
		fb.checkInput(case1res);
		System.out.println("Requests: ");
		fb.checkInput(case1req);
		
		System.out.println("Results: ");
		
		try {
			boolean[] result = fb.run();
			fb.printBoolean(result);
			boolean[] answers = answerArray("C:\\Users\\justi\\eclipse-workspace\\personal_projects\\JavaExamples\\src\\tests\\friendRequestDocs\\case1Answers.txt",result.length);
			
			assertArrayEquals(result,answers);
			
			System.out.println("Answers:");
			fb.printBoolean(answers);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		printSeparator();
	}
	
	@Test
	void case2() {
		String case2res = "C:\\Users\\justi\\eclipse-workspace\\personal_projects\\JavaExamples\\src\\tests\\friendRequestDocs\\case2res.txt";
		String case2req = "C:\\Users\\justi\\eclipse-workspace\\personal_projects\\JavaExamples\\src\\tests\\friendRequestDocs\\case2req.txt";
		
		FriendRequest fb = new FriendRequest(5, case2res, case2req);
		
		
		System.out.println("Case 2 ");
		System.out.println("Restrictions: ");
		fb.checkInput(case2res);
		System.out.println("Requests: ");
		fb.checkInput(case2req);
		
		System.out.println("Results: ");
		
		try {
			boolean[] result = fb.run();
			fb.printBoolean(result);
			
			boolean[] answers = answerArray("C:\\Users\\justi\\eclipse-workspace\\personal_projects\\JavaExamples\\src\\tests\\friendRequestDocs\\case2Answers.txt",result.length);
			System.out.println("Answers:");
			fb.printBoolean(answers);
			assertArrayEquals(result,answers);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printSeparator();
	}
	
	@Test
	void case3() {
		String case3res = "C:\\Users\\justi\\eclipse-workspace\\personal_projects\\JavaExamples\\src\\tests\\friendRequestDocs\\case3res.txt";
		String case3req = "C:\\Users\\justi\\eclipse-workspace\\personal_projects\\JavaExamples\\src\\tests\\friendRequestDocs\\case3req.txt";
		
		FriendRequest fb = new FriendRequest(18, case3res, case3req);
		
		System.out.println("Case 3 ");
		System.out.println("Restrictions: ");
		fb.checkInput(case3res);
		System.out.println("Requests: ");
		fb.checkInput(case3req);
		
		System.out.println("Results: ");
		
		try {
			boolean[] result = fb.run();
			fb.printBoolean(result);
			
			boolean[] answers = answerArray("C:\\Users\\justi\\eclipse-workspace\\personal_projects\\JavaExamples\\src\\tests\\friendRequestDocs\\case3Answers.txt",result.length);
			
			System.out.println("Answers:");
			fb.printBoolean(answers);
			
			assertArrayEquals(result,answers);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		printSeparator();
	}
	
	
	
	
	public boolean[] answerArray(String fileName,int length) {
		boolean[] answers = new boolean[length];
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			
			while(scan.hasNext()) {
				
				String line = scan.next();
				String[] tmp = line.split(",");
				
				for (int i = 0; i < tmp.length; i++) {
					if(tmp[i].equals("true")) {
						answers[i] = true;
					}
					else {
						answers[i] = false;
					}
				}
			}
			
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return answers;
	}

	
	void printSeparator() {
		int i = 0;
		for (i = 0; i < 80; i++) {
			System.out.print("=");
		}	
		System.out.println();
	}
}
