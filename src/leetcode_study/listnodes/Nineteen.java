package leetcode_study.listnodes;


public class Nineteen {
    public static int ListLen(ListNode head) {
        if (head == null) return 0;

        ListNode current = head;
        int len = 1;
        while(current.next != null) {
            ++len;
            current = current.next;
        }

        return len;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        int i = 1;
        int need = ListLen(head) - n + 1;

        if (need == 1) return head.next;

        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            if (i == need) {
                cur = cur.next;
                prev.next = cur;
                ++i;
            }
            else {
                ++i;
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
