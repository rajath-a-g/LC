/*
 * Copyright (c) 2020 Author: Rajath
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Leet61 {
    public static void main(String[] args) {
        Leet61 leet61 = new Leet61();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = leet61.rotateRight(head, 2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode copyHead = head;
        int len = 1;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
            len++;
        }
        copyHead.next = head;
        for (int i = len - k % len; i > 1; i--)
            head = head.next;
        copyHead = head.next;
        head.next = null;
        return copyHead;
    }
}
