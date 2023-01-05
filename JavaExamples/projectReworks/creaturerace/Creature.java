package creaturerace;

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
	
	
	public abstract void move(int mp);
	
	public void skipTerrain() {
		while(currentPos + 1 < track.length && (track[currentPos] == track[currentPos + 1])) {
			currentPos++;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public int getCurrentPos() {
		return currentPos;
	}
	
	public char[] getTrack() {
		return track;
	}
	

 }
