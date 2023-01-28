package projectReworks.candygame;

import java.util.Random;

public class CandyGame {

	int[] studentsArray;

	public CandyGame() {}

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
		Random rand = new Random();
		int val = 1;
		while (val % 2 > 0)
			val = rand.nextInt(upperLim) + lowerLim;
		return val;
	}

	/*
	 * A method that will distribute a number of pieces of candy to students
	 * (represented by an array of integers). The number given to each �student�
	 * must be random, even, and between two specified even limits inclusive. You
	 * will need to pass the lower and upper limits as parameters to this method.
	 */
	public void candyDistributor(int lowerLim, int upperLim) {
		for(int i = 0; i < studentsArray.length; i++)
			studentsArray[i] = randCandyGenerator(lowerLim, upperLim);
	}
	

	/*
	 * A method to print an array of integers on one line using a field width of
	 * size 4 for each integer.
	 */
	public void printFormatter(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == 0)
				System.out.printf("%4s%4s", arr[i], "");
			else
				System.out.printf("%s%4s", arr[i], "");
		}
		System.out.println();
	}

	/*
	 * A method that will pass the candy as described in the game. In essence, you
	 * are using an array to represent a circle. Half of each value in the array
	 * should be added to the value in the next position in the array (next position
	 * or index => current index plus one), but half of the last value should be
	 * added to the value at index zero.
	 */
	public void passCandy() {
		// for the length of the array (except for zero case) if the we are at the end
		// of the array take the value and add it to the zeroth slot
		// take current i values candy and divide it by two (if it is odd on divide add
		// one)
		// take that value and add it to the next indices pile (if it is odd on add, add
		// one)
		int[] temp = new int[studentsArray.length];

		for (int i = 0; i < studentsArray.length; i++) {
			// Divide all pieces of candy in half into a temp array
			studentsArray[i] = temp[i] = studentsArray[i] / 2;
		}

		for (int i = 0; i < studentsArray.length; i++) {
			// if we are not at the start of the array
			if (i != 0) {
				// The current value of the students array is equal to the value plus its
				// previous temps value, the ? operator acts as a conditional
				// for if it is odd
				studentsArray[i] = (studentsArray[i] + temp[i - 1]) % 2 > 0 ? studentsArray[i] + temp[i - 1] + 1
						: studentsArray[i] + temp[i - 1];
			} else {
				studentsArray[0] = (studentsArray[0] + temp[studentsArray.length - 1]) % 2 > 0
						? studentsArray[0] + temp[studentsArray.length - 1] + 1
						: studentsArray[0] + temp[studentsArray.length - 1];
			}
		}

	}

	/*
	 * A method to test whether or not the game is over. It should return true if
	 * all values in the array are the same at the end of a move; otherwise, it
	 * should return false.
	 */
	public boolean checkGameOver() {
		for (int i = 0; i < studentsArray.length - 1; i++) {
			if (studentsArray[i] != studentsArray[i + 1])
				return true;
		}
		return false;
	}

}
