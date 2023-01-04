package candygame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Controller {

	private CandyGame game;

	private int numOfStudents;
	private int smallestNumOfPieces;
	private int largeNum;

	private boolean printAll;

	/*
	 * A constructor (with one CandyGame parameter) to instantiate the fields of the
	 * class which are: i. a CandyGame field, and ii. a Scanner field (for reading
	 * input from the user).
	 */
	public Controller(CandyGame game) {
		this.game = game;

		numOfStudents = -1;
		smallestNumOfPieces = -1;
		largeNum = -1;

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
		Scanner sc = new Scanner(System.in);

		while (game.checkGameOver()) {
			// Number of students being set and checked
			if (numOfStudents == -1) {
				System.out.println("Getting the number of students.\n" + "Enter an integer in [15,30] inclusive:");
				numOfStudents = sc.nextInt();
			}
			if (numOfStudents > 30 || numOfStudents < 15) {
				numOfStudents = -1;
				System.out.println("Must be in [15, 30] inclusive! Re-enter:");
				numOfStudents = sc.nextInt();
				continue;
			} else {
				game.numberOfStudentsMutator(numOfStudents);
			}

			// Number of pieces being set and checked
			if (smallestNumOfPieces == -1) {
				System.out.println("Getting the lower number of starting candy pieces from 4 to 10.\n"
						+ "Enter an even integer in [4, 10] inclusive:");
				smallestNumOfPieces = sc.nextInt();
			}
			if (smallestNumOfPieces % 2 > 0 || (smallestNumOfPieces > 10 || smallestNumOfPieces < 4)) {
				System.out.println("Must be EVEN and in [4, 10] inclusive! Re-enter:\n");
				smallestNumOfPieces = sc.nextInt();
				continue;
			} else {
				smallestNumOfPieces = getEvenInt(smallestNumOfPieces, 10);
			}

			// Largest number of pieces being set and checked
			if (largeNum == -1) {
				System.out.println("Getting the upper number of starting candy pieces.\r\n"
						+ "Must be even and greater than " + smallestNumOfPieces
						+ " (the lower number) but less than or equal to " + (50 + smallestNumOfPieces) + " (the\r\n"
						+ "lower number plus 50).\r\n" + "Enter an even integer in [8, 56] inclusive:");
				largeNum = sc.nextInt();
			}
			if (largeNum % 2 > 0 || (largeNum > 50 + smallestNumOfPieces || largeNum < smallestNumOfPieces)) {
				System.out.println("Must be EVEN and in [" + smallestNumOfPieces + "," + (50 + smallestNumOfPieces)
						+ "] inclusive! Re-enter:");
				largeNum = sc.nextInt();
				continue;
			} else {
				largeNum = getEvenInt(smallestNumOfPieces, largeNum);
			}
		}
	}

	/*
	 * The method “getInt(int, int)” which requests an integer in the range from a
	 * lower limit to an upper limit (inclusive). Method getInt() should accept
	 * these two limits as parameters and return an integer representing the number
	 * of students playing the game.
	 */
	public int getInt(int lowerLim, int upperLim) {
		Random rand = new Random(upperLim);
		return rand.nextInt(upperLim) + lowerLim;
	}

	/*
	 * The method “getEvenInt(int, int)” which obtains and returns an even integer
	 * in the range from an even lower limit to an even upper limit (inclusive); the
	 * limits should be passed as parameters to this method.
	 */
	public int getEvenInt(int lowerLim, int upperLim) {
		Random rand = new Random(upperLim);
		int val = 1;
		while (val % 2 > 0)
			val = rand.nextInt(upperLim) + lowerLim;
		return val;
	}

	public boolean getPrintPreference() {
		return printAll;
	}
}
