package kata_s;

public class CheckPerfectSquare {
    public static void main(String[] args) {
        int k = 26;
        checkPerfectSquare(k);
    }

    public static void checkPerfectSquare(double x)
    {
        boolean res;
        double sq = Math.sqrt(x);
        res = ((sq - Math.floor(sq)) == 0);
        if (res)
            System.out.print(x + " is a perfect square number");
        else
            System.out.print(x + " is not a perfect square number");
    }
}
