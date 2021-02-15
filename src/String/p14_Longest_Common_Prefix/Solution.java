package p14_Longest_Common_Prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
/*        if (strs.length == 0) return "";
        int minLen = strs[0].length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        for (int i = 0; i < minLen ; i++) {
            char preFix = strs[0].charAt(i);
            for ( int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != preFix){
                    return stringBuffer.toString();
                }
                if (j == strs.length - 1){
                    stringBuffer.append(preFix);
                }
            }
        }
        return stringBuffer.toString();*/

        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        String ans = new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(ans);
    }
}
