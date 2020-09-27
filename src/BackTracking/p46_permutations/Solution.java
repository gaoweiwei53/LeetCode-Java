package p46_permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Solution {

    public static void main(String[] args) {
        int[] nums  = {1,2,3};

        System.out.println(new Solution().permute(nums));
    }
    /*
   public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> resultList = new ArrayList<>();
       // Arrays.sort(nums); // not necessary
       backtrack(resultList, new ArrayList<Integer>(), nums);
       return resultList;
   }
   private void backtrack(List<List<Integer>> resultList, List<Integer> currentList, int [] nums){
       if(currentList.size() == nums.length){
           resultList.add(new ArrayList<>(currentList));
       }
       else{

           for(int i = 0; i < nums.length; i++){
               if(currentList.contains(nums[i])) continue; // element already exists, skip
               currentList.add(nums[i]);
               backtrack(resultList, currentList, nums);
               currentList.remove(currentList.size() - 1);
           }
       }
   }
    */
   // private static List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 w */
    /*

    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

     */


    // 优化：用 used 数组记录已经访问过的位置，以空间换时间
    /*
    时间：O(N * N!)，空间：O(N!)

        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> path = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            backTrack(path, nums, used);
            return res;
        }

        private void backTrack(LinkedList<Integer> path, int[] nums, boolean[] used){
            if(path.size() == nums.length){
                res.add(new LinkedList<>(path));
            }

            for(int i = 0; i < nums.length; i++){
                if(used[i]){
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                backTrack(path, nums, used);
                used[i] = false;
                path.removeLast();
            }
        }
     */
    public List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }
    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used,List<List<Integer>> res){
        // 终止的条件
        if(depth == len){
            // 这里很关键
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            path.removeLast();
            used[i] = false;
        }

    }
}
