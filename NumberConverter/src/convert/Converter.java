package convert;

import java.util.ArrayList;


public class Converter {

	public void printConverted(ArrayList<String> converted) {
		for(int i = converted.size()-1; i >= 0; i--) {
			System.out.print(converted.get(i));
		}	
	}
	
	/*
	 * Takes binary string and turns it into an integer 
	 */
	public long btoD(String bin) {
		long n = 0;
		String input[] = bin.split("");
		for(int i = 2; i < input.length; i++) {
			long value = Integer.valueOf(input[i]);
			if(value == 1 || value == 0){
				n = n * 2 + value;
			}
			else
				return -1;
		}
		return n;
	}
	
	/*
	 * Takes octal string and turns it into an integer
	 */
		public long otoD(String oct) {
			long n = 0;
			String input[] = oct.split("");
			for(int i = 1; i < input.length; i++) {
				long value = Integer.valueOf(input[i]);
				if(value >= 0 && value <= 7){
					n = n * 8 + value;
				}
				else
					return -1;
			}
			
			return n;
		}
	/*
	 * Takes hex string and turns it into integer
	 */
		public long htoD(String hex) {
			long n = 0;
			String input[] = hex.split("");
			for(int i = 2; i < input.length; i++) {
				input[i] = input[i].toUpperCase();
			}
			
			for(int i = 2; i < input.length; i++) {
				try {
					long value = Integer.valueOf(input[i]);
					if(value >= 0 && value <= 9)
						n = n * 16 + value;
					else 
						return -1;
				}
				catch (NumberFormatException e) {
					if(input[i].equals("A"))
						n = n * 16 + 10;
					else if(input[i].equals("B"))
						n = n * 16 + 11;
					else if(input[i].equals("C"))
						n = n * 16 + 12;
					else if(input[i].equals("D"))
						n = n * 16 + 13;
					else if(input[i].equals("E"))
						n = n * 16 + 14;
					else if(input[i].equals("F"))
						n = n * 16 + 15;
					else
						return -1;
				}
			}
			
			return n;
		}
	/*
	 * Takes an integer and returns an array list of the binary conversion
	 */
	public ArrayList<String> toBinary(long integer) {
		ArrayList<String> binary = new ArrayList();

		while (integer != 0) {
			if (integer % 2 == 1)
				binary.add("1");

			else if (integer % 2 == 0)
				binary.add("0");
			integer = integer / 2;
		}

		return binary;
	}
	/*
	 * Takes an integer and returns an Array List of the octal conversion
	 */
	public ArrayList<String> toOctal(long integer){
		ArrayList<String> octal = new ArrayList();
		
		while(integer != 0) {
			 if(integer % 8 > 0)
				octal.add(String.valueOf((int) integer % 8));
			 
			 else 
				 octal.add("0");
			 
			 integer = integer / 8;
			 }
		
		return octal;
	}
	/*
	 * Takes an integer and returns and Array List of the hex conversion
	 */
	public ArrayList<String> toHex(long integer) {
		ArrayList<String> hex = new ArrayList();

		while (integer != 0) {
			//Remainder and it needs to be letter
			if (integer % 16 > 0 && ((integer % 16) >= 10)) {
				int remainder = (int) (integer % 16);

				if ((remainder - 10) == 0) {
					hex.add("A");
				}else if ((remainder - 10) == 1) {
					hex.add("B");
				} else if ((remainder - 10) == 2) {
					hex.add("C");
				} else if ((remainder - 10) == 3) {
					hex.add("D");
				} else if ((remainder - 10) == 4) {
					hex.add("E");
				} else if ((remainder - 10) == 5) {
					hex.add("F");
				}
				integer = integer / 16;
			}
			//Remainder and it is a digit
			 else if(integer % 16 > 0 && ((integer % 16) < 10)) {
				 hex.add(String.valueOf((int) integer % 16));
				 integer = integer / 16;
			 }
			//Number but no remainder
			 else if((integer % 16) == 0  && (integer % 16) < 10) {
				 hex.add(String.valueOf((int) integer % 16));
				 integer = integer / 16;
			 }
		}

		return hex;

	}

}
