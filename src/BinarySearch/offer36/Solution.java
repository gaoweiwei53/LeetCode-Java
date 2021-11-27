package offer36;


public class Solution {
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        dfs(root);

        pre.right = head;
        head.left =pre;//进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的

        return head;

    }
    public void dfs(Node root){
        if(root==null) return;
        dfs(root.left);
        //pre用于记录双向链表中位于root左侧的节点，即上一次迭代中的root,
        // 当pre==null时，root左侧没有节点,即此时root为双向链表中的头节点
        //反之，pre!=null时，root左侧存在节点pre，需要进行pre.right=root的操作
        if(pre == null){
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;//pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的

        pre = root;//pre指向当前的root
        dfs(root.right);//全部迭代完成后，pre指向双向链表中的尾节点
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
