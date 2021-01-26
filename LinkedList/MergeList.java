package LinkedList;

public class MergeList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        while (l1 != null || l2 != null) { // 1 1 1 //2 3 4

            // if l1 is empty just add l2 and vice versa
            if (l1 == null) {
                curr.next = l2;
                return head;
            }
            if (l2 == null) {
                curr.next = l1;
                return head;
            }
            if (l1.val < l2.val) {
                if (head == null) {
                    head = l1;
                    curr = head; // curl1 == head =1
                } else {
                    curr.next = l1;
                    curr = curr.next; // 1-->1
                }
                l1 = l1.next;
            } else if (l1.val >= l2.val) {
                if (head == null) {
                    head = l2;
                    curr = head; // curl1 == head =1
                } else {
                    curr.next = l2;
                    curr = curr.next; // 1-->1
                }
                l2 = l2.next;
            }

        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node4;
        node4.next = null;

        ListNode node10 = new ListNode(1);
        ListNode node30 = new ListNode(3);
        ListNode node40 = new ListNode(4);

        node10.next = node30;
        node30.next = node40;
        node40.next = null;

        mergeTwoLists(node1, node10);
    }
}