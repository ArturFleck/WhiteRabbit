import sort.BubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Remembering extends BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        fillArray(array, 99);
        printArray(array);
        Arrays.sort(array);
        printArray(array);
        /*filter(array);
        printArray(array);*/



        List<Integer> data = new ArrayList<>();

        data.add(0,25);
        data.add(1, 15);
        data.add(2, 35);
        data.add(3, 5);

        System.out.println(data);
        data = data.stream().sorted().collect(Collectors.toList());
        System.out.println(data);
    }

    public static void filter(int[] data) {
        int min, temp;
        for (int i = 0; i < data.length - 1; i++) {

            min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[min] > data[j]) {
                    min = j;
                }
            }
            temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }
    }
}
