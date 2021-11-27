package heapSort;


/**
 * 构建大顶堆有两种方式：
 *
 * 方案一：从 0 开始，将每个数字依次插入堆中，一边插入，一边调整堆的结构，使其满足大顶堆的要求；
 * 方案二：将整个数列的初始状态视作一棵完全二叉树，自底向上调整树的结构，使其满足大顶堆的要求。
 * 方案二更常用
 *
 *
 *
 * 根节点的下标视为 0，则完全二叉树有如下性质：
 *
 * 对于完全二叉树中的第 i 个数，它的左子节点下标：left = 2i + 1
 * 对于完全二叉树中的第 i 个数，它的右子节点下标：right = left + 1
 * 对于有 n 个元素的完全二叉树(n≥2)(n≥2)，它的最后一个非叶子结点的下标：n/2 - 1
 *
 *
 *
 * 堆排序的第一步就是构建大顶堆，对应代码中的 buildMaxHeap 函数。我们将数组视作一颗完全二叉树，从它的最后一个非叶子结点开始，
 * 调整此结点和其左右子树，使这三个数字构成一个大顶堆。
 *
 * 调整过程由 maxHeapify 函数处理， maxHeapify 函数记录了最大值的下标，根结点和其左右子树结点在经过比较之后，
 * 将最大值交换到根结点位置。这样，这三个数字就构成了一个大顶堆。
 *
 * 需要注意的是，如果根结点和左右子树结点任何一个数字发生了交换，则还需要保证调整后的子树仍然是大顶堆，
 * 所以子树会执行一个递归的调整过程。
 *
 *
 * 注：在有的文章中，作者将堆的根节点下标视为 11，这样做的好处是使得第 i 个结点的左子结点下标为 2i，
 * 右子结点下标为 2i + 1，与 2i + 1 和 2i + 2 相比，计算量会少一点，本文未采取这种实现，但两种实现思路的核心思想都是一致的
 *
 */

public class Solution {
    public  void heapSort(int[] arr) {
        // 构建初始大顶堆
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            // //将堆顶元素与末尾元素进行交换 i就是当前末尾元素的下标
            swap(arr, 0, i);
            // 调整剩余数组，使其满足大顶堆
            maxHeapify(arr, 0, i);
        }
    }
    // 构建初始大顶堆
    private  void buildMaxHeap(int[] arr) {
        // 从最后一个非叶子结点开始调整大顶堆，最后一个非叶子结点的下标就是 arr.length / 2-1
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }
    // 调整大顶堆，第三个参数表示剩余未排序的数字的数量，也就是剩余堆的大小
    private  void maxHeapify(int[] arr, int i, int heapSize) {
        // 左子结点下标
        int l = 2 * i + 1;
        // 右子结点下标
        int r = l + 1;
        // 记录根结点、左子树结点、右子树结点三者中的最大值下标
        int max = i;
        // 与左子树结点比较
        if (l < heapSize && arr[l] > arr[max]) {
            max = l;
        }
        // 与右子树结点比较
        if (r < heapSize && arr[r] > arr[max]) {
            max = r;
        }
        if (max != i) {
            // 将最大值交换为根结点
            swap(arr, i, max);
            // 再次调整交换数字后的大顶堆
            maxHeapify(arr, max, heapSize);
        }
    }
    private  void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,6,8,5,9};
        new Solution().heapSort(nums);
    }
}
/**
 * 堆排序演示
 *
 * @author Lvan
 */
class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};
        int[] arr = {16, 7, 3, 20, 17, 8};

        heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    /**
     * 创建堆，
     * @param arr 待排序列
     */
    private static void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆
     * @param arr 待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }
}