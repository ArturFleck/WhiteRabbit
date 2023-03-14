package kata_s;

import java.util.ArrayList;
import java.util.List;

//https://www.codewars.com/kata/51c8e37cee245da6b40000bd/train/java
public class StripComments {
    public static void main(String[] args) {

        StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } );
    }
    public static String stripComments(String text, String[] commentSymbols) {
        List<String> str = new ArrayList<>();
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i<text.length(); i++){
            if (text.charAt(i)=='\n'){
                str.add(String.valueOf(newText));
                newText = new StringBuilder();
                i++;
                }
            newText.append(text.charAt(i));
            if(i == (text.length()-1)){
                str.add(String.valueOf(newText));
            }
        }

        System.out.println(str);

        return "";
    }
}
