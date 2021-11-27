package p14_Longest_Common_Prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i = 1; i < strs.length;i++) {
            int j = 0;
            while(j < ans.length() && j < strs[i].length()){
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
                j++;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }

    // 更快更简单
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        //定义第一个字符串为基准值，然后遍历字符串数组
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            //判断 str 是否以指定前缀 ret 开头，如果不是，则将ret 尾巴减去一个字符
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;

    }
    public static void main(String[] args) {
        String ans = new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(ans);
    }
}