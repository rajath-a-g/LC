package Grokking.FastAndSlow;

class ListNode {
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

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(3);
        ListNode first = new ListNode(2);
        list1.next = first;
        ListNode second = new ListNode(0, new ListNode(-4, first));
        first.next = second;
        System.out.println("List1 has cycle?:" + hasCycle(list1));
        ListNode list2 = new ListNode(1);
        ListNode sec = new ListNode(2);
        list2.next = sec;
        sec.next = list2;
        System.out.println("List1 has cycle?:" + hasCycle(list2));
        ListNode list3 = new ListNode(1);
        System.out.println("List1 has cycle?:" + hasCycle(list3));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
