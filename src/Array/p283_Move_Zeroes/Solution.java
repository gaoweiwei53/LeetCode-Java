package p283_Move_Zeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
        // 解法 2
//        if(nums==null) {
//            return;
//        }
//        //两个指针i和j
//        int j = 0;
//        for(int i=0;i<nums.length;i++) {
//            //当前元素!=0，就把其交换到左边，等于0的交换到右边
//            if(nums[i]!=0) {
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j++] = tmp;
//            }
//        }
    }
}
