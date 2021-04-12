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