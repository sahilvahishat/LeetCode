package LinkedList;

import java.util.*;

public class MergeKSort {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newList = null;
        ListNode head = null;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ListNode curr : lists) {
            while (curr != null) {
                pq.add(curr.val);
                curr = curr.next;
            }
        }

        while (!pq.isEmpty()) {
            if (newList == null) {
                newList = new ListNode();
                newList.val = pq.poll();
                newList.next = null;
                head = newList;
            } else {
                ListNode newNode = new ListNode();
                newNode.val = pq.poll();
                newList.next = newNode;
                newList = newList.next;
            }

        }

        return head;
    }
}
