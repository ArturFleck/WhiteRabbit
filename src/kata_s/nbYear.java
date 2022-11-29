package kata_s;

public class nbYear {
    public static void main(String[] args) {

        int p0 = 1500;
        double percent = 5;
        int aug = 100;
        int p = 5000;

        int res2 = nbYear(p0, percent, aug, p);
        System.out.println(res2);
    }

    public static int nbYear(int p0, double percent, int aug, int p) {
        int res = 0;
        while (p > p0) {
            double temp = (p0 / 100) * percent;
            p0 = (int) (p0 + temp + aug);
            res++;
        }
        return res;
    }
}
