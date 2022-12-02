package kata_s;

import java.util.Random;

public class DiagonalSumOfArray {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = rand.nextInt(10);
            }
        }

        print(arr);


        int sum = 0;
        int c = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j == i) {
                    sum += arr[i][j];
                }

                if (j == c) {
                    if (i != j)
                        sum += arr[i][j];
                    c--;
                }
            }
        }

        System.out.println("\n\n" + sum);
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
