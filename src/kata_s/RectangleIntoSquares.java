package kata_s;

import java.util.ArrayList;
import java.util.List;

public class RectangleIntoSquares {
    public static void main(String[] args) {

        List<Integer> res = sqInRect(5, 3);
        System.out.println(res);
    }

    public static List<Integer> sqInRect(int a, int b) {
        if (a == b) {
            return null;
        } else {
            List<Integer> list = new ArrayList<>();
            while (a >= 1 && b >= 1) {
                int temp = 0;
                if (a > b && b != 1) {
                    temp = a;
                    list.add(b);
                    a -= b;
                }
                if (b > a && a != 1) {
                    list.add(a);
                    temp = b;
                    b -= a;
                }
                if (a == 1 && b > 1) {
                    for (int i = 0; i < b; i++) {
                        list.add(1);
                    }
                    break;
                }
                if (b == 1 && a > 1) {
                    for (int i = 0; i < a; i++) {
                        list.add(1);
                    }
                    break;
                }
                if (a == b) {
                    list.add(a);
                    break;
                }
            }
            return list;
        }
    }
}
