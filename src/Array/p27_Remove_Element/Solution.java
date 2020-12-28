package p27_Remove_Element;

class Solution {
    public int removeElement(int[] nums, int val) {
//        int j;
//        j = 0;
//        for(int i = 0; i < nums.length; i++){
//            if (nums[i] != val){
//                nums[j++] = nums[i];
//            }
//
//        }
//        for(int i=j;i<nums.length;i++) {
//            nums[i] = 0;
//        }
//        return j;

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}