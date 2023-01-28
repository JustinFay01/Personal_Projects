package projectReworks.creaturerace;

public abstract class Creature {

	String name;
	int maxSpeed;
	char[] track;
	int currentPos;

	public Creature(String name, int maxSpeed, char[] track, int currentPos) {
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.track = track;
		this.currentPos = currentPos;
	}
	
	//Forces each creature subclass to have their own implementation of the move method according to the rules
	public abstract void move(int mp);

	//Used to skip over terrain that they have already entered
	public void skipTerrain() {
		while (currentPos + 1 < track.length && (track[currentPos] == track[currentPos + 1])) {
			currentPos++;
		}
	}
	
	//returns creatures name
	public String getName() {
		return name;
	}
	//returns creatures maximum speed
	public int getMaxSpeed() {
		return maxSpeed;
	}
	//returns the creatures current index on the track
	public int getCurrentPos() {
		return currentPos;
	}
	//Returns reference to the track
	public char[] getTrack() {
		return track;
	}

}
