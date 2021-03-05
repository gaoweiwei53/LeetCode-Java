# 优秀的解题方法
1) [二分 + 倍增乘法解法（含模板）](https://leetcode-cn.com/problems/divide-two-integers/solution/shua-chuan-lc-er-fen-bei-zeng-cheng-fa-j-m73b/)
2) [字符串相乘](https://leetcode-cn.com/problems/multiply-strings/solution/gao-pin-mian-shi-xi-lie-zi-fu-chuan-cheng-fa-by-la/)
3) [旋转图像/二位数组](https://leetcode-cn.com/problems/rotate-image/solution/ji-qiao-ti-zai-zeng-song-yi-wei-xing-shi-377z/)
4) [快速幂](https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/)
    - 快速幂算法的核心思想就是每一步都把指数分成两半，而相应的底数做平方运算。

5) [合并区间，贪心算法](https://leetcode-cn.com/problems/merge-intervals/solution/tan-xin-suan-fa-java-by-liweiwei1419-3/)
6) [区间问题](https://mp.weixin.qq.com/s/ioUlNa4ZToCrun3qb4y4Ow)
7) [快速排序](https://leetcode-cn.com/problems/sort-colors/solution/kuai-su-pai-xu-partition-guo-cheng-she-ji-xun-huan/)
8) [双指针](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/shuang-zhi-zhen-zhi-tong-xiang-zhi-zhen-che-di-jie/)
9) [合并有序数组](https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/)
10) [二叉树中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/dong-hua-yan-shi-94-er-cha-shu-de-zhong-xu-bian-li/)
11) [二分查找树](https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-7/)
12) [图解leetcode](https://leetcode-cn.com/leetbook/detail/illustrate-lcof/)
13) [二分查找树数量](https://leetcode-cn.com/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/)
15) [验证是否为有效的二分查找树](https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/)
# 1. Backtracking
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

# 2. Dynamic Programing
1)[5. Longest Palindromic Substring](https://leetcode-cn.com/problems/longest-palindromic-substring/)

2) [滚动数组思想](https://leetcode-cn.com/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode-solution-2/)
3) [53. Maximum Subarray](https://leetcode-cn.com/problems/maximum-subarray/)

# 3. Linklist
[21. Merge Two Sorted Lists](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
[动画解释](https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/)
### Two point
双指针模板
```
// Initialize slow & fast pointers
ListNode slow = head;
ListNode fast = head;
/**
 * Change this condition to fit specific problem.
 * Attention: remember to avoid null-pointer error
 **/
while (slow != null && fast != null && fast.next != null) {
    slow = slow.next;           // move slow pointer one step each time
    fast = fast.next.next;      // move fast pointer two steps each time
    if (slow == fast) {         // change this condition to fit specific problem
        return true;
    }
}
return false;   // change return value to fit specific problem
```
1. 在调用 next 字段之前，始终检查节点是否为空。  
获取空节点的下一个节点将导致空指针错误。例如，在我们运行 fast = fast.next.next 之前，需要检查 fast 和 fast.next 不为空。

2. 仔细定义循环的结束条件。

* [判断是否有环](https://leetcode-cn.com/problems/linked-list-cycle/)  
**方法:**：快慢指针是否相遇
* 判断环的入口  
**方法**：从头结点出发一个指针，从相遇节点 也出发一个指针，这两个指针每次只走一个节点， 那么当这两个指针相遇的时候就是 环形入口的节点
* 判断环的长度
* 返回倒数第k个节点  
**方法:** 让一个指针先走k步，然后两个指针一起走, 前面的走完时，后面的指针的位置即在倒数第k个位置 
* 返回中间节点  
**方法:** 快慢指针，快2慢1，快指针到达尾部，慢指针的位置即为中间的位置。偶数时，慢指针落在中间的前一个位置上
* [链表相交](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)  
**方法：** 双指针，先得到两个链表的长度差，两个指针再从距尾部相同距离的位置遍历，则相交的位置即为所求位置
* [删除倒数第n个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)  
**方法：** 使用一个dummy节点解决删除头节点的问题 可用一个指针和一个记录长度的变量完成
* [反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)  
**方法：** 使用双指针，1)cur指向head, pre指向null, 2)用tmp保存curr的下个节点, 3)将curr.next指向pre, 4)pre和curr分别向后移动一步.
递归方法不懂 
* [奇偶链表](https://leetcode-cn.com/problems/odd-even-linked-list/)  
**方法：** 将奇节点放在一个链表里，偶链表放在另一个链表里。然后把偶链表接在奇链表的尾部。使用了3个指针。
* [回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)  
**方法：** 反转一半链表后，将两个链表的节点按顺序一一比较
* [旋转链表](https://leetcode-cn.com/problems/rotate-list/)  
**方法：** 先将链表变为环，再找出新的头节点，切断环
  
1) [2. Add Two Numbers](https://leetcode-cn.com/problems/add-two-numbers/)
## 递归
1. [21. Merge Two Sorted Lists](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
[动画解释](https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/)
2. [24. Swap Nodes in Pairs](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)
3. [92. Reverse Linked List II](https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/)
# 3. Array
## 双指针
1) [283. Move Zeroes](https://leetcode-cn.com/problems/move-zeroes/)  
[解法](https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/)
2) [26. Remove Duplicates from Sorted Array](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)  
[题解](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/)
   
3) [11. Container With Most Water](https://leetcode-cn.com/problems/container-with-most-water/)
4) [15. 3Sum](https://leetcode-cn.com/problems/3sum/)
如何避免重复的结果? 排序!
   
5) [16. 3Sum Closest](https://leetcode-cn.com/problems/3sum-closest/)
6) [54. Spiral Matrix](https://leetcode-cn.com/problems/spiral-matrix/)

# Binary Search
二分查找一般由三个主要部分组成：
1) 预处理 —— 如果集合未排序，则进行排序。
2) 二分查找 —— 使用循环或递归在每次比较后将查找空间划分为两半。
3) 后处理 —— 在剩余空间中确定可行的候选者。
## 模板 1
```java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length - 1;
  while(left <= right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid - 1; }
  }

  // End Condition: left > right
  return -1;
}
```
区分语法

