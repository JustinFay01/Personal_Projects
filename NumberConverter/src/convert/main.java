package convert;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;

import NumberConverter.views.ConvertGUI;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
	
		ConvertGUI.runWindow();
		
		Converter con = new Converter();
		ArrayList<String> converted = new ArrayList();
		converted = con.toBinary(13);
		converted = con.toHex(1000100050);
		//converted = con.toOctal(1000100050);
		System.out.println(con.htoD("0x3B9C50D2"));
		
		//converted = con.toHex(con.btoD("0b1101"));
		con.printConverted(converted);
		
	}

}
