package creaturerace;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/*
 * Used to control and play out the creature race
 */
public class Race implements RaceInterface {

	private char[] track;
	private Creature[] creaturesArr;

	private int MONKEY_MAX = 4;
	private int OSTRICH_MAX = 5;
	private int TURTLE_MAX = 2;
	
	private ArrayList<String> toManyNames;
	
	public Race() {
		overTheTopNames();
	}
	
	/*
	 * Used to have as many random names as possible.
	 */
	public void overTheTopNames() {
		toManyNames = new ArrayList<>();		
		try {
			File f = new File("C:\\Users\\justi\\CSCI_Projects\\personal_projects\\JavaExamples\\projectReworks\\creaturerace\\namesList");
			Scanner scan = new Scanner(f);
			
			while(scan.hasNext()) {
				toManyNames.add(scan.next());
			}	
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}	
	}
	
	@Override
	public char[] getRacetrack() { // Returns a char array representing the race track
		return track;
	}

	@Override
	public String getRacerName(int racerIndex) {// Returns the name of the racer at the given index
		return creaturesArr[racerIndex].getName();
	}

	@Override
	public int getRacerPosition(int racerIndex) { // Returns the position of the racer at the given index
		return creaturesArr[racerIndex].getCurrentPos();
	}

	@Override
	public boolean getRacerIsWinner(int racerIndex) { // Returns whether or not the racer at the given index is a winner
		return (track[racerIndex] == '|');
	}
	
	/*
	 * For each iteration of advance on turn this checks if any creature in the array is at the finish line
	 * if so return false meaning the game is over. 
	 */
	public boolean gameOver() {
		for (int i = 0; i < creaturesArr.length; i++) {
			if (getRacerIsWinner(creaturesArr[i].getCurrentPos())) 
				return true;
		}
		return false;
	}

	@Override
	public void createRace(int length, int numRacers) { // Creates the race track of the given length and instantiates
														// ‘numRacers’ number of racers
		// Possible Terrains
		char[] terrain = { '.', '#', 'O', '~' }; // Open Plains, Forest, Lake, and Desert respectively
		// new track
		track = new char[length];
		// Random For terrain selection
		Random r = new Random();

		for (int i = 0; i < length - 1; i++) {
			track[i] = terrain[r.nextInt(terrain.length)]; // Each element of new track (Except for the last) is a
															// randomly generated index from the terrain to choose from
		}

		track[length - 1] = '|'; // Finish line

		///////////////////////////////////////////////Track//////////////////////////////////////////////
		///////////////////////////////////////////////Done///////////////////////////////////////////////

		// Creature Instantiation
		String[] names = { "Chad", "Ray", "Simba", "Signh", "Mamba", "Lulu", "Sly", "Sleek", "Chimp", "Zumba" }; // Possible Small List of Names
																													
		
		creaturesArr = new Creature[numRacers];

		for (int i = 0; i < numRacers; i++) {

			int c = r.nextInt(3) + 1; // Number of creatures but nextInt is exclusive on the Upper Bound
			String capName= toManyNames.get(r.nextInt(toManyNames.size())).toLowerCase();
			String name= capName.substring(0,1).toUpperCase() + capName.substring(1,capName.length());
			
			switch (c) {
			case 1: // Monkey
				creaturesArr[i] = new Monkey(name, MONKEY_MAX, track, 0); //If using small name list do (names[r.nextInt(names.length)]
				break;
			case 2: // Ostrich
				creaturesArr[i] = new Ostrich(name, OSTRICH_MAX, track, 0);//If using small name list do (names[r.nextInt(names.length)]
				break;
			case 3: // Turtle
				creaturesArr[i] = new Turtle(name, TURTLE_MAX, track, 0);//If using small name list do (names[r.nextInt(names.length)]
				break;
			default:
				System.out.println("Error No Creature to create");
				break;
			}
		}

	}
	
	@Override
	public void advanceOneTurn() { // Causes each racer to take one turn, moving a number of spaces based on their
									// movement speed and the terrain
		Random r = new Random();

		for (int i = 0; i < creaturesArr.length; i++) {
			creaturesArr[i].move(r.nextInt(creaturesArr[i].maxSpeed) + 1);
		}

	}

