package Amazon;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    class DLinkedListNode{
        int key;
        int val;
        DLinkedListNode prev;
        DLinkedListNode next;
    }

    public void addNode(DLinkedListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DLinkedListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void moveToHead(DLinkedListNode node) {
        removeNode(node);
        addNode(node);
    }

    public DLinkedListNode popTail() {
        DLinkedListNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
    }

    private Map<Integer, DLinkedListNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedListNode head, tail;

    public int get(int key) {
        DLinkedListNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedListNode node = cache.get(key);
        if (node == null) {
            DLinkedListNode newNode = new DLinkedListNode();
            newNode.key = key;
            newNode.val = value;
            cache.put(key, newNode);
            addNode(newNode);
            size++;
            if (size > capacity) {
                DLinkedListNode rem = popTail();
                cache.remove(rem.key);
                size--;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }
}
