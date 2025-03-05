package leetcode_study.listnodes;

public class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void exitList() {
        ListNode current = new ListNode(this.val, this.next);

        while (current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode createListFromArray(int[] arr, int size) {
        if (size == 0) return null;

        ListNode l = new ListNode(arr[0]);
        ListNode cur = l;

        for (int i = 1; i < size; ++i) {
            ListNode temp = new ListNode(arr[i]);
            cur.next = temp;
            cur = temp;
        }

        return l;
    }

    public static ListNode addTwoNum(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;

    }
}
