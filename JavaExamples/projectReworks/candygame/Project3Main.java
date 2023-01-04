package candygame;

public class Project3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CandyGame candy = new CandyGame();
		Controller cntrl = new Controller(candy);
		
		cntrl.playGame();
	}

}
