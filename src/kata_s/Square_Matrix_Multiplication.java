package kata_s;

/*Write a function that accepts two square (NxN) matrices (two dimensional arrays), and returns the product of the two. Only square matrices will be given.
        How to multiply two square matrices:
        We are given two matrices, A and B, of size 2x2 (note: tests are not limited to 2x2). Matrix C, the solution, will be equal to the product of A and B. To fill in cell [0][0] of matrix C, you need to compute: A[0][0] * B[0][0] + A[0][1] * B[1][0].
        More general: To fill in cell [n][m] of matrix C, you need to first multiply the elements in the nth row of matrix A by the elements in the mth column of matrix B, then take the sum of all those products. This will give you the value for cell [m][n] in matrix C.

        Example
        A         B          C
        |1 2|  x  |3 2|  =  | 5 4|
        |3 2|     |1 1|     |11 8|
        Detailed calculation:

        C[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0] = 1*3 + 2*1 =  5
        C[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1] = 1*2 + 2*1 =  4
        C[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0] = 3*3 + 2*1 = 11
        C[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1] = 3*2 + 2*1 =  8

        A more visual explanation of matrix multiplication: http://matrixmultiplication.xyz
        https://www.codewars.com/kata/5263a84ffcadb968b6000513/train/java
        */
public class Square_Matrix_Multiplication {
    public static void main(String[] args) {
        //int[][] a = {{1,2},{3,2}};
        int[][] a = {   {1, 2, 3, 2, 1},
                        {4, 5, 6, 5, 4},
                        {7, 8, 9, 8, 7},
                        {1, 2, 3, 4, 5} };

        int[][] b = {   {3, 2},
                        {2, 3},
                        {1, 2},
                        {2, 1},
                        {4, 5}  };

        printMatrix(b);

        System.out.println("--------------");
        int[][] c = rotateMatrix(b);
        printMatrix(c);

        int [][] res = matrixMultiplication(a,b);
        printMatrix(res);

    }

    public static int[][] rotateMatrix(int[][] c) {
        int[][] temp = new int[c[0].length][c.length];
        for (int i = 0; i < c.length; i++) {
            int k = 0;
            for (int j = c[0].length-1; j >= 0; j--) {
                temp[k][i] = c[i][j];
                k++;
            }
        }
        return temp;
    }
    public static void printMatrix(int [][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static int[][] matrixMultiplication(int[][] a, int[][] b) {
        int[][] c = rotateMatrix(b);


        int[][] d = new int[a[0].length][b.length];

        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < b.length; j++) {
                int sum = a[i][j] * b[j][i];
            }
        }

        return null;
    }
}
