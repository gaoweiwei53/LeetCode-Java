package p80_Remove_Duplicates_from_Sorted_Array2;

public class Solution {
    public int removeDuplicates(int[] nums) {
/*        int n = nums.length;
        int i = 0;
        int count = 1;
        while (i < nums.length ){
            int j;
            for ( j = i + 1; j < nums.length; j++) {
                if (nums[j] ==nums[i]) count ++;
                if(nums[j] != nums[i]){
                    i = j;
                    count = 1;
                }
                if ( count > 2){
                    n--;
                }
            }
            if (j == nums.length) break;
        }
        return n;*/


        // 不断得将下一位数复制到前一位上以达到删除多余元素的效果

        // j 指向下一个要覆盖元素的位置
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                // 遇到到了新元素，则我们更新 count = 1，并且将该元素移动到 j 位置，并同时增加 i 和 j
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;

/*        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]) nums[i++] = n;
        }
        return i;*/
    }

    public static void main(String[] args) {
        int res = new Solution().removeDuplicates(new int[]{1,1,1,2,2,3});
        System.out.println(res);
    }
}
