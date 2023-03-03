package kata_s;

/*      We need to sum big numbers and we require your help.
        Write a function that returns the sum of two numbers. The input numbers are strings and the function must return a string.
        Example
            add("123", "321"); -> "444"
            add("11", "99");   -> "110"
*/
public class Adding_Big_Numbers {
    public static void main(String[] args) {

        String a = "0095105669529527537888773945";
        String b = "69525603";
/*        String a = "11";
        String b =  "99";*/

        System.out.println(add(a, b));
        System.out.println("95105669529527537958299548");
    }

    public static String add(String e, String r) {
        StringBuilder a = new StringBuilder(e).reverse();
        StringBuilder b = new StringBuilder(r).reverse();
        StringBuilder sb = new StringBuilder();
        int l = 0;
        if (a.length() > b.length())
            l = a.length();
        else
            l = b.length();

        int ss = 0;

        for (int i = 0; i < l; i++) {

            int n = 0;
            if (a.length() > i) {
                n = Integer.parseInt(String.valueOf(a.charAt(i)));
            } else {
                n = 0;
            }

            int m = 0;
            if (b.length() > i) {
                m = Integer.parseInt(String.valueOf(b.charAt(i)));
            } else {
                m = 0;
            }

            int sum = n + m + ss;
            ss = 0;
            if (sum >= 10) {
                ss = 1;
                sum = sum - 10;
                sb.append(sum);
            } else
                sb.append(sum);
        }
        if (ss>0)
            sb.append(ss);

        for (int i =0; i<sb.length(); i++) {
            if (sb.charAt(sb.length() - 1) == '0')
                sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        }
        sb.reverse();

        return sb.toString();
        //return Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
    }
}
