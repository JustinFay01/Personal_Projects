package examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/*
 * You are also given a 0-indexed 2D integer array restrictions, where
 * restrictions[i] = [xi, yi] means that person xi and person yi cannot become
 * friends, either directly or indirectly through other people.
 * 
 * Initially, no one is friends with each other. You are given a list of friend
 * requests as a 0-indexed 2D integer array requests, where requests[j] = [uj,
 * vj] is a friend request between person uj and person vj.
 * 
 * A friend request is successful if uj and vj can be friends. Each friend
 * request is processed in the given order (i.e., requests[j] occurs before
 * requests[j + 1]), and upon a successful request, uj and vj become direct
 * friends for all future friend requests.
 * 
 * Return a boolean array result, where each result[j] is true if the jth friend
 * request is successful or false if it is not.
 * 
 * Note: If uj and vj are already direct friends, the request is still
 * successful.
 * 
 * 
 */
public class FriendRequest {
	
	private String fileRestriction;
	private String fileRequest;
	private int people;
	
	public FriendRequest(int people, String fileRestriction, String fileRequest) {
		this.people = people;
		this.fileRestriction = fileRestriction;
		this.fileRequest = fileRequest;
		
	}
	
	public boolean[] run() throws FileNotFoundException{
		int[][] restrictions = readInput(fileRestriction);
		int[][] requests = readInput(fileRequest);
		
		boolean[] result = makeRequest(people, restrictions, requests);
		
		return result;
	}
	
	/*
	 * Print results
	 */
	public void printBoolean(boolean[] bool) {
		  System.out.println(Arrays.toString(bool));  
	}


		//How to get method using lambda
	
//	int[] getColumn(int[][] matrix, int column) {
//	    return IntStream.range(0, matrix.length)
//	        .map(i -> matrix[i][column]).toArray();
//	}
	public boolean[] makeRequest(int n, int[][] restrictions, int[][] requests) {
	      boolean[] result = new boolean[requests.length];
			//Set up restriction matrix
	        //check restriction matrix to see if they can be accepted
	        int[][] restrictionMatrix = new int[n][n];
	        
	        //Initalize and make it so you cant add yourself
	        for(int i = 0; i < restrictionMatrix.length; i++){
	            for(int j = 0; j < restrictionMatrix[0].length; j++){
	                if(j == i)
	                    restrictionMatrix[i][j] = 2;
	                else    
	                    restrictionMatrix[i][j] = 0;
	            }
	        }

	        //Fill restrictions
	        for(int i = 0; i < restrictions.length; i++){
	            restrictionMatrix[restrictions[i][0]][restrictions[i][1]] = 1;
	            restrictionMatrix[restrictions[i][1]][restrictions[i][0]] = 1;
	        }

	         int count = 0;
	         
	        //Check if friend can be added
	         for(int i = 0; i < requests.length; i++){
	             
	            int req = requests[i][0];
	            int requested = requests[i][1];
	               
	                if(restrictionMatrix[req][requested] == 0){
	                    result[count++] = true;

	                    //when added change the requesters restrictions 
	                    //to the requested restrictions as well
	                    for(int c = 0; c < restrictionMatrix[0].length; c++){
	                        if(restrictionMatrix[req][c] == 1 && restrictionMatrix[requested][c] != 1 && req != c){
	                            restrictionMatrix[requested][c] = 1;
	                            restrictionMatrix[c][requested] = 1;
	                        }
	                        if(restrictionMatrix[requested][c] == 1 && restrictionMatrix[req][c] != 1 && requested != c){
	                          
	                            restrictionMatrix[req][c] = 1;
	                            restrictionMatrix[c][req] = 1;

	                        }        
	                    }
	                }
	            else
	                result[count++] = false;
	        }
			
			return result;

	    }
	
	/**
	 * Get how many lines are in file
	 */
	public int getLines(File file) {
		int lineTotal = 0;
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				lineTotal++;
				scan.next();
				}
		}
			catch (FileNotFoundException e) {
				System.out.println("File not found");
			}
		if(lineTotal == 0) {
			System.out.println("Nothing in file: " + file);
			return -1;
		}
		return lineTotal;
		}
	
	
	
	
	
	/**
	 * Sets a new file base don the fileName passed from the User Interface. 
	 * Then initializes the 2D array. Scanner reads the file while a next line is available
	 * and stores the according split strings into the correct row and column. This is done 
	 * while catching a file not found exception. 
	 */
	public int[][] readInput(String files) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(files);
		int n = getLines(file);
		
		int[][] req = new int[n][2];
		try {
			Scanner scan = new Scanner(file);
			String[] line = new String[16];
			
			while (scan.hasNextLine()) {
				for (int row = 0; row < req.length; row++) {
					line = scan.nextLine().trim().split(",");
					for (int col = 0; col < req[0].length; col++) {
						
						req[Integer.valueOf(row)][Integer.valueOf(col)] = Integer.valueOf(line[col]);
					}
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return req;

	}
	
	
	/*
	 * Check if the 2D array is correct
	 */
	public void checkInput(String files) {
		try {
			
		 int[][] req = readInput(files);
		 System.out.println(Arrays.deepToString(req));
		 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
