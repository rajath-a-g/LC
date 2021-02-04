package Amazon;

import java.util.Arrays;

public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println("Matrix after is : " + Arrays.deepToString(matrix));
    }
    public static void setZeroes(int[][] matrix) {
        boolean isZeroCol = false;
        boolean isZeroRow = false;
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                isZeroCol = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                isZeroRow = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (isZeroCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (isZeroRow) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
