package p707_Design_Linked_list;

public class MyDoublyLinkedList<E> {
    int size = 0;
    Node<E> fist;
    Node<E> last;

    public MyDoublyLinkedList(){}

    class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E item, Node<E> next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
