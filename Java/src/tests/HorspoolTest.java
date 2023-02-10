package tests;

import examples.misc.Horspools;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
public class HorspoolTest {

    private static ArrayList<String> perm;

    @Test
    public void permutationTest() {
        perm = new ArrayList<>();
        printDistinctPermutn("barber", "");
        

        Horspools h1 = new Horspools("barber", "horspool.txt");
        for(String str : perm){
            h1.setSearchWord(str);
            System.out.println(str);
            assertEquals("jim_saw_me_in_the_barber_shop".contains(str), h1.findString());
        }
    }

    static void printDistinctPermutn(String str, String ans) {

        // If string is empty
        if (str.length() == 0) {

            // print ans
            System.out.print(ans + " ");
            perm.add(ans);
            return;
        }

        // Make a boolean array of size '26' which
        // stores false by default and make true
        // at the position which alphabet is being
        // used
        boolean alpha[] = new boolean[26];

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // If the character has not been used
            // then recursive call will take place.
            // Otherwise, there will be no recursive
            // call
            if (alpha[ch - 'a'] == false)
                printDistinctPermutn(ros, ans + ch);
            alpha[ch - 'a'] = true;
        }
    }

}
