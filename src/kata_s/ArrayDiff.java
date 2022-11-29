package kata_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayDiff {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 3, 2, 2};
        int[] arr2 = new int[]{2,2};
        int[] res = arrayDiff(arr,arr2);
        for (int a: res)
            System.out.print(a + " ");
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for (int ar: a)
            arr1.add(ar);

        for (int ar: b)
            arr2.add(ar);

        arr1.removeAll(arr2);

        int[] res = new int[arr1.size()];
        for (int i = 0; i < arr1.size(); i++) {
            res[i]=arr1.get(i);
        }

        //return res;
        return arr1.stream().mapToInt(e->e).toArray();
    }

    public static int[] arrayDiff2(int[] a, int[] b) {
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
        listA.removeAll(listB);
        return listA.stream().mapToInt(e -> e).toArray();
    }

    public static int[] arrayDiff3(int[] a, int[] b) {
        return IntStream.of(a).filter(x -> IntStream.of(b).noneMatch(y -> y == x)).toArray();
    }
}
