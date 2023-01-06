package creaturerace;

public class Project4Main {

	public static void main(String[] args) {
		Race raceObj = new Race();
		// int length, int numRacers
		 raceObj.createRace(10, 10);

		 while(!raceObj.gameOver()) {
		 raceObj.advanceOneTurn();
		}

		// System.out.println();

		 raceObj.printAll();
		 
		 raceObj.displayOrder();
		// raceObj.findAndPrintWinners();

		//System.out.println();
		//raceObj.averageWinner(60, 15, 5000);

//		char[] testTrack = {'.', '~', '~', '#', '.', '~', '.', 'O', 'O', '#', 'O', '|' };
//		//create monkey
//		//create raceTrack
//		//Move monkey
//		//Return Current Pos
//		Creature mon = new Monkey("dave", 4, testTrack, 0);
//		System.out.println(mon.getName());
//		System.out.println(Arrays.toString(mon.getTrack()));
//		
//		System.out.println("Starting pos " +  mon.getCurrentPos());
//		mon.move(51);
//		System.out.println("Ending Pos " + mon.getCurrentPos());
//		mon.move(8);
//		System.out.println("Ending Pos " + mon.getCurrentPos());
//		mon.move(1);
//		System.out.println("Ending Pos " + mon.getCurrentPos());
//		mon.move(1);
//		System.out.println("Ending Pos " + mon.getCurrentPos());
//	
//		
//		mon.move(1);
//		System.out.println("Ending Pos " + mon.getCurrentPos());

//		System.out.println();
//		
//		Creature t = new Turtle("Dave2.0", 2, testTrack, 0);
//		System.out.println("Starting pos " +  t.getCurrentPos());
//		t.move(1);
//		System.out.println("Ending Pos " + t.getCurrentPos());
//		t.move(1);
//		System.out.println("Ending Pos " + t.getCurrentPos());
//		t.move(1);
//		System.out.println("Ending Pos " + t.getCurrentPos());
//		t.move(1);
//		System.out.println("Ending Pos " + t.getCurrentPos());
//		t.move(1);
//		System.out.println("Ending Pos " + t.getCurrentPos());
//		t.move(1);
//		System.out.println("Ending Pos " + t.getCurrentPos());
//		t.move(1);
//		System.out.println("Ending Pos " + t.getCurrentPos());
//		t.move(1);
//		System.out.println("Ending Pos " + t.getCurrentPos());
//		
//		System.out.println();
//		
//		Creature o = new Ostrich("Dave3.0", 5, testTrack, 0);
//		System.out.println("Starting pos " +  o.getCurrentPos());
//		o.move(1);
//		System.out.println("Ending Pos " + o.getCurrentPos());
//		o.move(2);
//		System.out.println("Ending Pos " + o.getCurrentPos());
//		o.move(1);
//		System.out.println("Ending Pos " + o.getCurrentPos());
//		o.move(1);
//		System.out.println("Ending Pos " + o.getCurrentPos());
//		o.move(1);
//		System.out.println("Ending Pos " + o.getCurrentPos());
//		o.move(3);
//		System.out.println("Ending Pos " + o.getCurrentPos());
//		o.move(2);
//		System.out.println("Ending Pos " + o.getCurrentPos());
//		o.move(2);
//		System.out.println("Ending Pos " + o.getCurrentPos());

	}

}
