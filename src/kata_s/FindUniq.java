package kata_s;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindUniq {
    public static void main(String[] args) {
        double[] ddd = {1, 1, 3, 1, 1, 1};
        double rr = findUniq3(ddd);
        System.out.println(rr);
    }

    public static double findUniq(double arr[]) {
        double rr = 0;
        Map<Double, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Double d = arr[i];
            Integer count = map.get(d);
            map.put(d, count != null ? count + 1 : 1);
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.get(arr[i]) == 1)
                //System.out.println(arr[i]);
                rr = arr[i];
        }
        return rr;
    }

    public static double findUniq2(double arr[]) {
        int count1 = 0, count2 = 0;
        double a = 0;
        double b = 0;
        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            a = arr[0];
            if (arr[i] == a)
                count1++;
            if (arr[i] != a) {
                b = arr[i];
                count2++;
            }
            if (count1 > count2)
                res = b;
            else
                res = a;
        }
        return res;
    }

    public static double findUniq3(double arr[]) {
        for (double d : arr) {
            System.out.print(d + " ");
        }
        System.out.println();
        Arrays.sort(arr);
        for (double d : arr) {
            System.out.print(d + " ");
        }
        System.out.println();
        return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
    }
}
