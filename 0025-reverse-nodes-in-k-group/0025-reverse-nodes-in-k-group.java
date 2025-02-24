class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        while (current != null) {
            ListNode groupStart = current;
            ListNode groupEnd = getGroupEnd(current, k);

            if (groupEnd == null) break;

            prevGroupEnd.next = reverseList(groupStart, groupEnd.next);
            prevGroupEnd = groupStart;
            current = prevGroupEnd.next;
        }

        return dummy.next;
    }

    private ListNode getGroupEnd(ListNode start, int k) {
        ListNode end = start;
        for (int i = 1; i < k && end != null; i++) {
            end = end.next;
        }
        return end;
    }

    private ListNode reverseList(ListNode start, ListNode end) {
        ListNode prev = end;
        ListNode current = start;

        while (current != end) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}