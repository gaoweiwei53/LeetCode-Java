package p54_Spiral_Matrix;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0) {
            return res;
        }
        // 赋值上下左右边界
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            // 向右移动直到最右
            for (int col = left; col <= right; ++col) {
                res.add(matrix[up][col]);
            }
            //重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同
            if (++up > down) {
                break;
            }
            //向下
            for (int row = up; row <= down; ++row) {
                res.add(matrix[row][right]);
            }
            // 重新设定有边界
            if (--right < left) {
                break;
            }
            //向左
            for (int col = right; col >= left; --col) {
                res.add(matrix[down][col]);
            }
            if (--down < up) {
                break;
            }
            //重新设定下边界
            for (int row = down; row >= up; --row) {
                res.add(matrix[row][left]);
            }
            //重新设定左边界
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
