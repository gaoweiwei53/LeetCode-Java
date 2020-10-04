package p93_restore_ip_address;

import java.util.*;
/*
public class Solution {
    public static void main(String[] args) {
        List<String> res = new Solution().restoreIpAddresses("25525511135");
        System.out.println(res);
    }

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }

    // 需要一个变量记录剩余多少段还没被分割

    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }

            if (residue * 3 < len - i) {
                continue;
            }

            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }
}

 */

/*
class Solution {
    public static void main(String[] args) {
        List<String> res = new Solution().restoreIpAddresses("233233233");
        System.out.println(res);
    }

    List<String> res = new LinkedList<>();
    LinkedList<String> segment = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        helper(s, 0);
        return res;
    }

    void helper(String s, int start){
        //System.out.println(start);
        if(start == s.length() && segment.size() == 4){
            StringBuilder t = new StringBuilder();
            for (String se: segment) t.append(se).append(".");
            t.deleteCharAt(t.length() - 1);
            res.add(t.toString());
            return;
        }

        // 片段里满足4个数，但是数没用完，不行，返回
        if(start < s.length() && segment.size() == 4)return;


        for(int i = 1;i <= 3; i++){

            if(start + i - 1 >= s.length())return;

            // 当片段里数字个数大于1时，第一个数不能为0
            if(i != 1 && s.charAt(start) == '0')return;

            // 2， 25， 255
            // beginIndex 包括， endIndex 不包括
            String str = s.substring(start, start + i);

            // 当片段由3个数字组成时，不能大于255
            if(i == 3 && Integer.parseInt(str) > 255)return;

            segment.addLast(str);
            helper(s, start + i);
            segment.removeLast();
        }
    }
}
 */
// 有bug
class Solution{
    public static void main(String[] args) {
        List<String> res = new Solution().restoreIpAddresses("1111");
        System.out.println(res);
    }
    private List<String> res = new LinkedList<>();
   // private List<String> curr = new LinkedList<>();

    public List<String> restoreIpAddresses(String s){
        int n = s.length();
        StringBuilder curr = new StringBuilder(s);
        System.out.println(curr.toString());
        dfs(n,0,-1,curr,s);
        return res;
    }
    private void dfs(int n, int pointnum, int lastpoint, StringBuilder curr, String s){
        //pointnum记录目前加了几个点了，lastpoint记录上一个点加的位置
        if (pointnum == 3){
            //如果已经加了三个点了，并且最后一个点的右边表示的数小于255，则是正确IP地址
            if (valid(lastpoint + 1, n - 1, s)){
                res.add(curr.toString());
            }
        }
        //从上一个.号的下一个位置开始查找
        for (int i = lastpoint + 1; i < n - 1; i++){
            //如果字符串s从上一个.号到i位置表示的数小于等于255，则符合条件
            if (valid(lastpoint + 1,i,s)){
                //正常回溯法，注意这里要+pointnum，因为已经加入的.号也会占位
                curr.insert( 0 + i + pointnum + 1,'.');   // bug!!!
                dfs(n, pointnum + 1, i, curr, s);
                curr.delete(pointnum + i + 1,1);
            }
        }
        return;

    }
    boolean valid(int left, int right, String s){
        int sum = 0;
        for ( int i = left; i <= right; i++){
            //处理0开头问题
            if(left != right && s.charAt(left) == '0') return false;
            //计算字符串s中left到right位表示的数的大小
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum > 255) return false;
        }
        return true;
    }
}