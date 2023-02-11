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

    public Horspools(String searchWord, String file, boolean f) {
        this.searchWord = searchWord.toLowerCase();
        this.file = file;
        shiftTable = new HashMap<>();
        input = new ArrayList<>();
        buildTable();
        if(f)
            loadFile();
        else
            loadString();
        
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
        System.out.println(file);
        printWSandSearchWord(0);
        for (int i = searchWord.length() - 1; i < input.size(); i++) {
            char inputCurr = input.get(i);
            if (shiftTable.containsKey(inputCurr)) {// Is the character in the word
                // Does the last character line up
                if (searchWord.charAt(tableIndex) == inputCurr) {// it does? keep comparing until it dosent
                    int tmp = i;// save location
                    while (tableIndex >= 0 && searchWord.charAt(tableIndex) == input.get(i)) {
                        //System.out.println("Comparing " + searchWord.charAt(tableIndex) + " to " + input.get(i));
                        //printWSandSearchWord(i);
                        i--;
                        tableIndex--;
                        //System.out.println(tableIndex);
                    }
                    if (tableIndex < 0)
                        return true;// Found it!
                   i = ++tmp;
                   printWSandSearchWord(i);
                }
            } else {// Nope shift the entire lenth
                i = determineShift(i, inputCurr);
            }
            printWSandSearchWord(i);
            tableIndex = searchWord.length() - 1; // reset table index
        }
        return false;
    }

    public void loadString(){
        if(!input.isEmpty())
            input.clear();
        for(int i = 0; i < file.length(); i++){
            input.add(Character.toLowerCase(file.charAt(i)));
        }
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
        return shiftTable.containsKey(key) ? curr + shiftTable.get(key) : curr + searchWord.length()-1;
    }

    public HashMap<Character, Integer> getShiftTable() {
        return shiftTable;
    }

    public ArrayList<Character> getInput() {
        return input;
    }

    public void setSearchWord(String newSearch) {
        searchWord = newSearch;  
        shiftTable.clear();
        buildTable(); 
    }

    public String getSearchWord(){
        return searchWord;
    }

    public void printWSandSearchWord(int n){
        for(int i = 0; i < n; i++){
            System.out.print(" ");
        }
        System.out.print(searchWord+"\n");
    }

    public void printShiftTable() {
        for (Character key : shiftTable.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
        for (Character key : shiftTable.keySet()) {
            System.out.print(shiftTable.get(key) + " ");
        }
        System.out.println();
    }

    public void printFile() {
        for (int i = 0; i < input.size(); i++)
            System.out.print(input.get(i));
    }

    public static void main(String[] args) {
        // Test shift table
        Horspools t2 = new Horspools("barber", "jim_saw_me_in_the_barber_shop", false);

        //t2.setSearchWord("me");
        t2.printShiftTable();
        Horspools t2 = new Horspools("me", "jim_saw_me_in_the_barber_shop", false);

        //t2.setSearchWord("me");
        t2.printShiftTable();
        System.out.println();
        System.out.println(t2.findString());

    }
}