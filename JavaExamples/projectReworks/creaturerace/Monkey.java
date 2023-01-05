package creaturerace;

public class Monkey extends Creature {

	public Monkey(String name, int maxSpeed, char[] track, int currentPos) {
		super(name, maxSpeed, track, currentPos);
	}

	/*
	 * Has a maximum speed of 4 Can move into forests for free (costs 0 movement
	 * points) Monkeys don’t like to get hot, so moving into desert costs 2 movement
	 * points If a monkey moves into a lake, it stops to play, reducing its
	 * remaining movement points to 0 Moving into other terrain costs 1 movement
	 * point
	 */
	@Override
	public void move(int mp) {
		while (mp > 0) {

			if (track[getCurrentPos()] == '|') {
				break;
			} else {
				char nextTerrain = track[getCurrentPos() + 1]; // get next terrain to handle

				if (nextTerrain == '.') {// plains lose one
					if (mp >= 1) {
						mp--;
						currentPos++;
						skipTerrain();
					} else {
						break;
					}
				} else if (nextTerrain == '#') {// forest lose none
					currentPos++;
					skipTerrain();
				} else if (nextTerrain == 'O') {// lake lose all
					currentPos++;
					mp = 0;
					skipTerrain();

				} else if (nextTerrain == '~') { // desert minus 2
					if (mp >= 2) {
						mp = mp - 2;
						currentPos++;
						skipTerrain();
					} else {
						break;
					}
				} else if (nextTerrain == '|') {
					if (mp >= 1)
						mp--;
					currentPos++;
				}
			}

		}

	}

}
