package p58_Length_of_Last_Word;

class Solution {
    public int lengthOfLastWord(String s) {
        int len =0;
        boolean flag = true;
        for(int i = s.length() - 1; i>=0; i--){
            if(flag == true && s.charAt(i) == ' '){
                continue;
            }

            if(s.charAt(i) != ' '){
                len++;
                flag = false;
            }
            else{
                if(s.charAt(i) == ' '){
                    break;
                }
            }
        }
        return len;

/*        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;*/
    }
}
