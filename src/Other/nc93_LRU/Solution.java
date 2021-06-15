package nc93_LRU;

import java.util.*;

public class Solution {
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    private int k;
    public int[] LRU (int[][] operators, int k) {
        this.k = k;
        head.next = tail;
        tail.prev = head;
        int len = (int)Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[len];
        for(int i = 0, j = 0; i < operators.length; i++) {
            if(operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                res[j++] = get(operators[i][1]);
            }
        }
        return res;
    }

    private void set(int key, int val) {
        if(get(key) > -1) {
            map.get(k).val = val;
        } else {
            if(map.size() == k) {
                int rk = tail.prev.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                map.remove(rk);
            }
            Node node = new Node(key, val);
            map.put(key, node);
            moveToHead(node);
        }
    }

    private int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    static class Node{
        int key, val;
        Node prev, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
class Solution2 {
    int k;
    int size;
    // 伪头节点和尾节点
    DLinkedNode head;
    DLinkedNode tail;
    Map<Integer, DLinkedNode> cache = new HashMap<>();
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
        this.size = 0;
        this.k = k;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;

        int len = (int)Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[len];
        for(int i = 0, j = 0; i < operators.length; i++) {
            if(operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                res[j++] = get(operators[i][1]);
            }
        }
        return res;
    }
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public int get(int key){
        if(cache.containsKey(key)){
            moveToHead(cache.get(key));
            return cache.get(key).value;
        }
        else{
            return -1;
        }
    }
    public void set(int key, int value){
        DLinkedNode tmpNode = cache.get(key);
        if(tmpNode != null){
            tmpNode.value = value;
            moveToHead(tmpNode);
        }
        else{
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            if(size == k){
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                addToHead(newNode);
            }
            else {
                addToHead(newNode);
            }
        }

    }
    private void moveToHead(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
    private void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }
    private DLinkedNode removeTail(){
        DLinkedNode node = tail.pre;
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
        size--;
        return node;
    }
    private void addToHead(DLinkedNode node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
        size++;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int[] res = new Solution2().LRU(input,3);
        for (int i : res) {
            System.out.println(i);
        }
    }
}