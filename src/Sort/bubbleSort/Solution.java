package bubbleSort;

public class Solution {
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            // 注意j的停止条件
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[ j + 1]){
                    // 不用引入中间变量(不考虑数字越界的情况)
                    arr[j + 1] = arr[j + 1] + arr[ j ];
                    arr[j] = arr[j + 1] - arr[j];
                    arr[j + 1] = arr[j + 1] - arr[j];
                }
            }
        }
    }

    public static void bubbleSortPro(int[] arr){
        boolean swapped = true;
        for (int i = 0; i < arr.length; i++) {

            if (!swapped) break;
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }
}
/*
a = a ^ b
b = a ^ b
a = a ^ b
*/


/**
 * 冒泡排序有三种写法：稳定
 * 1. 一边比较一边向后两两交换，将最大值 / 最小值冒泡到最后一位；
 * 2. 经过优化的写法：使用一个变量记录当前轮次的比较是否发生过交换，如果没有发生交换表示已经有序，不再继续排序；
 * 3. 进一步优化的写法：除了使用变量记录当前轮次是否发生交换外，再使用一个变量记录上次发生交换的位置，下一轮排序时到达上次交换的位置就停止比较。
 *
 * 冒泡排序(稳定)和快速排序(不稳定)都是交换排序
 */
