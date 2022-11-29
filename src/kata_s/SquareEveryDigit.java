package kata_s;

public class SquareEveryDigit {
    public static void main(String[] args) {

        int res = squareDigits(32);
        System.out.println(res);

    }

    public static int squareDigits(int j) {
        String num = Integer.toString(j);
        String answer = "";
        for (int i = 0; i < num.length(); i++) {
            int temp = Integer.parseInt(String.valueOf(num.charAt(i)));
            temp = temp * temp;
            answer = answer + temp;
        }
        return Integer.parseInt(answer);
    }
}
