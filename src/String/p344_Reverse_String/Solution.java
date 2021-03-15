package p344_Reverse_String;

import java.io.Writer;

class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int p1 = 0, p2 = len-1;
        while (p1 < p2 ){
            char tmp = s[p1];
            s[p1] = s[p2];
            s[p2] = tmp;
            p1++;
            p2--;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l'};
        new Solution().reverseString(s);
        for (char c: s){
            System.out.println(c);
        }
    }

}

