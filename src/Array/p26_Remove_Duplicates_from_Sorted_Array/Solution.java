package p26_Remove_Duplicates_from_Sorted_Array;

class Solution {
    public int removeDuplicates(int[] nums) {
        // 使用快慢针双指针
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}