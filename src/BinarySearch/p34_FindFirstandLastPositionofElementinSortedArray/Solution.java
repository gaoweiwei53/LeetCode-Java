package p34_FindFirstandLastPositionofElementinSortedArray;

import java.util.Arrays;

public class Solution {

    // 先二分查找左边界，再二分查找右边界
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};

        int l = 0, r = nums.length - 1; //二分范围
        while(l < r)			        //查找元素的开始位置
        {
            int mid = (l + r ) / 2;
            if(nums[mid] >= target){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if(nums[r] != target) {
            return new int[]{-1,-1}; //查找失败
        }
        int L = r;

        l = 0; r = nums.length - 1;     //二分范围
        while( l < r)			        //查找元素的结束位置
        {
            // 加1避免死循环
            int mid = (l + r + 1) / 2;
            if(nums[mid] <= target ){
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{L,r};
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,7,7,8,8,10};
        int target = 6;
        int[] res = new Solution().searchRange(input, target);
        System.out.println(Arrays.toString(res));
    }
}
