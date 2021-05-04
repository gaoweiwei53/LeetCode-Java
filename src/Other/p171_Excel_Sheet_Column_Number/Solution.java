package p171_Excel_Sheet_Column_Number;

class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for(int i=0; i< columnTitle.length(); i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    // 26进制转为10进制
    public int convert26To10(String s){
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            ans = ans * 26 + num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert26To10("11"));
    }
}