package projectReworks.creaturerace;

public class Ostrich extends Creature {

	public Ostrich(String name, int maxSpeed, char[] track, int currentPos) {
		super(name, maxSpeed, track, currentPos);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Has a maximum speed of 5 If an ostrich starts its turn in open plains or
	 * desert, it gains a bonus of 1 movement point Ostriches get lost easily, so
	 * moving into a forest costs 3 movement points Ostriches don�t like to get wet,
	 * so moving into a lake costs 2 movement points Moving into other terrain costs
	 * 1 movement point
	 */
	@Override
	public void move(int mp) {
		if (track[getCurrentPos()] == '.' || track[getCurrentPos()] == '~') // Start in open plain or desert mp + 1
			mp++;

		while (mp > 0) {
			if (track[getCurrentPos()] == '|') {
				break;
			} else {
				char nextTerrain = track[getCurrentPos() + 1]; // get next terrain to handle

				if (nextTerrain == '#') {// forest lose 3
					if (mp >= 3) {
						mp = mp - 3;
						currentPos++;
						skipTerrain();
					} else {
						break;
					}
				} else if (nextTerrain == 'O') {// lake lose 2
					if (mp >= 2) {
						mp = mp - 2;
						currentPos++;
						skipTerrain();
					} else {
						break;
					}

				} else {// any other lose one
					if (mp >= 1) {
						mp--;
						currentPos++;
						skipTerrain();
					}
				}

			}

		}
	}
}
