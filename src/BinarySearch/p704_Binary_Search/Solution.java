package p704_Binary_Search;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // <= 可以保证 r所指的数就是target这种情况也可以被查找到
        while (left <= right){

            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            // 上面 mid和target已比较过，所以这里 mid - 1
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
