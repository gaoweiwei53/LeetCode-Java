package p35_Search_Insert_Position;

public class Solution {
    public int searchInsert(int[] nums, int target) {
/*        int l = 0, r = nums.length - 1;
        // {1,3,5,6}, 7
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return l;*/

        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] < target){
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int ans = new Solution().searchInsert(new int[]{1,3,5,6},4);
        System.out.println(ans);
    }
}
