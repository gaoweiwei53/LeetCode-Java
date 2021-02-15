package p34_FindFirstandLastPositionofElementinSortedArray;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[l] == nums[r] && nums[l] == target){
                return new int[]{l,r};
            }
            if(nums[mid] == target){
                if(l > 0 && nums[mid - 1] != target){
                    l = mid;
                }
                if (r < nums.length - 1 && nums[mid + 1] != target){
                    r = mid;
                }
                if(nums[l] !=target){
                    l++;
                }
                if(nums[r] != target){
                    r--;
                }
            }
            else if(nums[mid] < target){
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
