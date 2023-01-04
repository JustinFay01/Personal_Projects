package candygame;

public class CandyGame {
	
	int[] studentsArray;
 	
	public CandyGame() {
		
	}

	/*
	 * A mutator for the number of students; this accepts an int parameter (the
	 * number of students to play the game) which it uses to instantiate the array
	 * that represents the students.
	 */
	public void numberOfStudentsMutator(int numberOfStudents) {
		studentsArray = new int[numberOfStudents];
	}

	/*
	 * A method that generates and returns a random, even number of candy pieces
	 * within the range specified by the two parameters passed to this method.
	 */
	public int randCandyGenerator(int lowerLim, int upperLim) {
		int candy = 0;

		return candy;
	}

	/*
	 * A method that will distribute a number of pieces of candy to students
	 * (represented by an array of integers). The number given to each “student”
	 * must be random, even, and between two specified even limits inclusive. You
	 * will need to pass the lower and upper limits as parameters to this method.
	 */
	public int[] candyDistributor(int lowerLim, int upperLim) {

	}

	/*
	 * A method to print an array of integers on one line using a field width of
	 * size 4 for each integer.
	 */
	public void printFormatter(int[] arr) {

	}

	/*
	 * A method that will pass the candy as described in the game. In essence, you
	 * are using an array to represent a circle. Half of each value in the array
	 * should be added to the value in the next position in the array (next position
	 * or index => current index plus one), but half of the last value should be
	 * added to the value at index zero.
	 */
	public int[] passCandy(int arr) {

	}

	/*
	 * A method to test whether or not the game is over. It should return true if
	 * all values in the array are the same at the end of a move; otherwise, it
	 * should return false.
	 */
	public boolean checkGameOver() {
		return true;
	}

}
