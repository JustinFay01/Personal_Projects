package creaturerace;

public class Turtle extends Creature {

	public Turtle(String name, int maxSpeed, char[] track, int currentPos) {
		super(name, maxSpeed, track, currentPos);

	}

	/*
	 *
	 * Can move into lakes for free (costs 0 movement points) Turtles are slow but
	 * steady, and can move into all other terrain for 1 movement point
	 */
	@Override
	public void move(int mp) {
		while (mp > 0) {

			if (track[getCurrentPos()] == '|') {
				break;
			} else {
				char nextTerrain = track[getCurrentPos() + 1]; // get next terrain to handle

				if (nextTerrain == 'O') {
					currentPos++;
					skipTerrain();
				} else if (mp >= 1) {
					mp--;
					currentPos++;
					skipTerrain();
				}

			}

		}
	}

}
