package p151_Reverse_Words_in_a_String;

import java.util.*;

class Solution {
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    // 自己编写函数
    public String reverseWords2(String s) {
        StringBuilder sb = trimSpaces(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }

    // 3. 双端队列
    public String reverseWords3(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
    // 1 ms 击败 100%
    public String reverseWords4(String s) {
        char[] str = s.toCharArray();
        char[] arr = new char[str.length+1];
        int left = str.length-1;
        int right = str.length-1;
        int index = 0;
        while(true){
            while(right >= 0 && str[right]==' '){
                right--;
            }
            left = right;
            while(left >= 0 && str[left] != ' '){
                left--;
            }
            for(int i = left + 1;i <= right; i++){
                arr[index++] = str[i];
                if(i == right){
                    arr[index++] = ' ';
                }
            }
            right = left;
            if(right < 0){break;}
        }
        return (new String(arr)).substring(0,index-1);
    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        new Solution().reverseWords4(s);

    }

}
// 自己写的 较慢 9ms
class Solution2 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strs = s.split("\\s+");
        reverse(strs);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++){
            if(i == strs.length - 1){
                sb.append(strs[i]);
            } else{
                sb.append(strs[i] + " ");
            }
        }
        return sb.toString();
    }
    private void reverse(String[] strs){
        int l = 0, r = strs.length - 1;
        while( l < r){
            String tmp = strs[l];
            strs[l] = strs[r];
            strs[r] = tmp;
            l++;
            r--;
        }
    }
}
