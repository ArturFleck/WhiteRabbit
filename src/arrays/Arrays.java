package arrays;

public class Arrays {
    public static void main(String[] args) {
        int[][] arr = new int[5][];

        arr[0] = new int[5];
        arr[1] = new int[3];
        arr[2] = new int[7];
        arr[3] = new int[2];
        arr[4] = new int[10];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 10);
            }
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
