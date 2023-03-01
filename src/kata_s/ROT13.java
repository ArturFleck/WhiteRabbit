package kata_s;

/*      How can you tell an extrovert from an introvert at NSA?
        I found this joke on USENET, but the punchline is scrambled. Maybe you can decipher it?
        According to Wikipedia, ROT13 is frequently used to obfuscate jokes on USENET.
        For this task you're only supposed to substitute characters. Not spaces, punctuation, numbers, etc.

        Test examples:
        "EBG13 rknzcyr." -> "ROT13 example."
        "This is my first ROT13 excercise!" -> "Guvf vf zl svefg EBG13 rkprepvfr!"*/
public class ROT13 {
    public static void main(String[] args) {
        //String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String text = "Va gur ryringbef, gur rkgebireg ybbxf ng gur BGURE thl'f fubrf.";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            int numb;

            if ((text.charAt(i) >= 65 && text.charAt(i) < 78) || (text.charAt(i) >= 97 && text.charAt(i) < 110)) {
                symbol = text.charAt(i);
                numb = symbol + 13;
                symbol = (char) numb;

            } else if ((text.charAt(i) >= 78 && text.charAt(i) < 91) || (text.charAt(i) >= 110 && text.charAt(i) < 123)) {
                symbol = text.charAt(i);
                numb = symbol - 13;
                symbol = (char) numb;
            }
            sb.append(symbol);
            System.out.println(text.charAt(i) + "   " + symbol);
        }

        System.out.println(sb);
    }
}
