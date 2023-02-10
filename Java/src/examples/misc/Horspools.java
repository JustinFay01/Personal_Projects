package examples.misc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Horspools {
    private HashMap<Character, Integer> shiftTable;
    private String file;
    private String searchWord;
    private ArrayList<String> input;

    public Horspools(String searchWord, String file) {
        this.searchWord = searchWord;
        this.file = file;
        shiftTable = new HashMap<>();
        input = new ArrayList<>();
        buildTable();
        loadFile();
    }

    public void buildTable() {
        for (int i = 0; i < searchWord.length(); i++) {
            Character key = Character.toLowerCase(searchWord.charAt(i));
            if (i + 1 == searchWord.length()) {// If its the last character move the entire word
                if (!shiftTable.containsKey(searchWord.charAt(i)))
                    shiftTable.put(key, searchWord.length());// If the last character is unique add the length of the
                                                             // word
                // If there is a repeated last character use the previous value
            } else
                shiftTable.put(key, searchWord.length() - i - 1); // Regular character input
        }
    }

    public boolean findString() {
        int endOfChar = searchWord.length();
        for(int i = searchWord.length()-1; i < input.size(); i++){
            if(searchWord.charAt(endOfChar-1) != (input.get(i).charAt(0))){
                
            }
        }
        return false;
    }

    public void loadFile() {
        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNext()) {
                input.add(sc.next());
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<Character, Integer> getShiftTable() {
        
        return shiftTable;
    }

    public ArrayList<String> getInput() {
        return input;
    }

    public void printShiftTable(HashMap<Character, Integer> st) {
        for (Character key : st.keySet()) {
            System.out.println(key + " " + st.get(key));
        }
    }

    public static void main(String[] args) {
        // Test shift table
        Horspools t1 = new Horspools("abcd", "horspool.txt");
        t1.printShiftTable(t1.getShiftTable());
        System.out.println();
        for (int i = 0; i < t1.getInput().size(); i++) {
            System.out.print(t1.getInput().get(i));
        }

        Horspools t2 = new Horspools("Barber", "horspool.txt");
        t2.printShiftTable(t2.getShiftTable());
    }
}