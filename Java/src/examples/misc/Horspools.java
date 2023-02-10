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
    private ArrayList<Character> input;

    public Horspools(String searchWord, String file) {
        this.searchWord = searchWord.toLowerCase();
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
        int tableIndex = searchWord.length() - 1;

        for (int i = searchWord.length() - 1; i < input.size(); i++) {
            char inputCurr = input.get(i);
            if (shiftTable.containsKey(inputCurr)) {// Is the character in the word
                // Does the last character line up
                if (searchWord.charAt(tableIndex) == inputCurr) {// it does? keep comparing until it dosent
                    int tmp = i;// save location
                    while (tableIndex >= 0 && searchWord.charAt(tableIndex) == input.get(i)) {
                        i--;
                        tableIndex--;
                    }
                    if (tableIndex <= 0)
                        return true;// Found it!
                    i = ++tmp;
                }
            } else {// Nope shift the entire lenth
                i = determineShift(i, inputCurr);
            }
            tableIndex = searchWord.length() - 1; // reset table index
        }
        return false;
    }

    public void loadFile() {
        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNextLine()) {
                String line = sc.next();
                for (int i = 0; i < line.length(); i++) {
                    input.add(Character.toLowerCase(line.charAt(i)));
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int determineShift(int curr, char key) {
        return shiftTable.containsKey(key) ? curr + shiftTable.get(key) : curr + searchWord.length();
    }

    public HashMap<Character, Integer> getShiftTable() {
        return shiftTable;
    }

    public ArrayList<Character> getInput() {
        return input;
    }

    public void printShiftTable(HashMap<Character, Integer> st) {
        for (Character key : st.keySet()) {
            System.out.println(key + " " + st.get(key));
        }
    }

    public void testFile() {
        for (int i = 0; i < input.size(); i++)
            System.out.print(input.get(i));
        System.out.println();
    }

    public static void main(String[] args) {
        // Test shift table
        // Horspools t1 = new Horspools("abcd", "horspool.txt");
        // System.out.println();

        // System.out.println(t1.findString());

        Horspools t2 = new Horspools("BARBER", "horspool.txt");

        System.out.println();
        t2.printShiftTable(t2.getShiftTable());
        t2.testFile();
        System.out.println(t2.findString());

    }
}