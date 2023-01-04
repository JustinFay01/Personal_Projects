package creaturerace;

import java.util.Arrays;

public class Project4Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Creature mon = new Monkey("dave", 0, null, 0);
		
		System.out.println(mon.getName());
		
		Race raceObj = new Race();
		
		raceObj.createRace(12, 10);
		System.out.println(Arrays.toString(raceObj.getRacetrack()));
	}

}
