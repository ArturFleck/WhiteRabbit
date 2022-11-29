package kata_s;

import java.util.*;

/**
 * Given a list and a number, create a new list that contains each number of list at most N times, without reordering.
 * For example if the input number is 2, and the input list is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2],
 * drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times,
 * and then take 3, which leads to [1,2,3,1,2,3].
 * With list [20,37,20,21] and number 1, the result would be [20,37,21].
 **/

public class EnoughIsEnough {
    public static void main(String[] args) {
        //int[] arr = {1, 1, 3, 3, 7, 2, 2, 2, 2};
        //int[] arr = { 20, 37, 20, 21};
        //int[] arr = { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 };
        int arr[] = {1,1,1,1,1};
        int[] res = deleteNth(arr, 5);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        List<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            Integer count = map.get(elements[i]);
            map.put(elements[i], count != null ? count + 1 : 1);

            if (map.get(elements[i]) <= maxOccurrences) {
                arr.add(elements[i]);
            }
        }
        int[] res= new int[arr.size()];
        for (int i=0; i<arr.size();i++){
            res[i]=arr.get(i);
        }

        return res  ;
    }

    public static int[] deleteNth2(int[] elements, int maxOccurrences) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return Arrays.stream(elements)
                .filter(element -> map.merge(element, 1, Integer::sum) <= maxOccurrences)
                .toArray();
    }
}