- 初始条件：left = 0, right = length-1
- 终止：left > right
- 向左查找：right = mid-1
- 向右查找：left = mid+1

## 模板二
```java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length;
  while(left < right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid; }
  }

  // Post-processing:
  // End Condition: left == right
  if(left != nums.length && nums[left] == target) return left;
  return -1;
}
```

### 区分语法

- 初始条件：left = 0, right = length
- 终止：left == right
- 向左查找：right = mid
- 向右查找：left = mid+1

## 模板三
```java
int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0)
        return -1;

    int left = 0, right = nums.length - 1;
    while (left + 1 < right){
        // Prevent (left + right) overflow
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }

    // Post-processing:
    // End Condition: left + 1 == right
    if(nums[left] == target) return left;
    if(nums[right] == target) return right;
    return -1;
}
```
区分语法

- 初始条件：left = 0, right = length-1
- 终止：left + 1 == right
- 向左查找：right = mid
- 向右查找：left = mid

## 题目
1) [局部有序二分查找 33. Search in Rotated Sorted Array](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
2) [153. Find Minimum in Rotated Sorted Array](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)
3) [34. Find First and Last Position of Element in Sorted Array](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
4) [没理解题目意思 658. Find K Closest Elements](https://leetcode-cn.com/problems/find-k-closest-elements/)
5) [35. Search Insert Position](https://leetcode-cn.com/problems/search-insert-position/https://leetcode-cn.com/problems/search-insert-position/)
6) [74. Search a 2D Matrix](https://leetcode-cn.com/problems/search-a-2d-matrix/)
# 滑动窗口
1) [3. Longest Substring Without Repeating Characters](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

# String
1) [不懂 6. ZigZag Conversion](https://leetcode-cn.com/problems/zigzag-conversion/)

# Math and String
- `currChar - '0'`: 可将字符转为数字
- 将int转为字符串
    1) `String s = String.valueOf(a);`
    2) `String s1 = a + "";`
    3) `String s2 = Integer.toString(a);`

1) [7. Reverse Integer](https://leetcode-cn.com/problems/reverse-integer/)
[溢出](https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/)
   
2) [8. String to Integer (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/)
3) [9. Palindrome Number](https://leetcode-cn.com/problems/palindrome-number/)
4) [28. Implement strStr()](https://leetcode-cn.com/problems/implement-strstr/)
> 涉及KMP算法

5) [29. Divide Two Integers](https://leetcode-cn.com/problems/divide-two-integers/) ****
6) [43. Multiply Strings](https://leetcode-cn.com/problems/multiply-strings/)

# 栈
1) [20. Valid Parentheses](https://leetcode-cn.com/problems/valid-parentheses/)

# 分治、动态规划、贪心
1) 分治

分治（即分而治之），把一个复杂的问题分成多个相同或相似的子问题，再把子问题分成更小的子问题……直到最后子问题可以简单的直接求解，原问题的解即子问题的解的合并。

适用场景：二分搜索、归并排序、快速排序、大整数乘法、第K小元素、最近点对、快速傅里叶变换等。



2) 动态规划

动态规划法也是把问题一层一层地分解为规模逐渐减小的同类型的子问题。动态规划通常用来求最优化问题。此类问题可以有很多可行解，我们求出的是一个最优解，可能存在多个最优解。（最优子结构、公共子问题）

与分治法的区别是：分治的子问题是相互独立的，动态规划最好解决有公共子问题的，子问题相关性很大。

使用场景：矩阵连乘、钢条切割、最长公共子序列、最优二叉搜索树、流水作业调度、0/1背包问题等。



3) 贪心

通过局部最优选择达到全局最优选择。贪心算法不一定总产生最优解，贪心算法是否产生优化解，需严格证明贪心算法产生最优解的条件：（最优子结构、贪心选择性）

贪心选择性：当一个问题的全局最优解可以通过局部最优解得到，称这个问题具有贪心选择性。

适用场景：活动选择问题、哈夫曼编码问题、最小生成树问题、单源最短路径问题等

# 二叉树
1) [94. Binary Tree Inorder Traversal](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
# 二分查找树
## 定义
1. 若它的左子树不为空，则左子树上所有结点的值均小于等于根结点的值；
2. 若它的右子树不为空，则右子树上所有结点的值均大于等于根结点的值；
3. 它的左右子树均为二分查找树

## 题目
1) [95. Unique Binary Search Trees II](https://leetcode-cn.com/problems/unique-binary-search-trees-ii/)
2) [96. Unique Binary Search Trees](https://leetcode-cn.com/problems/unique-binary-search-trees/)
3) [98. Validate Binary Search Tree](https://leetcode-cn.com/problems/validate-binary-search-tree/)