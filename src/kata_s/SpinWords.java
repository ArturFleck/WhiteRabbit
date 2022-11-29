package kata_s;

public class SpinWords {
    public static void main(String[] args) {
        String word = "Welcome home you small motherfucker";

        /*if (word.length() >=5)
        {
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            word = sb.toString();
        }*/

        System.out.println(word);

        System.out.println(spinWords(word));

    }

    public static String spinWords(String sentence) {
        String res = new String();
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() >= 5) {
                StringBuilder sb = new StringBuilder(arr[i]);
                sb.reverse();
                arr[i] = String.valueOf(sb);
            }
            if (i < arr.length - 1) {
                res += arr[i];
                res += " ";
            } else {
                res += arr[i];
            }
        }
        return res;
    }

    public static String spinWords2(String sentence) {
        for (String a : sentence.split(" ")) {
            if (a.length() > 4) {
                sentence = sentence.replace(a, new StringBuffer(a).reverse());
            }
        }
        return sentence;
    }

    public String spinWords3(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ", words);
    }
}
