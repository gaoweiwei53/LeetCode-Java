package p88_Merge_Sorted_Array;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从前面开始遍历不可行，因为添加数据时要后移其后面的元素
/*        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                if(nums2[i] < nums1[j] && nums2[i] >= nums1[i-1]){


                }
            }
        }*/


        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;

        // p指向nums1的尾端
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {

        int[] nums1;
        new Solution().merge(nums1 = new int[]{1,2,3,0,0,0},6, new int[]{2,5,6},3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
