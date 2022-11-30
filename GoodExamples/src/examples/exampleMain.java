package examples;

import java.io.File;
import java.io.FileNotFoundException;

public class exampleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String case1res = "case1res.txt";
		String case1req = "case1req.txt";
		FriendRequest fb = new FriendRequest(3, case1res, case1req);
		
		try {
			boolean[] result = fb.run();
			fb.printBoolean(result);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String case2res = "case2res.txt";
		String case2req = "case2req.txt";
		FriendRequest fb2 = new FriendRequest(5, case2res, case2req);
		
		File file = new File(case2req);
		try {
			boolean[] result = fb2.run();
			fb2.printBoolean(result);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
