package LinkedList;

public class reverse {

    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode curr;
        ListNode prev = null;
        ListNode next;

        curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        reverseList(node1);
    }
}
