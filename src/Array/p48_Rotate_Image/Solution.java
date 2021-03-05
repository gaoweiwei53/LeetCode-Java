package p48_Rotate_Image;

public class Solution {
    // 先沿着左上至右下的对角线翻转，再左右翻转
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n ; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= (n - 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 -j] =tmp;
            }
        }
    }
}