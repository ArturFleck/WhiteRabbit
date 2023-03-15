package kata_s;

import java.util.ArrayList;
import java.util.List;

//https://www.codewars.com/kata/51c8e37cee245da6b40000bd/train/java
public class StripComments {
    public static void main(String[] args) {

        StripComments.stripComments("\na\n b\nc\na", new String[]{",", "^", "-", "'", "=", "!", "?"});
    }

    public static String stripComments(String text, String[] commentSymbols) {
        List<String> str = new ArrayList<>();
        StringBuilder newText = new StringBuilder();
        boolean truth = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n') {
                truth = false;

                if (newText.length() > 0) {
                    while (newText.charAt(newText.length() - 1) == ' ') {
                        newText.deleteCharAt(newText.length() - 1);
                    }
                }
                str.add(String.valueOf(newText));

                newText = new StringBuilder();
                i++;
            }

            for (int j = 0; j < commentSymbols.length; j++) {
                if (text.charAt(i) == commentSymbols[j].charAt(0)) {
                    truth = true;
                }
            }

            if (!truth) {
                newText.append(text.charAt(i));
            }

            if (i == (text.length() - 1)) {
                if (newText.length() > 0) {
                    while (newText.charAt(newText.length() - 1) == ' ') {
                        newText.deleteCharAt(newText.length() - 1);
                    }
                    str.add(String.valueOf(newText));
                }
            }
        }

        //System.out.println(str);
        String newString = "";
        for (int i = 0; i < str.size(); i++) {
            newString += str.get(i);
            if (i < str.size() - 1) {
                newString += "\n";
            }
        }
        System.out.println(newString);

        return newString;
    }
}
