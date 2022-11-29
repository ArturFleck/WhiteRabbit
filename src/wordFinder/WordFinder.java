package wordFinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFinder {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean exist = false;

        System.out.print("Enter word to find in file: ");
        String word = scan.nextLine().toLowerCase(Locale.ROOT);
        scan.close();
        System.out.println();

        Map<Character, Integer> letter = new HashMap<>();
        for (int i = 0 ; i < word.length(); i++){
            Character ch = word.charAt(i);
            Integer count = letter.get(ch);
            letter.put(ch, count != null ? count + 1 : 1);
        }

        System.out.println(letter);

        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        for (String currentWord = reader.readLine(); currentWord != null; currentWord=reader.readLine()){
            if (Objects.equals(word, currentWord.toLowerCase(Locale.ROOT)))
                exist = true;
        }
        if (exist){
            System.out.println("find \"" + word + "\" word in a file!");
        } else {
            System.out.println("not in a file");
        }
        reader.close();
    }
}
