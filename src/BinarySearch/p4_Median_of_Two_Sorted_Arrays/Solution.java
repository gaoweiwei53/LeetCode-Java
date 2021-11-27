package p4_Median_of_Two_Sorted_Arrays;

public class Solution {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        int p1 = 0, p2 = 0, p = 0;
        while(p1 < m || p2 < n ){
            if(p1 == m){
                nums[p++] = nums2[p2++];
            }
            else if(p2 == n){
                nums[p++] = nums1[p1++];
            } else if(nums1[p1] <= nums2[p2]){
                nums[p++] = nums1[p1++];
            }
            else{
                nums[p++] = nums2[p2++];
            }
        }
        int len = m + n;
        if(len % 2 == 1){
            return nums[len / 2];
        } else {
            return (nums[len / 2] + nums[len / 2 - 1]) / 2.0;
        }
    }
    // 二分查找法
    // 思路：找出两个有序数组的一个恰当的分割线，中位数的值就由位于分割线两侧的数决定
    // 时间复杂度O(log min(m, n))

    // 分割线需要满足的条件
    // 1. 当为偶数的时候，分割线左边和右边的元素个数相等，奇数的时候左边的元素个数比右边个数多一
    // 2. 分割线左边的所有元素的数值 <= 红线右边的所有元素的数值

    // 当为奇数的时候，左边的最大值即为中位数，当为偶数的时候，左边的最大值即为一个中位数，右边最小值为一个中位数
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // 将较短的数组设置为第一个数组，为了方便编码
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
        // 知道了这个值，只要确定其中一个数组的分割线位置，另一个数组的分割线位置可以通过公式计算出来
        int totalLeft = (m + n + 1) / 2;

        // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
        // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        int left = 0;
        int right = m;

        // i， j 表示分割线的位置, 表示分割线在位置i 和 j的左侧
        // i - 1 和 j - 1表示在分割线的左侧
        while (left < right) {
            int i = left + (right - left) / 2;
            int j = totalLeft - i;
            if (nums2[j - 1] > nums1[i]) {
                // 下一轮搜索的区间 [i + 1, right]
                left = i + 1;
            } else {
                // 下一轮搜索的区间 [left, i]
                right = i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        // 分割线左右四个元素， 考虑边界情况
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        // 分奇偶
        if (((m + n) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2,4};
        int[] nums = new int[4];
        new Solution().findMedianSortedArrays1(nums1, nums2);
    }
}
