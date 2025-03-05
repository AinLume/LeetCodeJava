package leetcode_study.listnodes;

public class TwentyFour {
    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummy_head = new ListNode();
        ListNode prev = dummy_head;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            prev.next = cur.next;
            cur.next = prev.next.next;
            prev.next.next = cur;

            prev = cur;
            cur = cur.next;
        }

        return dummy_head.next;
    }
}
