package candygame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Controller {

	private CandyGame game;

	//set orignal vals null, so when restarting the loop they arent reset (could be local variables)
	private int numOfStudents; 
	private int smallestNumOfPieces;
	private int largeNum;
	private int printSelect;

	private boolean printAll;
	
	private Scanner sc;
	private Random rand;

	/*
	 * A constructor (with one CandyGame parameter) to instantiate the fields of the
	 * class which are: i. a CandyGame field, and ii. a Scanner field (for reading
	 * input from the user).
	 */
	public Controller(CandyGame game) {
		this.game = game;
		
		sc = new Scanner(System.in);
		rand = new Random();
		
		numOfStudents = -1;
		smallestNumOfPieces = -1;
		largeNum = -1;
		printSelect = -1;

		printAll = true;
	}

	/*
	 * A method named “playGame” (no parameters) that requests for required inputs
	 * from the user and, where applicable, passes these inputs to the CandyGame
	 * class as parameters to the corresponding methods. The playGame method also
	 * calls two other methods in its class (the Controller class) to obtain inputs
	 * from the user. These methods are: i. int getInt(int lowerLimit, int
	 * upperLimit) ii. int getEvenInt(int lowerLimit, int upperLimit).
	 */
	public void playGame() {
		
		boolean studentSet = false; //used to make sure we don't reset the number of students every time an error takes place in another place
		boolean minSet = false; //used so we dont reset the min value if an error takes place while setting large
		boolean largeSet = false; //used so we don't reset the largeset somehow. 
		
		int newLB = 0; //used so we can a get a random lower bound without effecting this loop
		
		while (true) {
			// Number of students being set and checked
			if (numOfStudents == -1) { //If value is -1 it must be the first time this is set so print starting message
				System.out.println("Getting the number of students.\n" + "Enter an integer in [15,30] inclusive:");
				numOfStudents = sc.nextInt();
			}
			if (numOfStudents > 30 || numOfStudents < 15) {
				System.out.println("Must be in [15, 30] inclusive! Re-enter:");
				numOfStudents = sc.nextInt();
				continue;
			} else if(!studentSet) {
				game.numberOfStudentsMutator(getInt(numOfStudents, 30));
				studentSet = true;
			}
				
			
			
			// Number of pieces being set and checked
			if (smallestNumOfPieces == -1) { //If value is -1 it must be the first time this is set so print starting message
				System.out.println("Getting the lower number of starting candy pieces from 4 to 10.\n"
						+ "Enter an even integer in [4, 10] inclusive:");
				smallestNumOfPieces = sc.nextInt();
			}
			if (smallestNumOfPieces % 2 > 0 || (smallestNumOfPieces > 10 || smallestNumOfPieces < 4)) {
				System.out.println("Must be EVEN and in [4, 10] inclusive! Re-enter:\n");
				smallestNumOfPieces = sc.nextInt();
				continue;
			} else if(!minSet){
				newLB = getEvenInt(smallestNumOfPieces, 10);
				minSet = true;
			}

			
			
			// Largest number of pieces being set and checked
			if (largeNum == -1) { //If value is -1 it must be the first time this is set so print starting message
				System.out.println("Getting the upper number of starting candy pieces.\r\n"
						+ "Must be even and greater than " + smallestNumOfPieces
						+ " (the lower number) but less than or equal to " + (50 + smallestNumOfPieces) + " (the\r\n"
						+ "lower number plus 50).\r\n" + "Enter an even integer in  [" + newLB + "," + (50 + smallestNumOfPieces) + "] inclusive:");
				largeNum = sc.nextInt();
			}
			if (largeNum % 2 > 0 || (largeNum > 50 + smallestNumOfPieces || largeNum < newLB)) {
				System.out.println("Must be EVEN and in [" + newLB + "," + (50 + smallestNumOfPieces)
						+ "] inclusive! Re-enter:");
				largeNum = sc.nextInt();
				continue;
			} else if(!largeSet){
				largeNum = getEvenInt(smallestNumOfPieces, largeNum);
				largeSet = true;
			}
			
			
			//Everything except for Print Select is setup 
			//Distribute Candy between the upper and lower bounds
			System.out.println("The orginal deal is:\n");
			game.candyDistributor(newLB, largeNum);
			game.printFormatter(game.studentsArray);
		
		
			//Get Print Selection
			if(printSelect == -1) { //If value is -1 it must be the first time this is set so print starting message
				System.out.println("Do you want to print the status after each move? (1 for yes, 0 for no)\r\n"
						+ "Enter an integer in [0, 1] inclusive:");
				printSelect = sc.nextInt();		
			}
			else if(printSelect != 0 && printSelect != 1) {
				System.out.println("Must be either [0, 1] inclusive! Re-enter:");
				printSelect= sc.nextInt();
				continue;
			}//input has been selected 
			
			
			//Play the game! (print according to selection)
			while(game.checkGameOver()) {
				
				if(printSelect == 0) { // if 0 print on each iteration of loop
					printAll = false;
					game.passCandy();
				} else { //else print on each iteration
					game.passCandy();	
					game.printFormatter(game.studentsArray);	
				}
			}
			
			//If they didn't want print on each iteration this will print its final output
			if(!printAll)
					game.printFormatter(game.studentsArray);
			//end the game by breaking the loop when the loop after print
			if(!game.checkGameOver())
				break;
		}		
	}

	/*
	 * The method “getInt(int, int)” which requests an integer in the range from a
	 * lower limit to an upper limit (inclusive). Method getInt() should accept
	 * these two limits as parameters and return an integer representing the number
	 * of students playing the game.
	 */
	public int getInt(int lowerLim, int upperLim) {
		return rand.nextInt(upperLim) + lowerLim;
	}

	/*
	 * The method “getEvenInt(int, int)” which obtains and returns an even integer
	 * in the range from an even lower limit to an even upper limit (inclusive); the
	 * limits should be passed as parameters to this method.
	 */
	public int getEvenInt(int lowerLim, int upperLim) {
		int val = 1;
		while (val % 2 > 0)
			val = rand.nextInt(upperLim) + lowerLim;
		return val;
	}

}
