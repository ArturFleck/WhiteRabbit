package kata_s;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchInSortedArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(20);
        }

        printArray(array);

        filterArray(array);

        printArray(array);

        int element = 15;

        int index = bynaryIndexOf(array,element);
        System.out.println("number: " + element + "  at index: " + index);


    }

    public static void filterArray(int[] array) {
        Arrays.sort(array);
    }

    public static void printArray(int[] array) {
        System.out.println("-------------");
        for (int a : array) {
            System.out.println(a);
        }
        System.out.println("-------------");
    }

    public static int bynaryIndexOf(int[] array, int number) {
        int left = 0;
        int right = array.length - 1;


        while (left <= right) {
            int index = (left + right) / 2;
            int current = array[index];

            if (number == current) {
                return index;
            } else if (current < number) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return -1;
    }
}
