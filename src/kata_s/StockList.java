package kata_s;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.*;

/**
 * A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more characters. The 1st character of a code is a capital letter which defines the book category.
 * <p>
 * In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.
 * <p>
 * For example an extract of a stocklist could be:
 * <p>
 * L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}.
 * or
 * L = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"] or ....
 * You will be given a stocklist (e.g. : L) and a list of categories in capital letters e.g :
 * <p>
 * M = {"A", "B", "C", "W"}
 * or
 * M = ["A", "B", "C", "W"] or ...
 * and your task is to find all the books of L with codes belonging to each category of M and to sum their quantity according to each category.
 * <p>
 * For the lists L and M of example you have to return the string (in Haskell/Clojure/Racket a list of pairs):
 * <p>
 * (A : 20) - (B : 114) - (C : 50) - (W : 0)
 * where A, B, C, W are the categories, 20 is the sum of the unique book of category A, 114 the sum corresponding to "BKWRK" and "BTSQZ", 50 corresponding to "CDXEF" and 0 to category 'W' since there are no code beginning with W.
 * <p>
 * If L or M are empty return string is "" (Clojure and Racket should return an empty array/list instead).
 */

public class StockList {
    public static void main(String[] args) {
        String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY", "DORA 200", "FOLD"};
        String cd[] = new String[]{"F","C","A"};
        //assertEquals("(A : 200) - (B : 1140)",
        String res = stockSummary(art, cd);
        System.out.println(res);

    }

    public static String stockSummary(String[] listOfArt, String[] listOf1stLetter) {
        if (listOf1stLetter.length == 0 || listOfArt.length == 0)
            return "";

        String res = new String();
        Map<String, Integer> map = new HashMap<>();
        for (String s : listOfArt) {
            String[] words = s.split(" ");
            words[0] = String.valueOf(words[0].charAt(0));
            Integer g = null;

            if (map.get(words[0]) == null) {
                if (words.length>1)
                    g = Integer.valueOf(words[1]);
            } else {
                g = map.get(words[0]);
                g = g + Integer.parseInt(words[1]);
            }
            map.put(words[0], g);
        }

        for (int i = 0; i < listOf1stLetter.length; i++) {

            String v = String.valueOf(map.get(listOf1stLetter[i]));
            if (map.get(listOf1stLetter[i])==null){
                v="0";}
            String g = "(" + listOf1stLetter[i] + " : " + v +")";
            if (listOf1stLetter[i]=="")
                res = res + " - " + g;
            else if (i < listOf1stLetter.length && i!=0){
                res = res + " - " + g;
            }else {
                res = g;
            }

        }

        return res;
    }


    private static int stockCount(final String s) {
        return Integer.valueOf(s.split(" ")[1]);
    }

    public static String stockSummary2(final String[] stock, final String[] categories) {
        if (stock.length == 0 || categories.length ==  0)
            return "";
        final Map<String, Integer> counts = stream(stock)
                .collect(groupingBy(s -> s.substring(0, 1), summingInt(StockList::stockCount)));
        return stream(categories)
                .map(s -> "(" + s + " : " + counts.getOrDefault(s, 0) + ")")
                .collect(joining(" - "));
    }
}
