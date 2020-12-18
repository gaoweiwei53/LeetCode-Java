package LinkedList.p707_Design_Linked_list;

import java.util.LinkedList;

public class MyLinkedList {

    int size;
    Node head;

    class Node{
        int val;
        Node next;
        Node(int x){
            this.val = x;
        }
    }
    public MyLinkedList(){
        size = 0;
        head = new Node(0);
    }
    public int get(int index){
        // if index is invalid
        // 注意 是 index 大于等于 size
        if (index < 0 || index >= size) return -1;
        Node curr = head;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    public void addAtHead(int val){
        addAtIndex(0, val);
    }
    public void addAtTail(int val) { addAtIndex(size, val); }
    public void addAtIndex(int index, int val){

        if (index > size) return;
        if (index < 0) index = 0;
        ++size;
        Node pred = head;
        for (int i = 0; i < index; i++) {
            pred  = pred.next;
        }
        Node new_node = new Node(val);
        new_node.next = pred.next;
        pred.next = new_node;
    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) return;
        size--;
        Node pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(0);
        list.addAtIndex(1,1);
        list.addAtIndex(2,2);
        list.addAtTail(3);
        int val = list.get(2);
        list.deleteAtIndex(2);
    }
}
