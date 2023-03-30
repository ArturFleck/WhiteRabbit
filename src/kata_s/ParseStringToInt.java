package kata_s;

import java.util.HashMap;
import java.util.Map;

/*"In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.
        Examples:
        "one" => 1
        "twenty" => 20
        "two hundred forty-six" => 246
        "seven hundred eighty-three thousand nine hundred and nineteen" => 783919
        Additional Notes:

        The minimum number is "zero" (inclusively)
        The maximum number, which must be supported is 1 million (inclusively)
        The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it's present and in others it's not
        All tested numbers are valid, you don't need to validate them

        https://www.codewars.com/kata/525c7c5ab6aecef16e0001a5/train/java
        "*/
public class ParseStringToInt {
    public static void main(String[] args) {
        String number = "seven hundred eighty-three thousand nine hundred and nineteen";
        System.out.println(parseInt(number));
    }

    public static int parseInt(String numStr) {
        int res = 0;
        numStr = numStr.replace("-", " ");
        String[] arr = numStr.split(" ");

        int hundred = 0;
        int thousand = 0;
        int million = 0;
        int billion = 0;

        for (String ss : arr) {
            switch (ss) {
                case "one":
                    res += 1;
                    break;
                case "two":
                    res += 2;
                    break;
                case "three":
                    res += 3;
                    break;
                case "four":
                    res += 4;
                    break;
                case "five":
                    res += 5;
                    break;
                case "six":
                    res += 6;
                    break;
                case "seven":
                    res += 7;
                    break;
                case "eight":
                    res += 8;
                    break;
                case "nine":
                    res += 9;
                    break;
                case "ten":
                    res += 10;
                    break;
                case "eleven":
                    res += 11;
                    break;
                case "twelve":
                    res += 12;
                    break;
                case "thirteen":
                    res += 13;
                    break;
                case "fourteen":
                    res += 14;
                    break;
                case "fifteen":
                    res += 15;
                    break;
                case "sixteen":
                    res += 16;
                    break;
                case "seventeen":
                    res += 17;
                    break;
                case "eighteen":
                    res += 18;
                    break;
                case "nineteen":
                    res += 19;
                    break;
                case "twenty":
                    res += 20;
                    break;
                case "thirty":
                    res += 30;
                    break;
                case "fourty":
                    res += 40;
                    break;
                case "forty":
                    res += 40;
                    break;
                case "fifty":
                    res += 50;
                    break;
                case "sixty":
                    res += 60;
                    break;
                case "seventy":
                    res += 70;
                    break;
                case "eighty":
                    res += 80;
                    break;
                case "ninety":
                    res += 90;
                    break;

                case "hundred":
                    res *= 100;
                    break;
                case "thousand":
                    res *= 1_000;
                    thousand = res;
                    res = 0;
                    break;
                case "million":
                    res *= 1_000_000;
                    million = res;
                    res = 0;
                    break;
                case "billion":
                    res *= 1_000_000_000;
                    billion = res;
                    res = 0;
                    break;

                default:
                    break;
            }
        }

        int result = billion + million + thousand + hundred + res;

        return result;
    }


    public static int parseInt2(String numStr) {
        String[] numArray = numStr.split("[ |-]");
        int number = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        map.put("thousand", 1000);
        map.put("million", 1000000);

        for (int i = 0; i < numArray.length; i++) {
            for (String key : map.keySet()) {
                if (numArray[i].toLowerCase().equals(key)) {
                    if (map.get(key) == 100) {
                        int temp = number % 100;
                        number -= temp;
                        number += temp * (map.get(key));
                    }
                    else if (map.get(key) > 100)
                        number *= (map.get(key));
                    else
                        number += map.get(key);
                    break;
                }
            }
        }
        return number;
    }
}