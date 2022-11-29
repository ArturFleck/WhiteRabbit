package sort;

import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        Timmer timmer = new Timmer();

        int[] data = new int[100_000];
        int[] arr;
        int[] arr2;
        int[] arr3;

        fillArray(data);
        arr = data.clone();
        arr2 = data.clone();
        arr3 = data.clone();

        timmer.on();
        forBubble(data);
        timmer.off();

        timmer.on();
        whileBubble(arr);
        timmer.off();

        timmer.on();
        selectForBubble(arr2);
        timmer.off();

        timmer.on();
        quickSort(arr3);
        timmer.off();


/*        printArray(data);
        printArray(arr);
        printArray(arr2);
        printArray(arr3);*/


    }


    public static int[] fillArray(int[] data) {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(999999);
        }
        return data;
    }

    public static void printArray(int[] data) {
        for (int arr : data)
            System.out.print(arr + "\t");
        System.out.println();
    }

    public static void forBubble(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void whileBubble(int[] data) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int j = 0; j < data.length - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swapped = true;
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void selectForBubble(int[] data) {
        int min, temp;
        for (int i = 0; i < data.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min])
                    min = j;
            }
            temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }
    }

    private static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    public static void quickSort(int[] arr,int from,int to) {
        if (from < to) {
            int divideIndex = partition(arr, from, to);
            quickSort(arr, from, divideIndex - 1);
            quickSort(arr, divideIndex, to);
        }
    }

    private static int partition(int[] arr, int from, int to) {
        int leftIndex = from;
        int rightIndex = to;
        int pivot = arr[from + (to - from) / 2];

        while (leftIndex <= rightIndex) {

            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }

            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
