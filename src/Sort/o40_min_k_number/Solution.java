package o40_min_k_number;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*这道题是一个经典的 Top K 问题，是面试中的常客。Top K 问题有两种不同的解法，
  一种解法使用堆（优先队列），
  另一种解法使用类似快速排序的分治法。
*/
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

        // 堆/优先队列
/*        if (k == 0) {
            return new int[0];
        }

        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;*/



        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }

        // 原地不断划分数组
        partitionArray(arr, 0, arr.length - 1, k);

        // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    void partitionArray(int[] arr, int lo, int hi, int k) {
        // 做一次 partition 操作
        int m = partition(arr, lo, hi);
        // 此时数组前 m 个数，就是最小的 m 个数
        if (k == m) {
            // 正好找到最小的 k(m) 个数
            return;
        } else if (k < m) {
            // 最小的 k 个数一定在前 m 个数中，递归划分
            partitionArray(arr, lo, m-1, k);
        } else {
            // 在右侧数组中寻找最小的 k-m 个数
            partitionArray(arr, m+1, hi, k);
        }
    }

    // partition 函数和快速排序中相同，具体可参考快速排序相关的资料
    // 代码参考 Sedgewick 的《算法4》
    int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > v) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);

        // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}

/*
* 使用堆的思路
* 1. 使用优先队列PriorityQueue结构，让其为大堆，参数(k, ((i1,i2)->Integer.compare(i2, i1))
* 2. 当队列为空的size小于k 或 arr的当前值小于队列的第一个值(堆顶值，堆中最大值)的时候，入队
* 3. 比较完后，优先队列中的元素即为top k 小的值，将其复制给结果输出
* */