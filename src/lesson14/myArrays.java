package lesson14;

public class myArrays {

    int[] arr = new int[5];
    Candy[] box = new Candy[5];


    public void foo() {
        for (int elem : arr) {
            System.out.println(elem);
        }

        for (int i = 0; i < box.length; i++) {
            System.out.println(box[i]);
        }
    }
}
