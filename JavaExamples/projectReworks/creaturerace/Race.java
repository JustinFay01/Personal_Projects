package creaturerace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Race implements RaceInterface {

	private char[] track;
	private Creature[] creaturesArr;
	
	
	private int MONKEY_MAX = 4;
	private int OSTRICH_MAX = 5;
	private int TURTLE_MAX = 2;
	
	
	@Override
	public char[] getRacetrack() { //Returns a char array representing the racetrack
		return track;
	}

	@Override
	public String getRacerName(int racerIndex) {//Returns the name of the racer at the given index
		return creaturesArr[racerIndex].getName();
	}

	@Override
	public int getRacerPosition(int racerIndex) {	//Returns the position of the racer at the given index
		return creaturesArr[racerIndex].getCurrentPos();
	}
	
	@Override
	public boolean getRacerIsWinner(int racerIndex) {	//Returns whether or not the racer at the given index is a winner
		return (track[racerIndex] == '|');
	}
	
	public boolean gameOver() {
		for(int i = 0; i < creaturesArr.length; i++) {
			if(getRacerIsWinner(creaturesArr[i].getCurrentPos()))
				return true;
		}
		return false;
	}

	@Override
	public void createRace(int length, int numRacers) {	//Creates the race track of the given length and instantiates ‘numRacers’ number of racers
		//Possible Terrains
		char[] terrain = { '.', '#', 'O', '~'}; //Open Plains, Forest, Lake, and Desert respectively
		//new track 
		track = new char[length];
		//Random For terrain selection
		Random r = new Random();
		
		for(int i = 0; i < length - 1; i++) {
			track[i] = terrain[r.nextInt(terrain.length)]; //Each element of new track (Except for the last) is a randomly generated index from the terrain to choose from
		}
			
		track[length - 1] = '|'; //Finish line
		
		///////////////////////////////////////////////////Track Done///////////////////////////////////////////////
		
		//Creature Instantiation
		String[] names = { "Chad", "Ray", "Simba", "Signh", "Mamba", "Lulu", "Sly", "Sleek", "Chimp", "Zumba" }; //Possible Names
		creaturesArr = new Creature[numRacers];
		
		for(int i = 0; i < numRacers; i++) {
			
			int c = r.nextInt(3) + 1; //Number of creatures but nextInt is exclusive on the Upper Bound
			
			switch(c) {
			case 1: // Monkey
				creaturesArr[i] = new Monkey(names[r.nextInt(names.length)], MONKEY_MAX, track, 0);
				break;
			case 2: //Ostrich
				creaturesArr[i] = new Ostrich(names[r.nextInt(names.length)], OSTRICH_MAX, track, 0);
				break;
			case 3:  //Turtle
				creaturesArr[i] = new Turtle(names[r.nextInt(names.length)], TURTLE_MAX, track, 0);	
				break;
			default:
				System.out.println("Error No Creature to create");
				break;
			}
		}
		
	}

	@Override
	public void advanceOneTurn() {	//Causes each racer to take one turn, moving a number of spaces based on their movement speed and the terrain
		Random r = new Random();
		
		for(int i = 0; i < creaturesArr.length; i++) {
			creaturesArr[i].move(r.nextInt(creaturesArr[i].maxSpeed) + 1);
		}
		
	}
	
	public void printAll() {
		for(int i = 0; i < creaturesArr.length; i++) {
			Creature c = creaturesArr[i];
			String format = "%-25s";
			
			if(c instanceof Monkey) {
				String p = ("Monkey (" + c.getName() + ") " + (i + 1) + ":" );
				System.out.printf(format, p);
				
				printTrack(c);
			} else if(c instanceof Ostrich) {
				String p = ("Ostrich (" + c.getName() + ") " + (i + 1) + ":" );
				System.out.printf(format, p);
				
				printTrack(c);
			} else {
				String p = ("Turtle (" + c.getName() + ") " + (i + 1) + ":" );
				System.out.printf(format, p);
				
				printTrack(c);
			}
			
		}
	}
	
	public void printTrack(Creature c) {
		String format = "%4s";
		
		for(int i = 0; i < track.length; i++) {
			if(i == c.currentPos) {
				String p = ("<" + track[i] + ">");
				System.out.printf("%5s", p);
			}
			else {
				String p = (track[i] + "");
				System.out.printf(format, p);
			}
				
		}
		System.out.print("\n");
	}
	
	
	public void findAndPrintWinners() {
		System.out.println("\nWinner(s)");
		for(int i = 0; i < creaturesArr.length; i++) {
			if(getRacerIsWinner(creaturesArr[i].currentPos)) {
				System.out.println(creaturesArr[i].name);
			}
		}
	}

}
