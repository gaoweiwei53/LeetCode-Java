package p26_Remove_Duplicates_from_Sorted_Array;

class Solution {
    public int removeDuplicates(int[] nums) {
        // 使用快慢针双指针
        if (nums.length == 0) return 0;

        // i 是慢指针，指向的是不重复的结果的右边界
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        // 因为返回的是长度，所以是 i + 1
        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0,0,1,1,1,2,2,3,3,4};
        int res = new Solution().removeDuplicates(array);
        System.out.println(res);
    }
}