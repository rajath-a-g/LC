public class MyLinkedList {
    class LNode {
        int val;
        LNode next;
    }
    LNode head = null;
    int size = 0;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index > size) return -1;
        else {
            int i = 0;
            LNode node = head;
            while (i++  < index) {
                node = node.next;
            }
            return node.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        LNode newNode = new LNode();
        newNode.val = val;
        newNode.next = head;
        head = newNode;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (size == 0) {
            LNode node = new LNode();
            node.val = val;
            head = node;
        }
        LNode next = head;
        while (next.next != null) next = next.next;
        LNode newNode = new LNode();
        next.next = newNode;
        newNode.val = val;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        else if (index == 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else {
            LNode next = head;
            int i = 0;
            while (i++ < index - 1) {
                next = next.next;
            }
            LNode newNode = new LNode();
            newNode.val = val;
            newNode.next = next.next;
            next.next = newNode;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) return;
        LNode node = head;
        int i = 0;
        while (i++ < index - 1) node = node.next;
        node.next = node.next.next;
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1,2);
        int param_1 = obj.get(1);
        System.out.println(param_1);
        obj.deleteAtIndex(1);
        int param_2 = obj.get(1);
        System.out.println(param_2);
        MyLinkedList obj1 = new MyLinkedList();
        obj1.addAtHead(1);
        obj1.deleteAtIndex(0);
    }
}
