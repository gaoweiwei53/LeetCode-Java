package p162_Find_Peak_Element;

public class Solution {
    public int findPeakElement(int[] nums) {

        // 若发现相邻较大的数，沿着这个数的方向一定可以找到峰值元素
        int left = 0, right = nums.length - 1;
        for (; left < right; ) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
