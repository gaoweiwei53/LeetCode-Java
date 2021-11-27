package p93_restore_ip_address;

import java.util.*;

class Solution{
    List<String> res = new ArrayList<>();
    Deque<String> path = new ArrayDeque<>(4);
    String s;
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        dfs(0, 4);
        return res;
    }
    //剔除一些不变量，最后只保留当前索引和剩余段数

    // reside 剩余段数
    public void dfs(int begin, int reside){
        if(begin == s.length()){
            //当遍历到最后一个字符且剩余段数为0时，将此时的path添加到结果中
            if(reside==0){
                res.add(String.join(".", path));
            }
            return;
        }
        //每段最多只截取3个数
        for(int i = begin; i < begin + 3; i++){
            if(i >= s.length())
                break;
            //字符串剩余长度和分段所需长度
            if(s.length() - i > reside * 3)
                continue;
            //当截取的字符串满足条件
            if(judgeNumber(s, begin, i)){
                String curS = s.substring(begin, i + 1);
                path.addLast(curS);
                dfs(i + 1, reside - 1);
                path.removeLast();
            }
        }
    }

    public boolean judgeNumber(String s, int left, int right){
        int len = right - left + 1;
        //当前为0开头的且长度大于1的数字需要剪枝
        if(len > 1 && s.charAt(left) == '0')
            return false;
        //将当前截取的字符串转化成数字
        int res = Integer.parseInt(s.substring(left, right+1));
        //判断截取到的数字是否符合
        return res >= 0 && res <= 255;
    }
    public static void main(String[] args) {
        List<String> res = new Solution().restoreIpAddresses("255 25511135");
        System.out.println(res);
    }
}
class Solution2 {
    List<String> ans = new ArrayList<>();
    // 存储一个可行的IP
    int[] segs;
    static final int count = 4;
    int n;
    String s;
    public List<String> restoreIpAddresses(String s) {
        this.n = s.length();
        this.s = s;
        segs = new int[count];
        dfs(0,0);
        return ans;
    }
    public void dfs(int segId,int index){
        if(segId==4){
            if(index == n){
                StringBuilder stb = new StringBuilder();
                for(int i = 0;i < count;i++){
                    stb.append(segs[i]);
                    if(i!=3){
                        stb.append('.');
                    }
                }
                ans.add(stb.toString());
            }
            return;
        }
        if(index == n){
            return;
        }
        if(s.charAt(index) == '0'){
            segs[segId] = 0;
            dfs(segId+1,index+1);
            return;
        }
        int seg = 0;
        for(int i = index;i < n;i++){
            seg = seg * 10 + (s.charAt(i) - '0');
            if(seg > 0 && seg <= 255){
                segs[segId] = seg;
                dfs(segId+1,i+1);
            }else{
                return;
            }
        }
    }
}