package March2021;
class Node {
    int val;
    Node next;
    Node prev;
    Node (int val) {
        this.val = val;
    }
}
class MyLinkedList {
    int size;
    Node head, tail;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size)
            return -1;
        Node cur = head.next;
        while (cur != null) {
            index--;
            if (index < 0)
                return cur.val;
            cur = cur.next;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node temp = tail.prev;
        tail.prev = newNode;
        newNode.next = tail;
        newNode.prev = temp;
        temp.next = newNode;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index == size) {
            this.addAtTail(val);
            return;
        }
        if (index == 0) {
            this.addAtHead(val);
            return;
        }
        Node cur = head.next;
        while (cur != null) {
            index--;
            if (index < 0)
                break;
            cur = cur.next;
        }
        Node newNode = new Node(val);
        newNode.prev = cur.prev;
        cur.prev.next = newNode;
        cur.prev = newNode;
        newNode.next = cur;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size)
            return;
        Node cur = head.next;
        while (cur != null) {
            index--;
            if (index < 0)
                break;
            cur = cur.next;
        }
        cur.next.prev = cur.prev;
        cur.prev.next = cur.next;
    }

    public void printList() {
        Node cur = head.next;
        System.out.println();
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
    }
}

class Sol {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.printList();
        myLinkedList.addAtHead(2);
        myLinkedList.printList();
        myLinkedList.addAtHead(1);
        myLinkedList.printList();
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.printList();
        myLinkedList.deleteAtIndex(2);
        myLinkedList.printList();
        myLinkedList.addAtHead(6);
        myLinkedList.printList();
        myLinkedList.addAtTail(4);
        myLinkedList.printList();
        System.out.println(myLinkedList.get(4));
        myLinkedList.printList();
        myLinkedList.addAtHead(4);
        myLinkedList.printList();
        myLinkedList.addAtIndex( 5, 0);
        myLinkedList.printList();
        myLinkedList.addAtHead(6);
        myLinkedList.printList();

    }
}
