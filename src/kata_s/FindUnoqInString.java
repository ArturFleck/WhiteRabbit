package kata_s;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindUnoqInString {
    public static void main(String[] args) {
        //String[] str = { "    ", "a", " " };
        String[] str = {"Tom Marvolo Riddle","I am Lord Voldemort","Harry Potter"};
        //String[] str = {"abc","bca","cab","bac","cba","bbc"};
        //String[] str = {"AaAa","aaa","aaaaa","Aaa","AaAaAa","BbBb"};
        //String[] str = {"silvia","vasili","victor"};
        String[] res = str.clone();
        for (int i=0; i<str.length;i++){
            String stt=str[i].toLowerCase();
            stt = stt.replace(" ","");
            char[] chars = stt.toCharArray();
            Arrays.sort(chars);
            str[i]= String.valueOf(chars);
        }
        Arrays.sort(str);
        //Arrays.stream(str).peek(System.out::println).collect(Collectors.toList());
        //System.out.println();
        for (int i=0;i<str.length-1;i++){
            if (!(str[i+1].contains(str[i]))){
                for (int j=0;j<str.length;j++){
                    String stt=res[j].toLowerCase();
                    stt = stt.replace(" ","");
                    char[] chars = stt.toCharArray();
                    Arrays.sort(chars);
                    stt= String.valueOf(chars);
                    if (stt.equals(str[i + 1])){
                        System.out.println(res[j]);
                    }
                }
            }
        }
    }
}
