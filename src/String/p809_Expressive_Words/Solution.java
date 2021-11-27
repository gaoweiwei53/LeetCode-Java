package p809_Expressive_Words;

public class Solution {
    public static int  expressiveWords(String s, String[] words) {
        int ans = 0;
        for(String word : words){
            if(check(s, word)){
                ans++;
            }
        }
        return ans;
    }
    private static boolean check(String s1, String s2){
        int i = s1.length() - 1, j = s2.length() - 1;
        while(i >= 0 && j >= 0 ){
            if(s1.charAt(i) != s2.charAt(j)){
                return false;
            }
            //算出s1.charAt(i)的重复字符数
            int k = i, cnt1 = 0;
            while(i >= 0 && s1.charAt(i) == s1.charAt(k)){
                i--;
                cnt1++;
            }
            //算出s2.charAt(j)的重复字符数
            int h = j, cnt2 = 0;
            while(j >= 0 && s2.charAt(j) == s2.charAt(h)){
                j--;
                cnt2++;
            }
            // cnt2 word
            if(cnt2 > cnt1) return false;
            if(cnt1 == 2 && cnt2 == 1) return false;
        }
        return i == j;
    }

    public static void main(String[] args) {
        String s = "helllooo";
        String[] words = new String[]{"hello"};
        System.out.println(expressiveWords(s, words));
    }
}
