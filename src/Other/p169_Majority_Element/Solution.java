package p169_Majority_Element;

public class Solution {

    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0){
                cand_num = nums[i];
                count = 1;
            } else if (nums[i] == cand_num) {
                count++;
            }
            else {
                count--;
            }
        }
        return cand_num;
    }
    
    public int majorityElement2(int[] nums) {
        int ret = 0;
        int counter = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (counter == 0) {
                ret = nums[i];
                counter = 1;
            } else if (nums[i] == ret) {
                counter++;
            } else {
                counter--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int res = new Solution().majorityElement(nums);
        System.out.println(res);
    }
}
