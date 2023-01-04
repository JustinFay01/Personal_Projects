package creaturerace;

public abstract class Creature {
	
	private String name;
	private int maxSpeed;
	private char[] track;
	private int currentPos;
	
	
	public Creature(String name, int maxSpeed, char[] track, int currentPos) {
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.track = track;
		this.currentPos = currentPos;
	}
	
	
	public abstract int move();
	
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
