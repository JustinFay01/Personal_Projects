package projectReworks.creaturerace;

/*
 * Outlines implementation for Race class
 */
public interface RaceInterface {
	// Returns a char array representing the racetrack
	char[] getRacetrack();

	// Returns the name of the racer at the given index
	String getRacerName(int racerIndex);

	// Returns the position of the racer at the given index
	int getRacerPosition(int racerIndex);

	// Returns whether or not the racer at the given index is a winner
	boolean getRacerIsWinner(int racerIndex);

	// Creates the racetrack of the given length and instantiates �numRacers� number
	// of racers
	void createRace(int length, int numRacers);

	// Causes each racer to take one turn, moving a number of spaces based on their
	// movement speed and the terrain
	void advanceOneTurn();
}