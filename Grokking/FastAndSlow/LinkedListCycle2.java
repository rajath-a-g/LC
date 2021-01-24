package Grokking.FastAndSlow;

public class LinkedListCycle2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x, ListNode nex) {
            val = x;
            next = nex;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(3);
        ListNode first = new ListNode(2);
        list1.next = first;
        ListNode second = new ListNode(0, new ListNode(-4, first));
        first.next = second;
        System.out.println("List1 has cycle?:" + detectCycle(list1).val);
        ListNode list2 = new ListNode(1);
        ListNode sec = new ListNode(2);
        list2.next = sec;
        sec.next = list2;
        System.out.println("List1 has cycle?:" + detectCycle(list2).val);
        ListNode list3 = new ListNode(1);
        System.out.println("List1 has cycle?:" + (detectCycle(list3) == null));
    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast;
    }
}
