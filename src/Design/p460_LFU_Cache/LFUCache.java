package p460_LFU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU的实现是一个哈希表加上一个双链表
 * 而LFU则要复杂多了，需要用两个哈希表再加上N个双链表才能实现
 */

/**
 *  LFU需要两个hash表，一个Hash表key就是输入的key，value是Node对象，
 *  其内部包含(key, value, 频率)
 *  另一个Hash表的key是频率，value是一个双向链表，Node对象是链表的节点
 */

/**
 * 具体操作：
 * get: 1) 如果key不存在则返回-1 2) 如果key存在，则返回对应的value，同时将元素的访问频率+1
 * 将元素从访问频率i的链表中移除，放到频率i+1的链表中如果频率i的链表为空，则从频率哈希表中移除这个链表
 */

/**
 * put操作：
 * 1) 如果key已经存在，修改对应的value，并将访问频率+1,将元素从访问频率i的链表中移除，放到频率i+1的链表中
 * 如果频率i的链表为空，则从频率哈希表中移除这个链表
 * 2) 如果key不存在 缓存超过最大容量，则先删除访问频率最低的元素，再插入新元素。新元素的访问频率为1，
 * 如果频率哈希表中不存在对应的链表需要创建。缓存没有超过最大容量，则插入新元素。新元素的访问频率为1，
 * 如果频率哈希表中不存在对应的链表需要创建
 */

// 还需要维护一个minFreq的变量，用来记录LFU缓存中频率最小的元素，在缓存满的时候，可以快速定位到最小频繁的链表
public class LFUCache {
    /**
     *    双链表中的链表节点对象
     */
    protected static class Node{
        //对应输入的key
        private final int key;

        //对应输入的value
        private int value;

        //被访问的频率
        private int freq;

        //指向前一个节点的指针
        protected Node pre;

        //指向后一个节点的指针
        protected Node next;

        public Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }

        public Node(int key, int value, int freq, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.freq = freq;
            this.pre = null;
            this.next = null;
        }

        public void updateValue(int value) {
            this.value = value;
        }

        public void incrFreq() {
            ++this.freq;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }

        public int getFreq() {
            return this.freq;
        }

        public static final Node createEmptyNode() {
            return new Node(-1,-1,-1,null,null);
        }
    }

    /**
     *  自定义的双向链表类
     */
    protected static class LinkedList {
        //双向链表的头结点
        private final Node head;

        //双向链表的尾节点
        private final Node tail;
        public LinkedList() {
            this.head = Node.createEmptyNode();
            this.tail = Node.createEmptyNode();
            this.head.next = this.tail;
            this.tail.pre = this.head;
        }

        /**
         * 将指定的节点插入到链表的第一个位置
         * @param node 将要插入的节点
         */
        public void insertFirst(Node node) {
            if(node==null) {
                throw new IllegalArgumentException();
            }
            node.next = this.head.next;
            this.head.next.pre = node;
            node.pre = this.head;
            this.head.next = node;
        }

        /**
         * 从链表中删除指定的节点
         * @param node 将要删除的节点
         */
        public void deleteNode(Node node) {
            if(node==null) {
                throw new IllegalArgumentException();
            }
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = null;
            node.next = null;
        }

        /**
         * 从链表中获取最后一个节点
         * @return 双向链表中的最后一个节点，如果是空链表则返回None
         */
        public Node getLastNode() {
            if(this.head.next==this.tail) {
                return Node.createEmptyNode();
            }
            return this.tail.pre;
        }

        /**
         * 判断链表是否为空，除了head和tail没有其他节点即为空链表
         * @return 链表不空返回True，否则返回False
         */
        public boolean isEmpty() {
            return this.head.next==this.tail;
        }
    }

    //key->Node 这种结构的哈希表
    private final Map<Integer,Node> keyMap = new HashMap<Integer,Node>();

    //freq->LinkedList 这种结构的哈希表
    private final Map<Integer,LinkedList> freqMap = new HashMap<Integer,LinkedList>();

    //缓存的最大容量
    private final int capacity;

    //记录缓存中最低频率
    private int minFreq = 0;

    public LFUCache(int capacity) {
//		if(capacity<=0) {
//			throw new IllegalArgumentException();
//		}
        this.capacity = capacity;
    }

    /**
     * 获取一个元素，如果key不存在则返回-1，否则返回对应的value，同时更新被访问元素的频率
     * @param key 要查找的关键字
     * @return 如果没找到则返回-1，否则返回对应的value
     */
    public int get(int key) {
        if(!this.keyMap.containsKey(key)) {
            return -1;
        }
        Node node = this.keyMap.get(key);
        this.increment(node);
        return node.getValue();
    }

    /**
     * 插入指定的key和value，如果key存在则更新value，同时更新频率，
     * 如果key不存并且缓存满了，则删除频率最低的元素，并插入新元素。否则，直接插入新元素
     * @param key 要插入的关键字
     * @param value 要插入的值
     */
    public void put(int key, int value) {
        if(this.keyMap.containsKey(key)) {
            Node node = this.keyMap.get(key);
            node.updateValue(value);
            this.increment(node);
        }
        else {
            if(this.capacity==0) {
                return;
            }
            if(this.keyMap.size()==this.capacity) {
                this.remoteMinFreqNode();
            }
            Node node = new Node(key,value,1);
            this.increment(node,true);
            this.keyMap.put(key, node);
        }
    }


    /**
     * 更新节点的访问频率
     * @param node 要更新的节点
     */
    private void increment(Node node) {
        increment(node,false);
    }

    /**
     * 更新节点的访问频率
     * @param node 要更新的节点
     * @param isNewNode 是否是新节点，新插入的节点和非新插入节点更新逻辑不同
     */
    private void increment(Node node,boolean isNewNode) {
        if(isNewNode) {
            this.minFreq = 1;
            this.insertToLinkedList(node);
        }
        else {
            this.deleteNode(node);
            node.incrFreq();
            this.insertToLinkedList(node);
            if(!this.freqMap.containsKey(this.minFreq)) {
                ++this.minFreq;
            }
        }
    }

    /**
     * 根据节点的频率，插入到对应的LinkedList中，如果LinkedList不存在则创建
     * @param node 将要插入到LinkedList的节点
     */
    private void insertToLinkedList(Node node) {
        if(!this.freqMap.containsKey(node.getFreq())) {
            this.freqMap.put(node.getFreq(), new LinkedList());
        }
        LinkedList linkedList = this.freqMap.get(node.getFreq());
        linkedList.insertFirst(node);
    }

    /**
     * 删除指定的节点，如果节点删除后，对应的双链表为空，则从__freqMap中删除这个链表
     * @param node 将要删除的节点
     */
    private void deleteNode(Node node) {
        LinkedList linkedList = this.freqMap.get(node.getFreq());
        linkedList.deleteNode(node);
        if(linkedList.isEmpty()) {
            this.freqMap.remove(node.getFreq());
        }
    }

    /**
     * 删除频率最低的元素，从freqMap和keyMap中都要删除这个节点，
     * 如果节点删除后对应的链表为空，则要从__freqMap中删除这个链表
     */
    private void remoteMinFreqNode() {
        LinkedList linkedList = this.freqMap.get(this.minFreq);
        Node node = linkedList.getLastNode();
        linkedList.deleteNode(node);
        this.keyMap.remove(node.getKey());
        if(linkedList.isEmpty()) {
            this.freqMap.remove(node.getFreq());
        }
    }
    public static void main(String[] args) {

    }
}
