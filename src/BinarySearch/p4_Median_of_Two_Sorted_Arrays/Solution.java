package p4_Median_of_Two_Sorted_Arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        int p1 = 0, p2 = 0, p = 0;
        while(p1 < m && p2 < n ){
            if(nums1[p1] <= nums2[p2]){
                nums[p++] = nums1[p1++];
            } else {
                nums[p++] = nums2[p2++];
            }
        }

        if(p1 == m) {
            while(p2 < n){
                nums[p++] = nums2[p2++];
            }
        }
        else if(p2 == n){
            while(p1 < m){
                nums[p++] = nums1[p1++];
            }
        }
        int len = m + n;
        if(len % 2 == 1){
            return nums[len / 2];
        } else {
            return (nums[len / 2] + nums[len / 2 - 1]) / 2.0;
        }
    }
    // 最简洁
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
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


    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2,4};
        int[] nums = new int[4];
        new Solution().findMedianSortedArrays(nums1, nums2);
    }
}