	/*
	 * This determines what creature the animal is by using instance of, and then formats it correctly.
	 * The -25 represents that the words are left justified (Creature instance name starts at side of console)
	 * and the 25 represents the width between the string and any characters after it.
	 */
	public void printAll() {
		for (int i = 0; i < creaturesArr.length; i++) {
			Creature c = creaturesArr[i];
			String format = "%-25s";	
			String creature = "";
			
			if (c instanceof Monkey) 		creature = "Monkey";
			else if (c instanceof Ostrich)  creature = "Ostrich";
			else 							creature = "Turtle";
				
			
			String p = (creature + " (" + c.getName() + ") " + (i + 1) + ":"); //Get given creature and Name and index
			if(c.getCurrentPos() == 0)
				System.out.printf("%-24s", p);
			else
				System.out.printf(format, p); //Print these values
			printTrack(c); //Print the track with the correct flag

		}
		findAndPrintWinners();
	}

	/*
	 * This is used to print the track and correctly display the flag based 
	 * on the creature it is passed. The special formatting here is knowing 
	 * that when a creature is displayed at a given index we use the <> symbol
	 * meaning we need less room on either side so that they stay centered. Thus,
	 * we have an else if for if the next character is flag we need less room so 
	 * that it will stay aligned. 
	 */	
	public void printTrack(Creature c) {
		String format = "%-2s%-2s";

		for (int i = 0; i < track.length; i++) {
			if (i == c.getCurrentPos()) {
				String p = ("<" + track[i] + ">");
				System.out.printf(format, p, "");
				
			} else if(i + 1 == c.getCurrentPos()) {
				String p = (track[i] + "");
				System.out.printf("%-2s%-1s", p, "");
			} else {
				String p = (track[i] + "");
				System.out.printf(format, p, "");
			}
		}
		System.out.print("\n");
		
		
	}

	/*
	 * This is used to iterate through all the creatures final positions and
	 * determine whether or not the given creature is a winner, if so print the name. 
	 */
	public void findAndPrintWinners() {
		System.out.println("\nWinner(s)");
		for (int i = 0; i < creaturesArr.length; i++) {
			if (getRacerIsWinner(creaturesArr[i].currentPos)) {
				System.out.println(creaturesArr[i].name);
			}
		}
	}
	
	
	//Change to dictionary method so we can avoid n^2
	public void displayOrder() {
		System.out.println();
		int count = 1;
			for(int j = creaturesArr.length-1 ; j >= 0; j--) {
				for(int i = 0; i < creaturesArr.length; i++) {
					if(creaturesArr[i].getCurrentPos() == j)
						System.out.print(count + ". " + creaturesArr[i].getName() + " ");
				}
				count++;
			}
	}
	
	public void averageWinner(int length, int numRacers, int loops) {
		double m = 0, o = 0, t = 0, tie = 0;//counts for each loop
		int tM = 0, tO = 0, tT = 0; //count total amounts of animals each time
		for(int i = 0; i < loops ; i++) {
			
			ArrayList<Creature> winArr = new ArrayList<>();
			
			createRace(length, numRacers);
			while(!gameOver()) 
				advanceOneTurn(); 
			for(int j = 0; j < creaturesArr.length; j++) {
				Creature c = creaturesArr[j];
					if (c instanceof Monkey) 		tM++; //monkey
					else if (c instanceof Ostrich)  tO++; //ostrich 
					else /*(must be turtle)*/		tT++; //turtle 
				if(getRacerIsWinner(c.getCurrentPos())) 
					winArr.add(c);
			}
			
			// Eliminate ties 
			if(winArr.size() > 1) tie++; //More than one winner must mean tie
			else {
				if (winArr.get(0) instanceof Monkey) 		m++; //monkey
				else if (winArr.get(0) instanceof Ostrich)  o++; //ostrich 
				else /*(must be turtle)*/					t++; //turtle 
			}
			
			System.out.println("\nGame " + (i+1) + " is over, resuts are: \n");
			printAll();
		}
		
		String format = "%-15s %15.2f%% %3s %d %s%n";  
		String postPercentage = "of the time, With a total of";
		System.out.println("\nThe totals are: ");
		System.out.printf(format, "One Monkey won:", (m/loops) * 100, postPercentage, tM, "Monkey's");
		System.out.printf("%-15s %14.2f%% %3s %d %s%n", "One Ostrich won:", (o/loops) * 100, postPercentage, tO, "Ostrich's");
		System.out.printf(format, "One Turtle won:", (t/loops) * 100, postPercentage, tT, "Turtle's\n");
		System.out.printf(format, "It was a Tie: ", (tie/loops) * 100, postPercentage, (int) tie, "Tie's");
		
	}

}
