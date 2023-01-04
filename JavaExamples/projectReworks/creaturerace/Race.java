package creaturerace;

import java.util.Random;

public class Race implements RaceInterface {

	private char[] track;
	private int numRacers;
	
	@Override
	public char[] getRacetrack() { //Returns a char array representing the racetrack
		return track;
	}

	@Override
	public String getRacerName(int racerIndex) {//Returns the name of the racer at the given index
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRacerPosition(int racerIndex) {	//Returns the position of the racer at the given index
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getRacerIsWinner(int racerIndex) {	//Returns whether or not the racer at the given index is a winner
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createRace(int length, int numRacers) {	//Creates the racetrack of the given length and instantiates ‘numRacers’ number of racers
		//Possible Terrains
		char[] terrain = { '.', '#', 'O', '~'};
		//new track 
		track = new char[length];
		//Random For terrain selection
		Random r = new Random();
		
		for(int i = 0; i < length - 1; i++) {
			track[i] = terrain[r.nextInt(terrain.length)]; //Each element of new track (Except for the last) is a randomly generated index from the terrain to choose from
		}
		
		track[length - 1] = '|'; //Finish line
		
		this.numRacers = numRacers; //Instantiate numRacers
		
	}

	@Override
	public void advanceOneTurn() {	//Causes each racer to take one turn, moving a number of spaces based on their movement speed and the terrain
		
		
	}

}
