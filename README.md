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

## Two point
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