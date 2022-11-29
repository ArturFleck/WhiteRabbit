package kata_s;

import java.util.ArrayList;
import java.util.List;

public class StringSpliter {
    public static void main(String[] args) {
        String line = "Some!";
        String[] res = solution(line);
        for(String w: res)
            System.out.println(w);
    }
    public static String[] solution(String line){
        List<String> pair = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
            String temp =String.valueOf(line.charAt(i));

            if ((i == (line.length()-1)) & (i % 2 == 0)) {
                temp = temp + "_";
                pair.add(temp);
            }
            if ((i % 2 == 0) && (i + 1 != line.length())) {
                temp = temp + line.charAt(i + 1);
                pair.add(temp);
            }
        }
        return pair.toArray(new String[0]);
    }
}
