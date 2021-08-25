package p215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;
import java.util.Random;

public class Solution {
    // 死方法，依次找出第最大元素，时间复杂度为O(Kn)
    public int findKthLargest(int[] nums, int k) {
        int maxIndex;
        for(int i = 0; i < k; i++){
            maxIndex = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] > nums[maxIndex]){
                    maxIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = tmp;
        }
        return nums[k - 1];
    }

    // 快速查找
    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index < target) {
                left = index + 1;
            } else if (index > target) {
                right = index - 1;
            } else {
                return nums[index];
            }
        }
    }

    // 在区间 nums[left..right] 区间执行 partition 操作
    private int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    // 优先队列
    public int findKthLargest3(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆 小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            // 看一眼，不拿出，因为有可能没有必要替换
            Integer topEle = minHeap.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topEle) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
