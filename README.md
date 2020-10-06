# LeetCode-Java
## Backtracking
```
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```
* 排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
* 组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。

[89.Gray Code](https://leetcode-cn.com/problems/gray-code/)

[93. Restore IP Addresses](https://leetcode-cn.com/problems/restore-ip-addresses/)

## Dynamic Programing
[5. Longest Palindromic Substring](https://leetcode-cn.com/problems/longest-palindromic-substring/)

[滚动数组思想](https://leetcode-cn.com/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode-solution-2/)